package wrapper;

/**
 * A SensorAPI mock for testing purposes
 */
public class SensorAPIMock implements ISensorAPI {
	
    private char discreteDistanceValue;
    private boolean isTriggered;

    public SensorAPIMock(char discreteDistanceValue) {
    	if(discreteDistanceValue > 255) {
    		throw new IllegalArgumentException();
    	}
        this.discreteDistanceValue = discreteDistanceValue;
        isTriggered = false;
    }

    @Override
    public char d() {
    	if(!isTriggered) {
    		throw new IllegalStateException();
    	}
    	isTriggered = false;
    	return discreteDistanceValue;
    }

    @Override
    public void t() {
    	isTriggered = true;
    }

    public void setDiscreteDistanceValue(char discreteDistanceValue) {
        this.discreteDistanceValue = discreteDistanceValue;
    }

}