/**
 * Created by Pierre on 05/03/2015.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class EchoServerLauncher {
    public static void main(String[] args) {
        EchoServerLauncher esl = new EchoServerLauncher();
        esl.launch();
    }

    private void launch() {
        // 1. If there is no security manager, start one
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            // 2. Create the registry if there is not one
            LocateRegistry.createRegistry(7);
            // 3. Create the server object
            EchoServer server = new EchoServer();
            // 4. Register (bind) the server object on the registry.
            String registryHost = "//localhost/";
            String serviceName = "echo";
            Naming.rebind(registryHost + serviceName, server);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

}

