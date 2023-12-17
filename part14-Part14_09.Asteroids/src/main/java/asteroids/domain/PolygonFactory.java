package asteroids.domain;

import java.util.Random;
import javafx.scene.shape.Polygon;


public class PolygonFactory {

    public Polygon createPolygon() {
        Random random = new Random();

        double size = 10 + random.nextInt(10); //generates a random size for the polygon which can range from 10-19

        //generates the angles that will be used to draw the pentagon's shape (for asteroids)
        Polygon polygon = new Polygon();
        double c1 = Math.cos(Math.PI * 2 / 5);
        double c2 = Math.cos(Math.PI / 5);
        double s1 = Math.sin(Math.PI * 2 / 5);
        double s2 = Math.sin(Math.PI * 4 / 5);

        //adds the size and points to the polygon
        polygon.getPoints().addAll(
                size, 0.0,
                size * c1, -1 * size * s1,
                -1 * size * c2, -1 * size * s2,
                -1 * size * c2, size * s2,
                size * c1, size * s1);

        //modifies the location of each of the points on the polygon to add some variation to it's shape
        for (int i = 0; i < polygon.getPoints().size(); i++) { 
            int change = random.nextInt(5) - 2; 
            polygon.getPoints().set(i, polygon.getPoints().get(i) + change);
        }
        return polygon;
    }
}
