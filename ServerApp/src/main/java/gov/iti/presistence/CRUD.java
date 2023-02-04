//package gov.iti.presistence;
package gov.iti.presistence;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CRUD extends Remote {

    boolean insertNewEmployee(Employee e) throws RemoteException;
    boolean updateEmployee(Employee e) throws RemoteException;
    int getEmpliyees() throws RemoteException;
    Employee returnEmployee() throws RemoteException;
    boolean getNextEmployee() throws RemoteException;
    boolean getPrevEmployee() throws RemoteException;
    boolean getFirstEmployee() throws RemoteException;
    boolean getLastEmployee() throws RemoteException;
    void deleteUser ()  throws RemoteException;
}
