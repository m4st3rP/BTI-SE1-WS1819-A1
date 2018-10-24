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
     *
     * @param value A discrete distance value from the ISensorAPI interface's d() method
     * @return The distance in centimeters
     */
    private char calculateCentimetersFromDiscreteValue(char value) {
        double value_d = (double) value;
        
        // revert the formula
        value_d += 5.0;
        value_d /= 265.0;
        value_d = 1.0 - value_d;
        value_d = Math.acos(value_d); // acos gives us back the angle the value had before cos was applied to it
        value_d = value_d / (Math.PI /2);
        value_d *= 30;
        int value_i = (int)value_d;
        if(value_d - value_i != 0) {
        	value_d++;
        }
        return (char) value_d;
    }

    public ISensorAPI getSensorAPI() {
        return sensorAPI;
    }
}