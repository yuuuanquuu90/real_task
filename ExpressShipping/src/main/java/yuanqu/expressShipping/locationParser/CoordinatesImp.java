package yuanqu.expressShipping.locationParser;

import java.util.HashMap;

/**
 *  Due to the limit of time, i have only instantiated this pseudo-Google Service: 
 *  A kernel function has been by "getCoordinate" simulated, that is:
 *  according to the delivered name of the location provides this method the related
 *  geographic coordinate.
 *   
 * @author Yuan
 *
 */
public class CoordinatesImp implements ICoordinates {
	public final static String FLEET1 = "Metrostrasse 12, 40235 Düsseldorf";
	public final static String FLEET2 = "Am Albertussee 1, 40549 Düsseldorf";
	public final static String C1 = "Kronprinzenstraße 88, 40217 Düsseldorf";
	public final static String C2 = "Kaiserstraße 2, 40479 Düsseldorf";
	public final static String C3 = "Wildenbruchstraße 2, 40545 Düsseldorf";
	public final static String C4 = "Schlesische Straße 5, 40231 Düsseldorf";
	public final static String S1 = "Schiessstraße 31, 40549 Düsseldorf";
	public final static String S2 = "Friedrichstraße 152, 40217 Düsseldorf";
	public final static String S3 = "Breslauer Str. 2, 41460 Neuss";
	public final static String S4 = "Bataverstraße 93, 41462 Neuss";
	public final static String S5 = "Am Sandbach 30, 40878 Ratingen";
	HashMap<String, DoubleCoordinate> pseudoMap;

	public CoordinatesImp() {
		super();
		pseudoMap = new HashMap<String, DoubleCoordinate>();
		init();
	}

	public DoubleCoordinate getCoordinate(String name) {
		return pseudoMap.get(name);
	}

	/**
	 * i use this method only to simulate the goolge roads api
	 */
	private void init() {
		// manual set fleet
		setLocation(FLEET1, 51.234806, 6.825593);
		setLocation(FLEET2, 51.236713, 6.723989);
		// manual set stores
		setLocation(S1, 51.237619, 6.719510);
		setLocation(S2, 51.209459, 6.778129);
		setLocation(S3, 51.202215, 6.718651);
		setLocation(S4, 51.231415, 6.685721);
		setLocation(S5, 51.297305, 6.831262);
		// manual set customers
		setLocation(C1, 51.211918, 6.770138);
		setLocation(C2, 51.235382, 6.778464);
		setLocation(C3, 51.227855, 6.760003);
		setLocation(C4, 51.208262, 6.831133);
	}

	private void setLocation(String name, double x, double y) {
		pseudoMap.put(name, new DoubleCoordinate(x, y));
	}

}
