package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

public class MultipleViews extends Application {
private Scene firstScene;
private Scene secondScene;
private Scene thirdScene;
    /*
    The layout of the first view is done with the help of the BorderPane class. 
    At the top there is the text "First view!". 
    The center of the view contains a button with the text "To the second view!". 
    By pressing that button the application swithces to the second view.

    The layout of the second view is done with the help of the VBox class. 
    The first element in the layout is a button with the text "To the third view!" in it — 
    by pressing the button the application switches to the third view. 
    The button is followed by the text "Second view!".

    The third view uses the GridPane class for its layout. 
    At the coordinates (0, 0) there is a text that reads "Third view!". 
    At coordinates (1, 1) there is a button with the text "To the first view!". 
    Pressing this button brings back the first view.
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(MultipleViews.class);
    }
    
    public void start(Stage stage) {
        firstScene = createFirstScene(stage);
        secondScene = createSecondScene(stage);
        thirdScene = createThirdScene(stage);
        
        stage.setScene(firstScene);
        stage.show();
    }

    private Scene createFirstScene(Stage stage) {
        BorderPane firstSceneBorderPane = new BorderPane();
        Scene firstScene = new Scene(firstSceneBorderPane);

        firstSceneBorderPane.setTop(new Label("First view!"));
        Button toSecondView = new Button("To the second view!");
        toSecondView.setOnAction((event) -> stage.setScene(secondScene));
        firstSceneBorderPane.setCenter(toSecondView);

        return firstScene;
    }

    private Scene createSecondScene(Stage stage) {
        VBox secondSceneVBox = new VBox();
        Scene secondScene = new Scene(secondSceneVBox);
        Button toThirdView = new Button("To the third view!");
        toThirdView.setOnAction((event) -> stage.setScene(thirdScene));
        secondSceneVBox.getChildren().add(toThirdView);
        secondSceneVBox.getChildren().add(new Label("Second view!"));

        return secondScene;
    }
    
    private Scene createThirdScene(Stage stage) {
        GridPane thirdSceneGridPane = new GridPane();
        Scene thirdScene = new Scene(thirdSceneGridPane);
        
        Button toFirstView = new Button("To the first view!");
        toFirstView.setOnAction((event) -> stage.setScene(firstScene));
        thirdSceneGridPane.add(new Label("ThirdView"), 0, 0);
        thirdSceneGridPane.add(toFirstView, 1, 1);
        
        return thirdScene;
    }

}
