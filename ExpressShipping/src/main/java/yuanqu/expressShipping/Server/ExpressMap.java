package yuanqu.expressShipping.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;

import yuanqu.data.Customer;
import yuanqu.data.DistanceCalcuHelper;
import yuanqu.data.Fleet;
import yuanqu.data.Location;
import yuanqu.data.Route;
import yuanqu.data.Store;
import yuanqu.expressShipping.locationParser.ICoordinates;

public class ExpressMap extends UnicastRemoteObject implements IExpressServices {
	private static final long serialVersionUID = 1L;
	private ArrayList<Fleet> fleets;
	private ArrayList<Store> stores;
	private ArrayList<Customer> customerscache;
	private ICoordinates getCoord;

	public ExpressMap(ApplicationContext ac, ICoordinates coord) throws RemoteException {
		fleets = new ArrayList<Fleet>();
		stores = new ArrayList<Store>();
		customerscache = new ArrayList<Customer>();
		getCoord = coord;
		doInit(ac);
	}

	public ArrayList<Fleet> getFleets() {
		return fleets;
	}

	public void setFleets(ArrayList<Fleet> fleets) {
		this.fleets = fleets;
	}

	public ArrayList<Store> getStores() {
		return stores;
	}

	public void setStores(ArrayList<Store> stores) {
		this.stores = stores;
	}

	/**
	 * first catch the coordinate of locations. than add those locations in list
	 * with individual method
	 * 
	 * @param ac
	 */
	private void doInit(ApplicationContext ac) {
		System.out.println(getClass().getName() + ": system initialization");
		int id = 1;
		while (ac.containsBean("l" + id)) {
			// first catch the coordinate of locations
			Location l = (Location) ac.getBean("l" + id);
			l.setCoord(getCoord.getCoordinate(l.getName()));
			// than add locations in lists
			if (l instanceof Fleet) {
				addFleet((Fleet) l);
			} else if (l instanceof Store) {
				addStore((Store) l);
			} else {
				System.out.println("ERROR!!!!!! no such of a construction has be found.");
			}
			id++;
		}
	}

	public void addFleet(Fleet f) {
		System.out.println(getClass().getName() + " Add fleet: " + f.getName());
		this.fleets.add(f);
	}

	public void addStore(Store s) {
		System.out.println(getClass().getName() + " Add store: " + s.getName());
		this.stores.add(s);
		for (Fleet f : fleets)
			f.setDistances(s.getName(), DistanceCalcuHelper.getDistance(f, s));
	}

	public void addCustomerCache(Customer c) {
		System.out.println("*********************************************");
		System.out.println("add Default Route for Customer in: " + c.getName() + "\n");
		System.out.println("*********************************************");
		customerscache.add(c);
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	@Override
	public Route getRoute(String request) {
		if (request == null)
			return null;
		Customer c = new Customer(request);
		c.setCoord(getCoord.getCoordinate(c.getName()));
		Double sum = -1.0;
		String[] locations = new String[3];
		for (Fleet f : fleets)
			for (Store s : stores) {
				Double tmp = f.getDistancetoStore(s.getName()) + DistanceCalcuHelper.getDistance(s, c);
				if (sum < 0 || tmp < sum) {
					sum = tmp;
					locations[0] = f.getName();
					locations[1] = s.getName();
					locations[2] = c.getName();
				}
			}
		Route route = new Route(locations, sum);
		c.setRouteCache(route);
		this.addCustomerCache(c);
		return route;
	}



}
