package yuanqu.expressShipping.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yuanqu.expressShipping.locationParser.CoordinatesImp;

/**
 * MAIN
 *
 */
public class ServerImp {
	public static final String SERVICE_NAME = "RMI-ExpressShipping";

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		ServerImp server = new ServerImp();
		ApplicationContext ac = new ClassPathXmlApplicationContext("/resources/locationContext.xml");
		ExpressMap em = new ExpressMap(ac, new CoordinatesImp());
		System.out.println("Server started");
		server.doServerInit(em);

//		em.printInfos();
//		em.CustomerRequestSimulator(ac2);

	}

	private void doServerInit(ExpressMap remote) throws RemoteException, AlreadyBoundException {
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		Registry r = LocateRegistry.getRegistry("localhost");
		System.out.println("RMI-Server is binded with name: " + SERVICE_NAME);
		r.bind(SERVICE_NAME, remote);
	}
}
