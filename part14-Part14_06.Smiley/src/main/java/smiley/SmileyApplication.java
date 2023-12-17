package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class SmileyApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext draw = canvas.getGraphicsContext2D();
        //Hello, I'm Bob Ross, and I'd like to take a moment to thank you for allowing me into your homes once again.
        //Let me extend to you a personal invitation to take out your oil paints and paint along with me :)
        //Now, lets go over to the canvas here and get started.
        draw.fillRect(250, 50, 10, 10);
        draw.fillRect(260, 80, 10, 10);
        draw.fillRect(270, 90, 10, 10);
        draw.fillRect(280, 100, 10, 10);
        draw.fillRect(290, 100, 10, 10);
        draw.fillRect(300, 90, 10, 10);
        draw.fillRect(310, 80, 10, 10);
        draw.fillRect(320, 50, 10, 10);

        BorderPane layout = new BorderPane();
        layout.setCenter(canvas);
        Scene what = new Scene(layout);
        stage.setScene(what);
        stage.show();
    }
   

}
