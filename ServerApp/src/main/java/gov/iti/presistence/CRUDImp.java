package gov.iti.presistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;


import com.mysql.cj.jdbc.MysqlDataSource;

public class CRUDImp extends UnicastRemoteObject implements CRUD {

    Employee emp;
    Connection myConnection;
    MysqlDataSource mysqlDS=null;
    boolean isAvalible;
    ResultSet result = null;
    PreparedStatement myStatement;
    Statement statement;
    ConnectionDB con;

    public CRUDImp() throws RemoteException {
        emp=Employee.getInstance();
        con=ConnectionDB.getInstance();
        myConnection=con.getMyConnection();
        myStatement=con.getMyStatement();
        mysqlDS=con.getMysqlDS();
    }

    public boolean insertNewEmployee(Employee e) throws RemoteException {
        // TODO Auto-generated method stub
        String sql ="INSERT INTO Employee Values (?,?,?,?,?,?,?)";
        try {
            myConnection=mysqlDS.getConnection();
            myStatement = myConnection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE
            ,ResultSet.CONCUR_UPDATABLE);
            myConnection.setAutoCommit( false );
            myStatement.setInt(1,e.getId());
            myStatement.setString(2 ,e.getfName());
            myStatement.setString(3 ,e.getmName());
            myStatement.setString(4 ,e.getlName());
            myStatement.setString(5 ,e.getEmail());
            myStatement.setString(6 ,e.getPhone());
            myStatement.setInt(7 ,e.getAge());
            int count=myStatement.executeUpdate();
            System.out.println(e.getId());
            if(count==1) {
                myConnection.commit();
                //System.out.println("add");
                return true;
            }
        }catch (SQLIntegrityConstraintViolationException c) {

            //JOptionPane.showMessageDialog(null, "dublicated id, enter another valid id!");
            //System.out.println("duplicated");
            return false;
        } 
        catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            return false;
        }

        return false;
    }

    public boolean updateEmployee(Employee e) throws RemoteException {
        // TODO Auto-generated method stub
        try {
            //result.updateInt("id", id);
            result.updateString("fName", e.getfName());
            result.updateString("mName", e.getmName());
            result.updateString("lName", e.getlName());
            result.updateString("email", e.getEmail());
            result.updateString("phone", e.getPhone());
            result.updateInt("age", e.getAge());
            result.updateRow();
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        return false;
    }

    public int getEmpliyees() throws RemoteException {
        // TODO Auto-generated method stub
        int countRow=0;
        try {
            myConnection=mysqlDS.getConnection();
            myStatement = myConnection.prepareStatement("select * from employee",ResultSet.TYPE_SCROLL_SENSITIVE
            ,ResultSet.CONCUR_UPDATABLE);
            result = myStatement.executeQuery();
            isAvalible=result.next();
            if(isAvalible) {
                int startPos=result.getRow();
                result.last();
                int endPos=result.getRow();
                countRow=endPos-startPos+1;
                result.first();
            } else {
                countRow=0;
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return countRow;
    }

    public Employee returnEmployee() {
        try {
            emp.setId(result.getInt("id"));
            emp.setfName(result.getString("fname"));
            emp.setmName(result.getString("mname"));
            emp.setlName(result.getString("lname"));
            emp.setEmail(result.getString("email"));
            emp.setPhone(result.getString("phone"));
            emp.setAge(Integer.parseInt(result.getString("age")));
            return emp;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public boolean getNextEmployee() {
        try {
            isAvalible=result.next();
            if(!isAvalible) result.previous();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isAvalible;
    }
    
    public boolean getPrevEmployee() {
        try {
            isAvalible=result.previous();
            if(!isAvalible) result.next();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isAvalible;
    }

    public boolean getFirstEmployee() {
        try {
            isAvalible=result.first();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isAvalible;
    }

    public boolean getLastEmployee() {
        try {
            isAvalible=result.last();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isAvalible;
    }
    public void deleteUser () {
        try {
            result.deleteRow();
            isAvalible=result.last();
            if(!isAvalible) isAvalible=result.next();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
