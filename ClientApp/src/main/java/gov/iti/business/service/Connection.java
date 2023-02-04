package gov.iti.business.service;

//import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
//import java.util.Random;

import gov.iti.presistence.CRUD;
//import gov.iti.presistence.Employee;

public class Connection {

    Registry reg;
    CRUD employeeRef;

    private static final Connection instance = new Connection();

    public static Connection getInstance() {
        return instance;
    }

    public Connection () {
        try{
            reg = LocateRegistry.getRegistry();
            employeeRef =(CRUD) reg.lookup("EmployeeService");
           // employeeRef.getEmpliyees();
            //Employee e = employeeRef.returnEmployee();
            //e.setId(new Random().nextInt(200));
            //employeeRef.insertNewEmployee(e);
            //System.out.print(employeeRef.getEmpliyees());
            } catch(Exception ex) { 
                ex.printStackTrace();
            }
    }

    public CRUD getEmployeeRef() {
        return employeeRef;
    }
/* 
    public int retieveData() {
        try {
            return employeeRef.getEmpliyees();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } */
/* 
    public BigDecimal calculate() {

        BigDecimal result=null;

        if(OperationInfo.getInstance().isTrue()) {
            BigDecimal fBigDecimal = OperationInfo.getInstance().getFirstNum();
            BigDecimal sBigDecimal = OperationInfo.getInstance().getSecondNum();
            String ope = OperationInfo.getInstance().getOpertion();
            System.out.print(ope);

            if(ope.equals("+")) {
                try {
                    result=calculatorRef.add(fBigDecimal, sBigDecimal);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (ope.equals("-")) {
                System.out.println("elseon");
                try {
                    
                    result=calculatorRef.subtract(fBigDecimal, sBigDecimal);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (ope.equals("*")) {
                try {
                    result=calculatorRef.multiply(fBigDecimal, sBigDecimal);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (ope.equals("/")) {
                try {
                    result=calculatorRef.division(fBigDecimal, sBigDecimal);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.out.println("invalid operation");
            }
        }
        return result;
    }
    */
    
}



