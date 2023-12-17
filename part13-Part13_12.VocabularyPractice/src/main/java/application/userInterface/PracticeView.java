/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.userInterface;

import javafx.scene.layout.GridPane;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

import application.logic.Dictionary;

/**
 *
 * @author Andre
 */
//2 buttons for switching between views (master)
//a label that prompts user to translate a word "Translate: " + word
//a text area that accepts a translation
//a button for practice submission
//a label that tells the user if their input was correct + tells them the correct translation for the word if they were wrong
public class PracticeView {

    private Dictionary dictionary;
    private String wordToTranslate;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public GridPane getView() {
        GridPane practiceView = new GridPane();
        genPracticeWord();

        Label translateLabel = new Label("Translate the word '" + wordToTranslate + "'.");
        TextField userTranslationField = new TextField();
        Button submitTranslationButton = new Button("Check");
        Label userFeedback = new Label("");

        submitTranslationButton.setOnAction((event) -> {
            if (this.dictionary.checkTranslation(userTranslationField.getText(), wordToTranslate)) {
                userFeedback.setText("Correct!");
            } else {
                userFeedback.setText("Incorrect! The translation of the word '" + wordToTranslate + "' is '" + this.dictionary.getTranslation(wordToTranslate) + "'.");
            }
            userTranslationField.clear();
            genPracticeWord();
            translateLabel.setText("Translate the word '" + wordToTranslate + "'.");
        });

        practiceView.add(translateLabel, 0, 0);
        practiceView.add(userTranslationField, 0, 1);
        practiceView.add(submitTranslationButton, 0, 2);
        practiceView.add(userFeedback, 0, 3);

        practiceView.setPadding(new Insets(10));
        practiceView.setVgap(10);
        
        return practiceView;
    }
    
    public void genPracticeWord() {
        this.wordToTranslate = dictionary.getRandomWord();
    }

}
