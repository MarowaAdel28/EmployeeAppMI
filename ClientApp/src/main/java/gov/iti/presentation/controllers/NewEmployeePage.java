package gov.iti.presentation.controllers;

import java.awt.HeadlessException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import gov.iti.business.ScreensObject;
import gov.iti.business.service.Connection;
import gov.iti.business.service.GettingEmployeeData;
import gov.iti.business.validation.ValidationEmployeeData;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class NewEmployeePage extends Fields {

    Stage stage;
    protected final Button saveButton;
    ScreensObject screens;
    ValidationEmployeeData validation;
    GettingEmployeeData empData;
    Connection remoteCon;
    Fields f;
    //MyDataBase db;

    public NewEmployeePage(Stage stage,ScreensObject screens) {


        validation=ValidationEmployeeData.getInstance();
        empData=GettingEmployeeData.getInstance();
        remoteCon=Connection.getInstance();
        f = new Fields();
        this.stage=stage;
        this.screens=screens;
        saveButton = new Button();
        createSaveButton();
        idTextField.setDisable(false);
        saveButton.setOnAction((event) -> {
            pushSaveButton();
        }); 

        homeButton.setOnAction((event) -> {
            pushhomeButton();
        }); 

        exitIcon.setOnAction((event) -> {
            System.exit(0);
        }); 
    }

    private void pushhomeButton() {

        stage.setScene(screens.getHomeScene());
        stage.show();
    }

    private void pushSaveButton() {

        // get values from textfield
        // insert values in db
        
        boolean isValid=validation.verifyUserData(getFields());
        if(isValid) {
            try {
                if(remoteCon.getEmployeeRef().insertNewEmployee(validation.getValidEmployee())) {
                    JOptionPane.showMessageDialog(null, "your data added sucessfully!");
                    clearTextFields();
                    stage.setScene(screens.getHomeScene());
                } else {
                    JOptionPane.showMessageDialog(null, "dublicated id, enter another valid id!");
                    stage.setScene(screens.getNewScene());
                }
            } catch (HeadlessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            stage.show();
        }
    }

    private void clearTextFields() {
        idTextField.clear();
        fNameTextField.clear();
        mNameTextField.clear();
        lNameTextField.clear();
        emailTextField.clear();
        phoneTextField.clear();
        ageTextField.clear();
    }

    private void createSaveButton() {

        saveButton.setLayoutX(280.0);
        saveButton.setLayoutY(399.0);
        saveButton.setMnemonicParsing(false);
        saveButton.setPrefHeight(42.0);
        saveButton.setPrefWidth(199.0);
        saveButton.setText("Save");

        setBottom(pane);
        pane.getChildren().add(saveButton);
    }
   
    public Fields getFields() {
        return this;
    }

    /* 
     public Fields getEmployeeData() {

        f.idTextField.setText(idTextField.getText().trim());
        f.fNameTextField.setText(fNameTextField.getText().trim());
        f.mNameTextField.setText(mNameTextField.getText().trim());
        f.lNameTextField.setText(lNameTextField.getText().trim());
        f.emailTextField.setText(emailTextField.getText().trim());
        f.phoneTextField.setText(phoneTextField.getText().trim());
        //age=Integer.parseInt(data.getAgeTextField().getText().trim());
        return f;
    }
    private void insertIntoDB(String sql) {
        
        //db=screens.getDisplayEmployeePage().getMyDB();
        db= new MyDataBase(idTextField,fNameTextField,mNameTextField,lNameTextField
        ,emailTextField,phoneTextField,ageTextField);
        boolean isValid=db.verifyUserData();
        if(isValid) {
            db.getUserDate();
            if(db.insertData(sql)) {
                JOptionPane.showMessageDialog(null, "your data added sucessfully!");
                clearTextFields();
                stage.setScene(screens.getHomeScene());
            } else {
                stage.setScene(screens.getNewScene());
            }
            stage.show();
        }
    }
    */
}
