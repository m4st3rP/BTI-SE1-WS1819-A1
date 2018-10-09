package wrapper;

/**
 * A SensorAPI stub for testing purposes
 */
public class SensorAPIStub implements ISensorAPI {
    private char discreteDistanceValue;

    public SensorAPIStub() {
        discreteDistanceValue = 0;
    }

    public SensorAPIStub(char discreteDistanceValue) {
        this.discreteDistanceValue = discreteDistanceValue;
    }

    @Override
    public char d() {
        return discreteDistanceValue;
    }

    @Override
    public void t() {

    }

    public void setDiscreteDistanceValue(char discreteDistanceValue) {
        this.discreteDistanceValue = discreteDistanceValue;
    }

    public char getDiscreteDistanceValue() {
        return discreteDistanceValue;
    }
}
