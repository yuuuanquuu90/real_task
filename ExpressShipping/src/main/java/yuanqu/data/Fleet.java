package yuanqu.data;

import java.util.HashMap;

import yuanqu.expressShipping.locationParser.DoubleCoordinate;

public class Fleet extends Location {
	private HashMap<String, Double> distances;

	public Fleet(DoubleCoordinate coord, String name) {
		super(coord, name);
		// TODO Auto-generated constructor stub
		distances = new HashMap<String, Double>();

	}

	public Fleet() {
		super();
		distances = new HashMap<String, Double>();
	}

	public Fleet(String name) {
		super(name);
		distances = new HashMap<String, Double>();

	}

	public HashMap<String, Double> getDistances() {
		return distances;
	}

	public Double getDistancetoStore(String name) {
		return distances.get(name);
	}

	public void setDistances(String location, Double distance) {
		distances.put(location, distance);
	}

}
