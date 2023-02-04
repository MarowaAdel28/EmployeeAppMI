package gov.iti.presentation.controllers;

import javafx.scene.control.Button;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gov.iti.business.ScreensObject;
import gov.iti.business.service.Connection;
import gov.iti.business.service.GettingEmployeeData;
import gov.iti.business.validation.ValidationEmployeeData;
import gov.iti.presistence.Employee;
import javafx.stage.Stage;

public class DisplayEmployeePage extends Fields {

    Stage stage;
    protected final Button updateButton;
    protected final Button prevButton;
    protected final Button nextButton;
    protected final Button lastButton;
    protected final Button firstButton;
    ScreensObject screens;
    Connection remoteCon;
    GettingEmployeeData empData;
    ValidationEmployeeData validation;
    int rowCounts;
    Fields f;
    Employee emp;

    public DisplayEmployeePage(Stage stage,ScreensObject screens) {

        this.stage=stage;
        this.screens=screens;
        updateButton = new Button();
        prevButton = new Button();
        nextButton = new Button();
        lastButton = new Button();
        firstButton = new Button();

        idTextField.setDisable(true);
        f=new Fields();
        emp=new Employee();
        
        createButtons();
        remoteCon=Connection.getInstance();
        empData=GettingEmployeeData.getInstance();
        validation=ValidationEmployeeData.getInstance();
        
        homeButton.setOnAction((event) -> {
            pushhomeButton();
        }); 

        nextButton.setOnAction((event) -> {
            try {
                if(remoteCon.getEmployeeRef().getNextEmployee()) {
                    //empData.SettingEmployeeData(remoteCon.getEmployeeRef().returnEmployee());
                    DisplayDataFrame(remoteCon.getEmployeeRef().returnEmployee());
                    //empData.DisplayDataConsole(remoteCon.getEmployeeRef().returnEmployee());
                    
                }
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //db.getNextEmployee();
            //rowCounts=db.DisplayData();
            //displayHomePage(rowCounts);
        }); 

        prevButton.setOnAction((event) -> {
            try {
                if(remoteCon.getEmployeeRef().getPrevEmployee()) {
                    //empData.SettingEmployeeData(remoteCon.getEmployeeRef().returnEmployee());
                    DisplayDataFrame(remoteCon.getEmployeeRef().returnEmployee());
                    //empData.DisplayDataConsole(remoteCon.getEmployeeRef().returnEmployee());
                }
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //db.getPrevEmployee();
            //rowCounts=db.DisplayData();
            //displayHomePage(rowCounts);
        }); 

        firstButton.setOnAction((event) -> {
            try {
                if(remoteCon.getEmployeeRef().getFirstEmployee()) {
                    //empData.SettingEmployeeData(remoteCon.getEmployeeRef().returnEmployee());
                    DisplayDataFrame(remoteCon.getEmployeeRef().returnEmployee());
                    //empData.DisplayDataConsole(remoteCon.getEmployeeRef().returnEmployee());
                }
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            /* 
            db.getFirstEmployee();
            rowCounts=db.DisplayData();
            displayHomePage(rowCounts); */
        }); 

        lastButton.setOnAction((event) -> {
            try {
                if(remoteCon.getEmployeeRef().getLastEmployee()) {
                    //empData.SettingEmployeeData(remoteCon.getEmployeeRef().returnEmployee());
                    DisplayDataFrame(remoteCon.getEmployeeRef().returnEmployee());
                    //empData.DisplayDataConsole(remoteCon.getEmployeeRef().returnEmployee());
                }
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            /* 
            db.getLastEmployee();
            rowCounts=db.DisplayData();
            displayHomePage(rowCounts);
            */
        }); 

        updateButton.setOnAction((event) -> {
            boolean isValid=validation.verifyUserData(getFields());
            if(isValid) {
                try {
                    if(remoteCon.getEmployeeRef().updateEmployee(validation.getValidEmployee())) {
                        JOptionPane.showMessageDialog(null, "your data updated sucessfully!");
                    }
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "Faild updated !");
                    e.printStackTrace();
                }
            }     
            /* 
            boolean isValid=db.verifyUserData();
            if(isValid) {
                db.getUserDate();
                db.updateUser();
                
            }
            */
        }); 

        exitIcon.setOnAction((event) -> {
            try {
                remoteCon.getEmployeeRef().deleteUser();
                getUserDataFromDB();
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            /* 
            db.getUserDate();
            db.deleteUser();
            db.retrieveData();
            rowCounts=db.DisplayData();
            displayHomePage(rowCounts);
            */
        }); 
    }

    private void pushhomeButton() {

        stage.setScene(screens.getHomeScene());
        stage.show();
    }

    private void createButtons() {

        updateButton.setLayoutX(300.0);
        updateButton.setLayoutY(399.0);
        updateButton.setMnemonicParsing(false);
        updateButton.setPrefHeight(42.0);
        updateButton.setPrefWidth(117.0);
        updateButton.setText("Update");

        prevButton.setLayoutX(14.0);
        prevButton.setLayoutY(399.0);
        prevButton.setMnemonicParsing(false);
        prevButton.setPrefHeight(42.0);
        prevButton.setPrefWidth(117.0);
        prevButton.setText("Previous");

        nextButton.setLayoutX(595.0);
        nextButton.setLayoutY(399.0);
        nextButton.setMnemonicParsing(false);
        nextButton.setPrefHeight(42.0);
        nextButton.setPrefWidth(117.0);
        nextButton.setText("Next");

        lastButton.setLayoutX(451.0);
        lastButton.setLayoutY(399.0);
        lastButton.setMnemonicParsing(false);
        lastButton.setPrefHeight(42.0);
        lastButton.setPrefWidth(117.0);
        lastButton.setText("Last");

        firstButton.setLayoutX(153.0);
        firstButton.setLayoutY(399.0);
        firstButton.setMnemonicParsing(false);
        firstButton.setPrefHeight(42.0);
        firstButton.setPrefWidth(117.0);
        firstButton.setText("First");
        setBottom(pane);

        pane.getChildren().add(updateButton);
        pane.getChildren().add(prevButton);
        pane.getChildren().add(nextButton);
        pane.getChildren().add(lastButton);
        pane.getChildren().add(firstButton);
       
    }

    public void getUserDataFromDB() {
        try {
            //rowCounts=remoteCon.retieveData();
            rowCounts=remoteCon.getEmployeeRef().getEmpliyees();
            System.out.println(rowCounts);
            if(rowCounts>0) {
                //empData.DisplayDataConsole(remoteCon.getEmployeeRef().returnEmployee());
                //System.out.println("count>0");
                stage.setScene(screens.getDisplayScene());
                //empData.SettingEmployeeData((Employee)remoteCon.getEmployeeRef().returnEmployee());
                DisplayDataFrame(remoteCon.getEmployeeRef().returnEmployee());
                //empData.DisplayData(remoteCon.getEmployeeRef().returnEmployee());
                stage.show();
            } else {
                displayHomePage(rowCounts);
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void displayHomePage(int count) {

        if(count<=0) {
            JOptionPane.showMessageDialog(new JFrame(), "no employees yet in DB");
            stage.setScene(screens.getHomeScene());
            stage.show();
        }
    }

    public Fields getFields() {
        return this;
    }

    public void DisplayDataFrame(Employee e) {
        this.idTextField.setText(e.getId()+"");
        this.fNameTextField.setText(e.getfName());
        this.mNameTextField.setText(e.getmName());
        this.lNameTextField.setText(e.getlName());
        this.emailTextField.setText(e.getEmail());
        this.phoneTextField.setText(e.getPhone());
        this.ageTextField.setText(e.getAge()+"");
        //System.out.println("kdkkdkdkdkdkdkdk   "+this.idTextField.getText());
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
    public Employee SettingEmployeeData(Fields e) {
        emp.setId(Integer.parseInt(e.idTextField.getText()));
        emp.setfName(e.fNameTextField.getText());
        emp.setmName(e.mNameLabel.getText());
        emp.setlName(e.lNameTextField.getText());
        emp.setEmail(e.emailTextField.getText());
        emp.setPhone(e.phoneTextField.getText());
        emp.setAge(Integer.parseInt(e.ageTextField.getText()));
        return emp;
    }
    public MyDataBase getMyDB() {
        return db;
    }
    */
}
