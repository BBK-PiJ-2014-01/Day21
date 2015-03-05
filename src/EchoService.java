/**
 * Created by Pierre on 05/03/2015
 * Implementation of the echo service
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoService extends Remote {
    /**
     * Returns the same string passed as parameter
     * @param s a string
     * @return the same string passed as parameter
     */
    public String echo(String s) throws RemoteException;
}