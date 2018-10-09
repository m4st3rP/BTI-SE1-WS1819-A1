package service;
/**
 * Interface for service class, that determines the distance class for
 * a model car.
 * @author Thomas Lehmann
 * @version 1.0
 * @since   2017-10-04
 */

public interface IDistanceClassificator {
	/**
	 * Method returns the classification for the given distance depending on the mode.
	 * @param mode according to mounting position 
	 * @param distance in the unit cm
	 * @return the distance class depending on mode and given distance
	 */
	public DistanceClasses determineDistanceClass(char mode, int distance);
}
