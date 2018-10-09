package wrapper;

/**
 * Interface to access an infrared distance sensor.
 * (Typically the dedicated sensor needed to be selected in
 * real scenario.) 
 * @author Thomas Lehmann
 * @version 1.0
 * @since   2017-10-04
 */
public interface ISensorAPI {
	/**
	 * Method returns the measured distance, after measurement has been triggered. 
	 * Measured value stays the same until next trigger. 
	 * @return the measured distance when triggered. 
	 */
	public char d();

	/**
	 * Triggers a measurement of the distance.
	 */
	public void t();
}
