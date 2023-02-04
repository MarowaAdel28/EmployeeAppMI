package gov.iti.business.validation;

import javax.swing.JOptionPane;

import gov.iti.presentation.controllers.Fields;
import gov.iti.presistence.Employee;

public class ValidationEmployeeData {

    //Fields data;
    Employee emp;

    public ValidationEmployeeData() {

        emp=Employee.getInstance();

        //data=Fields.getInstance();
    }
    

    private static final ValidationEmployeeData instance = new ValidationEmployeeData();

    public static ValidationEmployeeData getInstance() {
        return instance;
    }

    public boolean verifyUserData(Fields f) {
        
        if (!verifyEmptyFields(f)) return false;

        if(!verifyId(f)) return false;

        if(!verifyName(f)) return false;

        if(!verifyEmail(f)) return false;

        if(!verifyPhoneNo(f)) return false;

        if(!verifyAge(f)) return false;

        return true;
    }

    public boolean verifyEmptyFields(Fields data) {
        if (data.getIdTextField().getText().isBlank() || data.getFNameTextField().getText().isBlank() || data.getMNameTextField().getText().isBlank() ||
            data.getLNameTextField().getText().isBlank() || data.getEmailTextField().getText().isBlank() ||
            data.getAgeTextField().getText().isBlank() || data.getPhoneTextField().getText().isBlank() ) {
                JOptionPane.showMessageDialog(null, "Enter all required fields!");
                return false;
        }
        return true;
    }

    public boolean verifyId(Fields data) {
        int id;
        try {
            if ((id=Integer.parseInt(data.getIdTextField().getText())) <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid id, must be positive number!");
                    return false;
            }
            
        } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Enter valid id Number!");
                    return false;
        }
        emp.setId(id);
        return true;
    }

    public boolean verifyName(Fields data) {
        String nameRegex = "[a-zA-Z]+", fName, mName, lName;
        boolean isNameValid = (fName=data.getFNameTextField().getText()).matches(nameRegex);
        if(!isNameValid) {
            JOptionPane.showMessageDialog(null, "Enter valid name");
            return false;
        } 

        isNameValid = (mName=data.getMNameTextField().getText()).matches(nameRegex);
        if(!isNameValid) {
            JOptionPane.showMessageDialog(null, "Enter valid name");
            return false;
        } 

        isNameValid = (lName=data.getLNameTextField().getText()).matches(nameRegex);
        if(!isNameValid) {
            JOptionPane.showMessageDialog(null, "Enter valid name");
            return false;
        } 
        emp.setfName(fName);
        emp.setmName(mName);
        emp.setlName(lName);
        return true;
    }

    public boolean verifyEmail(Fields data) {
        String emailRegex = "[a-zA-Z0-9]+@gmail.com", email;
        boolean isEmailValid = (email=data.getEmailTextField().getText()).matches(emailRegex);
        if(!isEmailValid) {
            JOptionPane.showMessageDialog(null, "Enter valid email ex: user125@gmail.com!");
            return false;
        } 
        emp.setEmail(email);
        return true;
    }

    public boolean verifyPhoneNo(Fields data) {
        String phoneRegex = "[0-9]+", phone;
        phone=data.getPhoneTextField().getText();
        if(phone.length()!=11) {
            JOptionPane.showMessageDialog(null, "Enter valid phone number must contain 11 numbers!");
            return false;
        }
        boolean isPhoneValid =phone.matches(phoneRegex);
        if(!isPhoneValid) {
            JOptionPane.showMessageDialog(null, "Enter valid phone number contain only numbers!");
            return false;
        } 
        emp.setPhone(phone);
        return true;
    }

    public boolean verifyAge(Fields data) {
        int age;
        try { 
            if ((age=Integer.parseInt(data.getAgeTextField().getText())) < 20) {
                JOptionPane.showMessageDialog(null, "Invalid age!");
                return false;
            }
        
            } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Enter valid Numbers!");
                    return false;
            }
            emp.setAge(age);
        return true;
    }

    public Employee getValidEmployee() {
        return emp;
    }
    
}
