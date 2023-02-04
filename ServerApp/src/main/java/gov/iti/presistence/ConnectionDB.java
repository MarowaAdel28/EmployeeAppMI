package gov.iti.presistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionDB {

    Connection myConnection;
    MysqlDataSource mysqlDS=null;
    ResultSet result = null;
    PreparedStatement myStatement;
    Statement statement;

    private static final ConnectionDB instance = new ConnectionDB();

    public static ConnectionDB getInstance() {
        return instance;
    }

    public ConnectionDB() {
        mysqlDS = new MysqlDataSource();
        mysqlDS.setURL("jdbc:mysql://localhost:3307/myemployeedb");
        mysqlDS.setUser("root");
        mysqlDS.setPassword("");
        System.out.println("connected ");
    }

    public Connection getMyConnection() {
        return myConnection;
    }

    public MysqlDataSource getMysqlDS() {
        return mysqlDS;
    }

    public ResultSet getResult() {
        return result;
    }

    public PreparedStatement getMyStatement() {
        return myStatement;
    }

    public Statement getStatement() {
        return statement;
    }

    
    
}
