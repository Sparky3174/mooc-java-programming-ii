package asteroids.domain;

import asteroids.domain.PolygonFactory;
import java.util.Random;

public class Asteroid extends Entity {

    private double rotationalIncrement; //defines the amount that the asteroid will rotate each frame

    public Asteroid(int x, int y) {
        super(new PolygonFactory().createPolygon(), x, y); //creates a new Entity using the output from the polygonFactory as a parameter
        this.generateAsteroidMovement();
    }

    public void generateAsteroidMovement() {
        Random rnd = new Random(); //make a new random number generator

        super.getEntity().setRotate(rnd.nextInt(360)); //set the starting orientation of the asteroid to a random number from 0-359

        int accelerationAmount = 1 + rnd.nextInt(10);  //set the acceleration of the asteroid to a random number from 1-10
        for (int i = 0; i < accelerationAmount; i++) { //accelerate the asteroid based on the number of times specified
            accelerate();
        }

        this.rotationalIncrement = 0.5 - rnd.nextDouble(); //randomizes the number of degrees which the asteroid will rotate each frame
    }
    
    @Override
    public void move() {
        super.move(); //calls the existing logic from the base move() method defined in the 'Entity' class
        super.getEntity().setRotate(super.getEntity().getRotate() + rotationalIncrement); //when we "move" an asteroid, we also rotate it by it's pre-determined increment amount
    }
}
