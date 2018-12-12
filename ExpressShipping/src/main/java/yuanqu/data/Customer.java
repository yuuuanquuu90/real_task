package yuanqu.data;

import yuanqu.expressShipping.locationParser.DoubleCoordinate;

public class Customer extends Location {
	Route routeCache;

	public Customer(DoubleCoordinate coord, String name) {
		super(coord, name);
	}

	public Customer(String name) {
		super(name);
	}

	public Customer() {

	}

	public Route getRouteCache() {
		return routeCache;
	}

	public void setRouteCache(Route routeCache) {
		this.routeCache = routeCache;
	}

}
