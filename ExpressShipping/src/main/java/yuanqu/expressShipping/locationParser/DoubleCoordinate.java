package yuanqu.expressShipping.locationParser;
public class DoubleCoordinate {
	private double x;
	private double y;
/**
 * 
 * @param x latitude
 * @param y longitude 
 */
	public DoubleCoordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setCoordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
