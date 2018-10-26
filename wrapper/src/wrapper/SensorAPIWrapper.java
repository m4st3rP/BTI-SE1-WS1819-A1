package wrapper;

/**
 * A wrapper for ISensorAPI that adds a method to convert a discrete distance value to centimeters
 */
public class SensorAPIWrapper {
	
    private ISensorAPI sensorAPI;

    public SensorAPIWrapper(ISensorAPI sensorAPI) {
        this.sensorAPI = sensorAPI;
    }
    
    /**
     * @param value A discrete distance value from the ISensorAPI interface's d() method
     * @return The distance in centimeters
     */
    public char calculateCentimetersFromDiscreteValue() {
    	sensorAPI.t();
    	char discreteValue = ((SensorAPIMock)sensorAPI).d();
    	return (char) (Math.round((60.0/Math.PI)*Math.acos( (260.0-discreteValue)/265.0 )));
    }

    public ISensorAPI getSensorAPI() {
        return sensorAPI;
    }
    
}