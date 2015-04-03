/**
 * Created by PierreM on 09/03/2015.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;

public class DateClient {
    public static void main(String[] args) {
        DateClient d = new DateClient();
        d.run();
    }

    private void run() {
        try {
            Remote service = Naming.lookup("//127.0.0.1:1099/date");
            DateService dateService = (DateService) service;
            Calendar receivedDate = dateService.date();
        } catch (NotBoundException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
