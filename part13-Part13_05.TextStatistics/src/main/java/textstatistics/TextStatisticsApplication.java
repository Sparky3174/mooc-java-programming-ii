package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TextStatisticsApplication.class);
    }
    
    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        Scene mainScene = new Scene(border);
        
        
        TextArea userInputText = new TextArea();
        HBox bottomTextElements = new HBox();
        bottomTextElements.setSpacing(50);
        bottomTextElements.getChildren().add(new Label("Letters: 0"));
        bottomTextElements.getChildren().add(new Label("Words: 0"));
        bottomTextElements.getChildren().add(new Label("The longest word is:"));
        
        border.setCenter(userInputText);
        border.setBottom(bottomTextElements);
        
        stage.setScene(mainScene);
        stage.show();
    }

}
