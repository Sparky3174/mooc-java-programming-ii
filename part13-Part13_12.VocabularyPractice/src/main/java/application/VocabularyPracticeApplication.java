package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import application.logic.Dictionary;
import application.userInterface.*;
import javafx.geometry.Insets;

// END SOLUTION
//2 buttons for switching between views
//start on inputview
public class VocabularyPracticeApplication extends Application {

    private Parent inputView;
    private Parent practiceView;
    private Dictionary dictionary;

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }

    @Override
    public void start(Stage stage) {
        this.dictionary = new Dictionary();
        InputView inputViewGen = new InputView(dictionary);
        PracticeView practiceViewGen = new PracticeView(dictionary);
        this.inputView = inputViewGen.getView();

        BorderPane mainLayout = new BorderPane();
        HBox viewSwitcher = new HBox();
        Button switchToInputViewButton = new Button("Enter new words");
        Button switchToPracticeViewButton = new Button("Practice");

        switchToInputViewButton.setOnAction((event) -> mainLayout.setCenter(inputView));
        switchToPracticeViewButton.setOnAction((event) -> {
            this.practiceView = practiceViewGen.getView();
            mainLayout.setCenter(practiceView);
        });

        mainLayout.setTop(viewSwitcher);
        mainLayout.setCenter(inputView);
        viewSwitcher.getChildren().add(switchToInputViewButton);
        viewSwitcher.getChildren().add(switchToPracticeViewButton);
        viewSwitcher.setPadding(new Insets(10));
        viewSwitcher.setAlignment(Pos.TOP_LEFT);
        viewSwitcher.setSpacing(5);

        Scene mainScene = new Scene(mainLayout);

        stage.setScene(mainScene);
        stage.show();
    }
}
