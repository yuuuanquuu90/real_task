package yuanqu.data;

public class DistanceCalcuHelper {
	private static double EARTH_RADIUS = 6378.137;

	private static double getRadian(double degree) {
		return degree * Math.PI / 180.0;
	}

	/**
	 * 
	 * @return distance in meter
	 */
	public static double getDistance(Location l1, Location l2) {
		double lat1 = l1.getCoord().getX();
		double lat2 = l2.getCoord().getX();
		double lng1 = l1.getCoord().getY();
		double lng2 = l2.getCoord().getY();
		double radLat1 = getRadian(lat1);
		double radLat2 = getRadian(lat2);
		double a = radLat1 - radLat2;
		double b = getRadian(lng1) - getRadian(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		return s * 1000;
	}
}
