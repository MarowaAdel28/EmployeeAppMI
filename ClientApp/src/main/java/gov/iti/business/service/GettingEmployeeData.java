package gov.iti.business.service;

import gov.iti.presentation.controllers.Fields;
import gov.iti.presistence.Employee;

public class GettingEmployeeData {

    Employee emp;
    Fields data;

    String fName,mName,lName,email,phone;
    int id,age;

    public GettingEmployeeData() {
        emp=Employee.getInstance();
        data=Fields.getInstance();
    }

    private static final GettingEmployeeData instance = new GettingEmployeeData();

    public static GettingEmployeeData getInstance() {
        return instance;
    }

    public void getEmployeeData() {

        id=Integer.parseInt(data.getIdTextField().getText().trim());
        fName=data.getFNameTextField().getText().trim();
        mName=data.getMNameTextField().getText().trim();
        lName=data.getLNameTextField().getText().trim();
        email=data.getEmailTextField().getText().trim();
        phone=data.getPhoneTextField().getText().trim();
        age=Integer.parseInt(data.getAgeTextField().getText().trim());
        
    }

    public void SettingEmployeeData(Employee e) {
        emp.setId(e.getId());
        emp.setfName(e.getfName());
        emp.setmName(e.getmName());
        emp.setlName(e.getlName());
        emp.setEmail(e.getEmail());
        emp.setPhone(e.getPhone());
        emp.setAge(e.getAge());
        
    }

    public Employee getEmployeeObj() {
        return emp;
    }

    public void DisplayData(Employee e) {

        //data.DisplayDataFrame(e);
            /*
        data.getIdTextField().setText(e.getId()+"");
        data.getFNameTextField().setText(e.getfName());
        data.getMNameTextField().setText(e.getmName());
        data.getLNameTextField().setText(e.getlName());
        data.getEmailTextField().setText(e.getEmail());
        data.getPhoneTextField().setText(e.getPhone());
        data.getAgeTextField().setText(e.getAge()+"");
        System.out.println(e.getAge());
         */
    }

    public void DisplayDataConsole(Employee e) {
            
        System.out.println(e.getId()+"");
        System.out.println(e.getfName());
        System.out.println(e.getmName());
        System.out.println(e.getlName());
        System.out.println(e.getEmail());
        System.out.println(e.getPhone());
        System.out.println(e.getAge()+"");
        //System.out.println(emp.getAge());
        
    }
}
