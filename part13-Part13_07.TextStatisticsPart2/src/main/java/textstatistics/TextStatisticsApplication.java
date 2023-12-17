package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextStatisticsApplication extends Application {

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
        Label numberOfLetters = new Label();
        Label numberOfWords = new Label();
        Label longestWord = new Label();

        userInputText.textProperty().addListener((text, oldValue, newValue) -> {
            String[] words = newValue.split(" ");
            int letterCount = newValue.length();
            String biggestWord = Arrays.stream(words).sorted((firstWord, secondWord) -> secondWord.length() - firstWord.length()).findFirst().orElse("N/a");
            numberOfLetters.setText("Letters: " + letterCount);
            numberOfWords.setText(words[0].equals("") ? "Words: 0" : "Words: " + words.length);
            longestWord.setText("The longest word is: " + biggestWord);
        });

        bottomTextElements.getChildren().add(numberOfLetters);
        bottomTextElements.getChildren().add(numberOfWords);
        bottomTextElements.getChildren().add(longestWord);

        border.setCenter(userInputText);
        border.setBottom(bottomTextElements);

        stage.setScene(mainScene);
        stage.show();
    }

}
