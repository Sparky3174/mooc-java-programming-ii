package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    private PixelReader imageReader;
    private Image sourceImage;
    private WritableImage targetImage;
    private PixelWriter imageWriter;

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        sourceImage = new Image("file:monalisa.png");

        imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        targetImage = new WritableImage(width, height);
        imageWriter = targetImage.getPixelWriter();

        int yCoordinate = 0;
        while (yCoordinate < height) {
            int xCoordinate = 0;
            while (xCoordinate < width) {

                Color color = imageReader.getColor(xCoordinate, yCoordinate);
                double red = color.getRed();
                double green = color.getGreen();
                double blue = color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                imageWriter.setColor(xCoordinate, yCoordinate, newColor);

                xCoordinate++;
            }

            yCoordinate++;
        }
        smolLisa(0, 0);
        manySmolLisa();

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void smolLisa(int placeX, int placeY) {
        int y = 0;
        while (y < (int) sourceImage.getHeight()) {
            int x = 0;
            while (x < (int) sourceImage.getWidth()) {
                if (x * 2 < sourceImage.getWidth() && y * 2 < sourceImage.getHeight()) {
                    int targetX = placeX + x;
                    int targetY = placeY + y;
                    Color newColor = getColor(x * 2, y * 2);
                    imageWriter.setColor(targetX, targetY, newColor);
                }
                x++;
            }
            y++;
        }
    }

    public void manySmolLisa() {
        smolLisa((int) sourceImage.getWidth() / 2, 0);
        smolLisa(0, (int) sourceImage.getHeight() / 2);
        smolLisa((int) sourceImage.getWidth() / 2, (int) sourceImage.getHeight() / 2);
    }

    public Color getColor(int x, int y) {
        Color color = imageReader.getColor(x, y);

        double red = 1 - color.getRed();
        double green = 1 - color.getGreen();
        double blue = 1 - color.getBlue();
        double opacity = color.getOpacity();

        Color newColor = new Color(red, green, blue, opacity);

        return newColor;
    }
}
