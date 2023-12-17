package asteroids.domain;

import javafx.scene.shape.Polygon;

public class PlayerShip extends Entity {
    
    public PlayerShip(int x, int y) {
        super(new Polygon(-5, -5, 10, 0, -5, 5), x, y);
    }
}