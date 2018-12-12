package yuanqu.data;

import yuanqu.expressShipping.locationParser.DoubleCoordinate;

public class Location {
	private DoubleCoordinate coord;
	private String name;

	public Location() {

	}

	public Location(DoubleCoordinate coord, String name) {
		this.coord = coord;
		this.name = name;
	}

	public Location(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * x latitude y longitude
	 * 
	 * @return
	 */
	public DoubleCoordinate getCoord() {
		return coord;
	}

	public void setCoord(DoubleCoordinate coord) {
		this.coord = coord;
	}

}
