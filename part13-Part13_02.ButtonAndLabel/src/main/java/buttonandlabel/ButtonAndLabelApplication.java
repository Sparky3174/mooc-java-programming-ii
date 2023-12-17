package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class ButtonAndLabelApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage window) {
        window.setTitle("Buttons!");
        Button button1 = new Button("Test1");
        Label label = new Label("button? Button!");
        FlowPane organizer = new FlowPane();
        organizer.getChildren().add(label);
        organizer.getChildren().add(button1);
        Scene buttons = new Scene(organizer);

        window.setScene(buttons);
        window.show();
    }

}
