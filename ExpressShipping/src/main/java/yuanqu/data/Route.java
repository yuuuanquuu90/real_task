package yuanqu.data;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * A route comprises 3 locations in the array routes. routes[0] denotes the
 * location of the fleet, routes[1] the store and routes[2] the customer.
 * 
 * @author Yuan
 *
 */
public class Route implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] routes;
	private Double distance;
	private double time;
	DecimalFormat df;

	public Route(String[] routes, Double distance) {
		this.routes = routes;
		this.distance = distance;
		time = distance / (60 / 3.6);
		df = new DecimalFormat("0.00");
	}

	public String[] getRoutes() {
		return routes;
	}

	public void setRoutes(String[] routes) {
		this.routes = routes;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	/**
	 * 
	 * @param time in second
	 * @return time in minutes and seconds.
	 */
	public String printTime(double time) {
		double minutes = time / 60;
		double seconds = time % 60;
		return timeformat(String.valueOf((int) minutes)) + ":" + timeformat(String.valueOf((int) seconds));
	}

	private String timeformat(String s) {
		if (s.length() <= 1)
			return 0 + s;
		else
			return s;
	}

	public double getTime() {
		return this.time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public void printInfo() {
		System.out.println("Route: ");
		System.out.println(
				"start: " + getRoutes()[0] + "\n   to: " + getRoutes()[1] + "\n   to: " + getRoutes()[2] + "\n");
		System.out.println("Distance: " + df.format(getDistance()) + "m");
		System.out.println("Time: " + printTime(getTime()));

	}

}
