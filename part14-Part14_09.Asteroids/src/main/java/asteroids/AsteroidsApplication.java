package asteroids;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import java.util.HashMap;
import javafx.animation.AnimationTimer;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import asteroids.domain.*;

public class AsteroidsApplication extends Application {

    /*
    note to anyone who is reviewing this in the future:
    this project was modified after fulfilling the original requirements of the project, as I wanted to improve upon some of the mechanics that were... lacking.
    Nothing major was changed, but I thought it prudent to include this disclaimer of sorts.

    But, I was able to adjust the fire rate and add restart functionality, so, meh. :P
    */
    

    private Pane gamePane;
    private Scene gameplayScene;
    private boolean gamePaused;

    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    AtomicInteger points = new AtomicInteger();
    private long timeLastProjectileShot;

    public static void main(String[] args) {
        launch(args);
    }

    public void initAsteroids(List asteroids) {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            Asteroid asteroid = new Asteroid(random.nextInt(WIDTH / 3), random.nextInt(HEIGHT));
            asteroids.add(asteroid);
            gamePane.getChildren().add(asteroid.getEntity());
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.gamePane = new Pane();
        this.gameplayScene = new Scene(gamePane);
        gamePane.setPrefSize(WIDTH, HEIGHT);

        PlayerShip playerShip = new PlayerShip(WIDTH / 2, HEIGHT / 2);
        gamePane.getChildren().add(playerShip.getEntity());
        HashMap<KeyCode, Boolean> playerInput = new HashMap();

        Text text = new Text(10, 20, "Points: 0");
        gamePane.getChildren().add(text);

        gameplayScene.setOnKeyPressed(event -> {
            playerInput.put(event.getCode(), Boolean.TRUE);
        });

        gameplayScene.setOnKeyReleased(event -> {
            playerInput.put(event.getCode(), Boolean.FALSE);
        });

        List<Asteroid> asteroids = new ArrayList();
        initAsteroids(asteroids);

        List<Projectile> projectiles = new ArrayList<>();

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (!gamePaused) {
                    text.setText("Points: " + points);

                    if (Math.random() < 0.010 && asteroids.size() < 10) {
                        Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                        if (!asteroid.collidingWith(playerShip)) {
                            asteroids.add(asteroid);
                            gamePane.getChildren().add(asteroid.getEntity());
                        }
                    }

                    if (playerInput.getOrDefault(KeyCode.LEFT, false)) {
                        playerShip.turnLeft();
                    }
                    if (playerInput.getOrDefault(KeyCode.RIGHT, false)) {
                        playerShip.turnRight();
                    }
                    if (playerInput.getOrDefault(KeyCode.UP, false)) {
                        playerShip.accelerate();
                    }
                    if (playerInput.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 5) { //if spacebar is being pressed and there are less than 5 projectiles on screen
                        //shooting a projectile:
                        long currentTime = System.currentTimeMillis();
                        if (currentTime - timeLastProjectileShot >= 250) { //checking to see if 250 miliseconds have passed since we last attempted to shoot a projectile
                            Projectile projectile = new Projectile((int) playerShip.getEntity().getTranslateX(), (int) playerShip.getEntity().getTranslateY()); //making a new projectile on keypress
                            projectile.getEntity().setRotate(playerShip.getEntity().getRotate()); //make sure the projectile is in the same orientation as the ship
                            projectiles.add(projectile); //add the projectile to list

                            projectile.accelerate(); //propel the projectile
                            projectile.setEntityVelocity(projectile.getEntityVelocity().normalize().multiply(3)); //triples the speed of the projectile's base velocity, as it isn't fast enough

                            gamePane.getChildren().add(projectile.getEntity()); //add the projectile to be drawn on the screen

                            timeLastProjectileShot = currentTime; //update when we last shot a projectile
                        }
                    }
                    asteroids.forEach(asteroid -> { //for every asteroid currently present
                        if (playerShip.collidingWith(asteroid)) { //check if it is colliding with the playerShip
                            gamePaused = true; //if so, pause the game loop
                            System.out.println("hit by: " + asteroid.getEntityVelocity().toString() + "\n playercords: " + playerShip.getEntityVelocity().toString()); //record the coordinates of collision for debugger
                        }
                        projectiles.forEach(projectile -> { //for each projectile currently present
                            if (projectile.collidingWith(asteroid)) { //check if it is colliding with the asteroid we are currently iterating over
                                projectile.setAlive(false); // if so, kill the projectile
                                asteroid.setAlive(false); //and kill the asteroid
                            }
                        });
                        if (!asteroid.isAlive()) {
                            text.setText("Points: " + points.addAndGet(1));
                        }
                    });

                    projectiles.stream().filter(projectile -> !projectile.isAlive()).forEach(projectile -> {
                        gamePane.getChildren().remove(projectile.getEntity());
                    });
                    projectiles.removeAll(projectiles.stream().filter(projectile -> !projectile.isAlive()).collect(Collectors.toList()));

                    asteroids.stream().filter(asteroid -> !asteroid.isAlive()).forEach(asteroid -> {
                        gamePane.getChildren().remove(asteroid.getEntity());
                    });
                    asteroids.removeAll(asteroids.stream().filter(asteroid -> !asteroid.isAlive()).collect(Collectors.toList()));

                    playerShip.move();
                    asteroids.forEach(asteroid -> asteroid.move());
                    projectiles.forEach(projectile -> projectile.move());

                }

                if (gamePaused) {
                    if (playerInput.getOrDefault(KeyCode.ESCAPE, false)) {
                        points.set(0);
                        asteroids.forEach(asteroid -> gamePane.getChildren().remove(asteroid.getEntity()));
                        projectiles.forEach(projectile -> gamePane.getChildren().remove(projectile.getEntity()));
                        projectiles.clear();
                        asteroids.clear();
                        initAsteroids(asteroids);
                        System.out.println("Coords of ship: " + playerShip.getEntityVelocity());
                        playerShip.getEntity().setTranslateX(WIDTH / 2);
                        playerShip.getEntity().setTranslateY(HEIGHT / 2);
                        playerShip.setEntityVelocity(new Point2D(0, 0));
                        System.out.println(gamePane.getChildren().toString());

                        gamePaused = false;
                    }
                }

            }
        }.start();

        stage.setTitle("Asteroids!");
        stage.setScene(gameplayScene);
        stage.show();
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;   //hehe, i am da winnar :D
    }
}
