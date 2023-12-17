package title;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;


public class UserTitle extends Application {

    @Override
    public void start(Stage stage) {
        Parameters p = getParameters();
        stage.setTitle(p.getRaw().get(0));
        stage.show();
    }

}
