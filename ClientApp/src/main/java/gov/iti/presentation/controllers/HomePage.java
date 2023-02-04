package gov.iti.presentation.controllers;

import gov.iti.business.ScreensObject;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomePage extends BorderPane {

    protected final Label homeLabel;
    protected final Pane homePane;
    protected final Button displayButton;
    protected final Button newButton;
    protected final Button exitButton;

    Stage stage;
    ScreensObject screens;

    public HomePage(Stage stage,ScreensObject screens) {

        this.stage=stage;
        this.screens=screens;

        homeLabel = new Label();
        homePane = new Pane();
        displayButton = new Button();
        newButton = new Button();
        exitButton= new Button();

        createPane();

        createHomeButtons();

        newButton.setOnAction((event) -> {
            pushNewButton();
        }); 

        displayButton.setOnAction((event) -> {
            pushDisplayButton();
        });

        exitButton.setOnAction((event)-> System.exit(0));
    }

    private void pushDisplayButton() {

        screens.getDisplayEmployeePage().getUserDataFromDB();
        //screens.getDisplayEmployeePage().DisplayDataFrame();
    }

    private void pushNewButton() {
        
        stage.setScene(screens.getNewScene());
        stage.show();
    }

    private void createHomeButtons() {

        displayButton.setLayoutX(281.0);
        displayButton.setLayoutY(190.0);
        displayButton.setMnemonicParsing(false);
        displayButton.setPrefHeight(43.0);
        displayButton.setPrefWidth(196.0);
        displayButton.setText("Display");

        newButton.setLayoutX(280.0);
        newButton.setLayoutY(117.0);
        newButton.setMnemonicParsing(false);
        newButton.setPrefHeight(46.0);
        newButton.setPrefWidth(194.0);
        newButton.setText("New");

        exitButton.setLayoutX(280.0);
        exitButton.setLayoutY(260.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(42.0);
        exitButton.setPrefWidth(199.0);
        exitButton.setText("Exit");
        setCenter(homePane);

        homePane.getChildren().add(displayButton);
        homePane.getChildren().add(newButton);
        homePane.getChildren().add(exitButton);
    }

    private void createPane() {
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(483.0);
        setPrefWidth(759.0);

        BorderPane.setAlignment(homeLabel, javafx.geometry.Pos.CENTER);
        homeLabel.setText("Employee Application");
        setTop(homeLabel);

        BorderPane.setAlignment(homePane, javafx.geometry.Pos.CENTER);
        homePane.setPrefHeight(534.0);
        homePane.setPrefWidth(818.0);
    }
}
