/**
 * Created by PierreM on 09/03/2015.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class DateServerLauncher {
    public static void main(String[] args) {
        DateServerLauncher dsl = new DateServerLauncher();
        dsl.launch();
    }

    private void launch() {
        // 1. If there is no security manager, start one
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            // 2. Create the registry if there is not one
            LocateRegistry.createRegistry(1099);
            // 3. Create the server object
            DateServer server = new DateServer();
            // 4. Register (bind) the server object on the registry.
            String registryHost = "//localhost/";
            String serviceName = "date";
            Naming.rebind(registryHost + serviceName, server);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

}
