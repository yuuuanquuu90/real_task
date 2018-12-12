package yuanqu.expressShipping;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yuanqu.data.Customer;
import yuanqu.data.DistanceCalcuHelper;
import yuanqu.data.Fleet;
import yuanqu.data.Location;
import yuanqu.data.Store;
import yuanqu.expressShipping.Server.ExpressMap;
import yuanqu.expressShipping.locationParser.CoordinatesImp;
import yuanqu.expressShipping.locationParser.DoubleCoordinate;
import yuanqu.expressShipping.locationParser.ICoordinates;

public class DistanceTest {
//	@Test
	public void distanceTest() {
		ICoordinates coord = new CoordinatesImp();
//		DoubleCoordinate d1 = coord.getCoordinate(CoordinatesImp.FLEET1);
//		DoubleCoordinate d2 = coord.getCoordinate(CoordinatesImp.C1);
		DoubleCoordinate d1 = new DoubleCoordinate(51.429852, 6.777103);
		DoubleCoordinate d2 = new DoubleCoordinate(51.450658, 7.012864);
		Location l1 = new Location(d1, "l1");
		System.out.println(l1.getCoord().getX() + "  " + l1.getCoord().getY());
		Location l2 = new Location(d2, "l2");
		System.out.println(l2.getCoord().getX() + "  " + l2.getCoord().getY());
		System.out.println(DistanceCalcuHelper.getDistance(l1, l2));
	}

//	@Test
//	public void RouteTest() {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("/resources/locationContext.xml");
//		ApplicationContext ac2 = new ClassPathXmlApplicationContext("/resources/customerContext.xml");
//		ExpressMap em = new ExpressMap(ac);
//		em.CustomerRequestSimulator(ac2);
//		int i = 0;
//		for (Customer c : em.getCustomers()) {
//			System.out.println("Test " + i++);
//			System.out.println("Customer Location: " + c.getName());
//			System.out.println("Start");
//			printAllRoute(em.getFleets(), em.getStores(), c);
//			System.out.println("END");
//			System.out.println("REAL");
//			System.out.println(em.getRoute(c).getDistance());
//			System.out.println();
//		}
//	}

	public void printAllRoute(ArrayList<Fleet> fs, ArrayList<Store> ss, Customer c) {
		int i = 1;
		for (Fleet f : fs) {
			for (Store s : ss) {
				Double tmp = f.getDistancetoStore(s.getName()) + DistanceCalcuHelper.getDistance(s, c);
				System.out.println("Distance" + i++ + ": " + tmp);
			}
		}
	}
}
