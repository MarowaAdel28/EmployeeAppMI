package gov.iti.presentation;

import gov.iti.business.ScreensObject;
import gov.iti.business.service.Connection;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        //Fields.getInstance();
        Connection.getInstance();
        ScreensObject screens = new ScreensObject(stage);
        
        stage.setScene(screens.getHomeScene());
        stage.show();
    }
    public static void main( String[] args )
    {
        
        launch();

    }
}
