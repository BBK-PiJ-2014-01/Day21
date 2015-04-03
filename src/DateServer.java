/**
 * Created by PierreM on 09/03/2015.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

public class DateServer extends UnicastRemoteObject implements DateService {

    public DateServer() throws RemoteException {
    }

    @Override
    public Calendar date() {
        Calendar rightNow = Calendar.getInstance();
        System.out.println("Date is: "+rightNow.getTime());
        return(rightNow);
    }
}
