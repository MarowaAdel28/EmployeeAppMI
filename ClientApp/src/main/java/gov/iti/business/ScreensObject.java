package gov.iti.business;

import gov.iti.presentation.controllers.DisplayEmployeePage;
import gov.iti.presentation.controllers.HomePage;
import gov.iti.presentation.controllers.NewEmployeePage;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreensObject {

    Stage stage;
    NewEmployeePage newPage;
    DisplayEmployeePage displayPage;
    HomePage home;
    Scene homeScene,newScene,displayScene;
/* 
    private static final ScreensObject instance = new ScreensObject();

    public static ScreensObject getInstance() {
        return instance;
    }

    */

    public ScreensObject(Stage stage) {

        this.stage=stage;

        newPage= new NewEmployeePage(stage,this);
        displayPage = new DisplayEmployeePage(stage,this);
        home = new HomePage(stage,this);

        homeScene = new Scene(home, 720, 480);
        newScene = new Scene(newPage, 720, 480);
        displayScene = new Scene(displayPage, 720, 480);
    }

    public Scene getHomeScene() {

        return homeScene;
    }

    public Scene getNewScene() {

        return newScene;
    }

    public Scene getDisplayScene() {

        return displayScene;
    }

    public NewEmployeePage getNewPage() {
        return newPage;
    }

    public HomePage getHomePage() {
        return home;
    }

    public DisplayEmployeePage getDisplayEmployeePage() {
        return displayPage;
    }
    
}
