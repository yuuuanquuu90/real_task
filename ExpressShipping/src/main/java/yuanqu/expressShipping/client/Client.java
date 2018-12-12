package yuanqu.expressShipping.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yuanqu.data.Customer;
import yuanqu.data.Location;
import yuanqu.data.Route;
import yuanqu.expressShipping.Server.IExpressServices;
import yuanqu.expressShipping.Server.ServerImp;

public class Client {
	private static final String HOST = "localhost";
	private static final String BIND_NAME = "RMI-ExpressShippingClient";
	private static ApplicationContext ac;
	private static Registry r;
	private static IExpressServices server;

	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
		// init client
		doInit();
		// simulation
		doSimulation();

	}

	static void doInit() throws RemoteException, NotBoundException {
		ac = new ClassPathXmlApplicationContext("/resources/customerContext.xml");
		r = LocateRegistry.getRegistry(HOST);
		server = (IExpressServices) r.lookup(ServerImp.SERVICE_NAME);
	}

	static String createCustomerRequest(ApplicationContext ac, String id) {
		if (ac.containsBean(id)) {
			return ((Customer) ac.getBean(id)).getName();
		} else {
			System.out.println("customer not found!");
			return null;
		}
	}

	static void doSimulation() throws RemoteException {
		for (int i = 1; i < 5; i++) {
			Route route = server.getRoute(createCustomerRequest(ac, "c" + i));
			if (route != null) {
				System.out.println("****************************");
				System.out.println("Client id: " + "c" + i + "\n");
				route.printInfo();
				System.out.println("****************************");
			}
		}
	}

}
