package application;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GreeterApplication extends Application {

    private Scene askForNameScene;
    private Scene greetingScene;
    private String userName;

    public static void main(String[] args) {
        System.out.println("Hellow world! :3"); //what.
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) {
        this.askForNameScene = createAskForNameScene(stage);

        stage.setScene(askForNameScene);
        stage.show();
    }

    public Scene createAskForNameScene(Stage stage) {
        VBox askForNameVBox = new VBox();
        TextField userInputName = new TextField();
        Button checkNameButton = new Button("Start");

        askForNameVBox.getChildren().add(new Label("Enter your name and start."));
        askForNameVBox.getChildren().add(userInputName);
        askForNameVBox.getChildren().add(checkNameButton);

        userInputName.textProperty().addListener((prop, oldVal, newVal) -> {
            this.userName = newVal;
        });

        checkNameButton.setOnAction(event -> {
            this.greetingScene = createGreetingScene(stage);
            stage.setScene(greetingScene);
        });

        Scene askForNameScene = new Scene(askForNameVBox);
        return askForNameScene;
    }

    public Scene createGreetingScene(Stage stage) {
        BorderPane greetingSceneBorderPane = new BorderPane();
        
        greetingSceneBorderPane.setCenter(new Label("Welcome " + this.userName + "!"));
        
        Scene greetingScene = new Scene(greetingSceneBorderPane);
        return greetingScene;
    }

}
