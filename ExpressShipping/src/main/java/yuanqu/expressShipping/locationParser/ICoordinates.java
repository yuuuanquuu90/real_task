package yuanqu.expressShipping.locationParser;
/**
 *  This interface provides the geographic coordinate of the delivered location.
 * @author Yuan
 *
 */
public interface ICoordinates {
	public DoubleCoordinate getCoordinate(String name);
}
