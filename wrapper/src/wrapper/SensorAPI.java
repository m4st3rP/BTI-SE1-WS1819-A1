package wrapper;

public class SensorAPI {
    public int calculateCentimetersFromDiscreteValue(char value) {
        var value_d = (double) value;

        value_d += 5.0;
        value_d /= 265.0;
        value_d = 1.0 - value;
        value_d = Math.acos(value_d);
        value_d = value_d / (Math.PI/2);
        value_d *= 30;

        return (int) value_d;
    }
}
