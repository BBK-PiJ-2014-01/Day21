import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by PierreM on 09/03/2015.
 */
public class EchoClient {
    public static void main(String[] args) {
        EchoClient e = new EchoClient();
        e.run();
    }

    private void run() {
        try {
            Remote service = Naming.lookup("//127.0.0.1:1099/echo");
            EchoService echoService = (EchoService) service;
            String receivedEcho = echoService.echo("Hello!");
        } catch (NotBoundException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
