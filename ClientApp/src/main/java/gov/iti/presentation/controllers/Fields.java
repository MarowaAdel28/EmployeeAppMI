package gov.iti.presentation.controllers;


import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Fields extends DataFields {

    
    public Fields() {

        createPane();
        createFields();   
    }

    private static final Fields instance = new Fields();

    public static Fields getInstance() {
        return instance;
    }


    private void createPane() {
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(483.0);
        setPrefWidth(759.0);

        BorderPane.setAlignment(titleLabel, null);
        titleLabel.setText("Employee Application");
        
        titleLabel.setLayoutX(280);
        titleLabel.setLayoutY(0);
        titleLabel.setMnemonicParsing(false);
        titleLabel.setPrefHeight(10);
        titleLabel.setPrefWidth(117.0);
        
        BorderPane.setAlignment(homeButton, null);
        homeButton.setLayoutX(5);
        homeButton.setLayoutY(0);
        homeButton.setMnemonicParsing(false);
        homeButton.setPrefHeight(25.0);
        homeButton.setPrefWidth(25.0);

        myImageView.setFitHeight(25);
        myImageView.setFitWidth(25);
        myImageView.setPreserveRatio(true);
        homeButton.setGraphic(myImageView);

        BorderPane.setAlignment(exitIcon, null);
        exitIcon.setLayoutX(675);
        exitIcon.setLayoutY(0);
        exitIcon.setMnemonicParsing(false);
        exitIcon.setPrefHeight(25.0);
        exitIcon.setPrefWidth(25.0);

        exitView.setFitHeight(25);
        exitView.setFitWidth(25);
        exitView.setPreserveRatio(true);
        exitIcon.setGraphic(exitView);

        titlePane.getChildren().add(titleLabel);
        titlePane.getChildren().add(homeButton);
        titlePane.getChildren().add(exitIcon);
        setTop(titlePane);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setPrefHeight(534.0);
        pane.setPrefWidth(818.0);
    }

    private void createFields() {

        idLabel.setLayoutX(47.0);
        idLabel.setLayoutY(22.0);
        idLabel.setPrefHeight(33.0);
        idLabel.setPrefWidth(147.0);
        idLabel.setText("Employee Id");

        idTextField.setLayoutX(223.0);
        idTextField.setLayoutY(23.0);
        idTextField.setPrefHeight(31.0);
        idTextField.setPrefWidth(258.0);
        idTextField.setPromptText("enter your id");

        fNameLabel.setLayoutX(47.0);
        fNameLabel.setLayoutY(72.0);
        fNameLabel.setPrefHeight(33.0);
        fNameLabel.setPrefWidth(147);
        fNameLabel.setText("First Name");

        fNameTextField.setLayoutX(223.0);
        fNameTextField.setLayoutY(73.0);
        fNameTextField.setPrefHeight(31.0);
        fNameTextField.setPrefWidth(262.0);
        fNameTextField.setPromptText("enter your first");

        mNameLabel.setLayoutX(47.0);
        mNameLabel.setLayoutY(117.0);
        mNameLabel.setPrefHeight(33.0);
        mNameLabel.setPrefWidth(147.0);
        mNameLabel.setText("Middle Name");

        mNameTextField.setLayoutX(223.0);
        mNameTextField.setLayoutY(118.0);
        mNameTextField.setPrefHeight(31.0);
        mNameTextField.setPrefWidth(261.0);
        mNameTextField.setPromptText("enter middle name");

        lNameLabel.setLayoutX(47.0);
        lNameLabel.setLayoutY(171.0);
        lNameLabel.setPrefHeight(33.0);
        lNameLabel.setPrefWidth(147.0);
        lNameLabel.setText("Last Name");

        lNameTextField.setLayoutX(223.0);
        lNameTextField.setLayoutY(172.0);
        lNameTextField.setPrefHeight(31.0);
        lNameTextField.setPrefWidth(264.0);
        lNameTextField.setPromptText("enter your last");

        emailLabel.setLayoutX(47.0);
        emailLabel.setLayoutY(222.0);
        emailLabel.setPrefHeight(33.0);
        emailLabel.setPrefWidth(147.0);
        emailLabel.setText("Email");

        emailTextField.setLayoutX(223.0);
        emailTextField.setLayoutY(223.0);
        emailTextField.setPrefHeight(31.0);
        emailTextField.setPrefWidth(266.0);
        emailTextField.setPromptText("enter your email");

        phoneLabel.setLayoutX(47.0);
        phoneLabel.setLayoutY(280.0);
        phoneLabel.setPrefHeight(33.0);
        phoneLabel.setPrefWidth(147.0);
        phoneLabel.setText("Phone Number");

        phoneTextField.setLayoutX(223.0);
        phoneTextField.setLayoutY(281.0);
        phoneTextField.setPrefHeight(31.0);
        phoneTextField.setPrefWidth(268.0);
        phoneTextField.setPromptText("enter your phone");
        //.setText("enter your phone");

        ageLabel.setLayoutX(47.0);
        ageLabel.setLayoutY(334.0);
        ageLabel.setPrefHeight(33.0);
        ageLabel.setPrefWidth(147.0);
        ageLabel.setText("Age");

        ageTextField.setLayoutX(223.0);
        ageTextField.setLayoutY(335.0);
        ageTextField.setPrefHeight(31.0);
        ageTextField.setPrefWidth(270.0);
        ageTextField.setPromptText("enter your age");

        pane.getChildren().add(idTextField);
        pane.getChildren().add(idLabel);
        pane.getChildren().add(fNameTextField);
        pane.getChildren().add(fNameLabel);
        pane.getChildren().add(mNameTextField);
        pane.getChildren().add(mNameLabel);
        pane.getChildren().add(lNameTextField);
        pane.getChildren().add(lNameLabel);
        pane.getChildren().add(emailTextField);
        pane.getChildren().add(emailLabel);
        pane.getChildren().add(phoneTextField);
        pane.getChildren().add(phoneLabel);
        pane.getChildren().add(ageTextField);
        pane.getChildren().add(ageLabel);
    }
    public TextField getIdTextField() {
        return idTextField;
    }

    public TextField getFNameTextField() {
        return fNameTextField;
    }

    public TextField getMNameTextField() {
        return mNameTextField;
    }

    public TextField getLNameTextField() {
        return lNameTextField;
    }

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public TextField getPhoneTextField() {
        return phoneTextField;
    }

    public TextField getAgeTextField() {
        return ageTextField;
    }

    
    
}
