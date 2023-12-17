package asteroids.domain;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import asteroids.AsteroidsApplication;

public abstract class Entity {

    private Polygon entity;
    private Point2D entityVelocity;
    private boolean alive;

    public Entity(Polygon polygon, int x, int y) {
        this.alive = true;
        this.entity = polygon;
        this.entity.setTranslateX(x);
        this.entity.setTranslateY(y);
        this.entityVelocity = new Point2D(0, 0);
    }

    public Polygon getEntity() {
        return this.entity;
    }

    public void turnRight() {
        this.entity.setRotate(this.entity.getRotate() + 5);
    }

    public void turnLeft() {
        this.entity.setRotate(this.entity.getRotate() - 5);
    }

    public void move() {
        this.entity.setTranslateX(this.entity.getTranslateX() + this.entityVelocity.getX());
        this.entity.setTranslateY(this.entity.getTranslateY() + this.entityVelocity.getY());

        keepEntityOnScreen();
    }

    public void keepEntityOnScreen() {

        double translateY = this.entity.getTranslateY();
        double translateX = this.entity.getTranslateX();
        boolean isWrapped = false; //is the entity outside the window?

        //if the entity is outside the bounds of the width of the window, wrap it's x coordinate around to the other side
        if (translateX < 0) {
            this.entity.setTranslateX(translateX + AsteroidsApplication.WIDTH);
            isWrapped = true;
        }

        if (translateX > AsteroidsApplication.WIDTH) {
            this.entity.setTranslateX(translateX % AsteroidsApplication.WIDTH);
            isWrapped = true;
        }

        //if the entity is outside the bounds of the height of the window, wrap it's y coordinate around to the other side
        if (translateY < 0) {
            this.entity.setTranslateY(translateY + AsteroidsApplication.HEIGHT);
            isWrapped = true;
        }

        if (translateY > AsteroidsApplication.HEIGHT) {
            this.entity.setTranslateY(translateY % AsteroidsApplication.HEIGHT);
            isWrapped = true;
        }

        if (this instanceof Projectile && isWrapped) { //kills projectiles if they leave the screen boundaries... wrapping them around the screen is silly :p
            this.setAlive(false);
        }
    }

    public void accelerate() {
        double velocityChangeX = Math.cos(Math.toRadians(this.entity.getRotate())); //defines how far the entity should move on x axis in a single frame
        double velocityChangeY = Math.sin(Math.toRadians(this.entity.getRotate())); //defines how far the entity should move on y axis in a single frame
        System.out.println(this.entityVelocity.magnitude()); //debug message that shows what speed the entity is currently travelling

        if (this.entityVelocity.magnitude() < 5) { //if the speed is less than 5 
            velocityChangeY *= 0.05; //multiply the Y axis increment by .05
            velocityChangeX *= 0.05; //multiply the Y axis increment by .05
            this.entityVelocity = this.entityVelocity.add(velocityChangeX, velocityChangeY); //add the calculated increments to the velocity

        }
    }

    public boolean collidingWith(Entity other) {
        Shape collisionCheck = Shape.intersect(this.entity, other.getEntity());
        return collisionCheck.getBoundsInLocal().getWidth() != -1; //return true if any "width" of the entities are intersecting
    }

    public Point2D getEntityVelocity() {
        return this.entityVelocity;
    }

    public void setEntityVelocity(Point2D entityCoordinates) {
        this.entityVelocity = entityCoordinates;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive; //insert Portal/GLaDOS reference here, lol
    }
}
