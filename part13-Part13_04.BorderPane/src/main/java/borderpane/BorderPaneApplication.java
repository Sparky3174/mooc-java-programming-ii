package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(BorderPaneApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        BorderPane border = new BorderPane();
        border.setBottom(new Label("SOUTH"));
        border.setTop(new Label("NORTH"));
        border.setRight(new Label("EAST"));
        border.setLeft(new Label("WEST"));
        Scene scene = new Scene(border);
        
        window.setScene(scene);
        window.show();
    }

}
