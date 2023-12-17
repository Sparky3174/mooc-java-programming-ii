package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class JokeApplication extends Application {

//create 3 buttons that are always on screen.
    //below them, have text that can change depending on the button pressed....
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage stage) {

        String joke = "What do you call a bear with no teeth?";
        String answer = "A gummy bear.";
        String explanation = "Gummy, haha. Get it?";

        Label label = new Label(joke);
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        HBox buttonLayout = new HBox(jokeButton, answerButton, explanationButton);
        buttonLayout.setSpacing(10);
        jokeButton.setOnAction(event -> label.setText(joke));
        answerButton.setOnAction(event -> label.setText(answer));
        explanationButton.setOnAction(event -> label.setText(explanation));
        buttonLayout.setAlignment(Pos.TOP_CENTER);

        
        VBox mainLayout = new VBox(buttonLayout, label);
        mainLayout.setSpacing(30);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(10, 20, 10, 20)); // sets 10px padding on top and bottom, 20px padding on left and right
        
        Scene jokeScene = new Scene(mainLayout);
        stage.setScene(jokeScene);
        stage.show();

    }

}
