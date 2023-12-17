package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage stage) {
        VBox elements = new VBox();
        Label textOutput = new Label();
        Button updateButton = new Button("Update");
        TextField userIn = new TextField("Some text here...");
        elements.setSpacing(10);
        elements.getChildren().add(userIn);
        elements.getChildren().add(updateButton);
        elements.getChildren().add(textOutput);
        
        updateButton.setOnAction((event) -> textOutput.setText(userIn.getText()));
        
        Scene mainScene = new Scene(elements);
        stage.setScene(mainScene);
        stage.show();
    }
}
