package wrapper;

/**
 * A SensorAPI stub for testing purposes
 */
public class SensorAPIStub implements ISensorAPI {
    private char discreteDistanceValue;
    private char measuredDistance;
    private boolean isTriggered;

    public SensorAPIStub() {
        discreteDistanceValue = 0;
        measuredDistance = Character.MAX_VALUE;
        isTriggered = false;
    }

    public SensorAPIStub(char discreteDistanceValue) {
    	if(discreteDistanceValue > 255) {
    		throw new IllegalArgumentException();
    	}
        this.discreteDistanceValue = discreteDistanceValue;
        measuredDistance = Character.MAX_VALUE;
        isTriggered = false;
    }

    @Override
    public char d() {
    	if(measuredDistance == Character.MAX_VALUE) {
    		//MaxValue indicates that the distance has not been measaured
    		throw new IllegalStateException();
    	}
        return measuredDistance;
    }

    @Override
    public void t() {
    	isTriggered = true;
    }

    public void setDiscreteDistanceValue(char discreteDistanceValue) {
        this.discreteDistanceValue = discreteDistanceValue;
    }

    public char getDiscreteDistanceValue() {
        return discreteDistanceValue;
    }

	public boolean isTriggered() {
		return isTriggered;
	}

	public void setTriggered(boolean isTriggered) {
		this.isTriggered = isTriggered;
	}

	public char getMeasuredDistance() {
		return measuredDistance;
	}

	public void setMeasuredDistance(char measuredDistance) {
		this.measuredDistance = measuredDistance;
	}
}