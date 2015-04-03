/**
 * Created by PierreM on 09/03/2015.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;

public interface DateService extends Remote {
    /**
     * Returns the date and time passed as parameter
     * @return the date and time as parameter
     */
    public Calendar date() throws RemoteException;
}
