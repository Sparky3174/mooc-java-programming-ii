/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.userInterface;

import javafx.scene.layout.GridPane;
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
//2 text boxes for accepting words and translations
//a button for submitting the word and translation pair (need to clear the text boxes when clicked)
public class InputView {
    private Dictionary dictionary;
    
    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    
    public GridPane getView() {
    GridPane inputView = new GridPane();    
    Label inputWordLabel = new Label("Word: ");
    TextField inputWord = new TextField();
    Label inputTranslationLabel = new Label("Translation: ");
    TextField inputTranslation = new TextField();
    Button submitToDictionaryButton = new Button("Add the word pair");
    
    submitToDictionaryButton.setOnAction((event) -> {
        dictionary.add(inputWord.getText(), inputTranslation.getText());
        inputWord.clear();
        inputTranslation.clear();
            });
    
    inputView.add(inputWordLabel, 0, 0);
    inputView.add(inputWord, 0, 1);
    inputView.add(inputTranslationLabel, 0, 2);
    inputView.add(inputTranslation, 0, 3);
    inputView.add(submitToDictionaryButton, 0, 4);
    inputView.setPadding(new Insets(10));
    inputView.setVgap(10);
    
    return inputView;
    }
}
