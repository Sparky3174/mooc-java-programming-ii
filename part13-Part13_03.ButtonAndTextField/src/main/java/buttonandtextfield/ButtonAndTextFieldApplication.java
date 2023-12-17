package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(ButtonAndTextFieldApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        FlowPane organizer = new FlowPane();
        Button testButton = new Button("Button");
        TextField textField = new TextField("Sample Text");
        organizer.getChildren().add(testButton);
        organizer.getChildren().add(textField);
        
        Scene scene = new Scene(organizer);
        window.setScene(scene);
        window.show();
        
    }

}
