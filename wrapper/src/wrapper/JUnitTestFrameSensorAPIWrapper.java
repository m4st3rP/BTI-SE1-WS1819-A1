package wrapper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUnitTestFrameSensorAPIWrapper {
    @Test
    public void testCalculateCentimetersFromDiscreteValue() {
        char testValue = 246;
        var sensorAPIstub = new SensorAPIStub(testValue);
        var sensorAPIWrapper = new SensorAPIWrapper(sensorAPIstub);

        assertEquals(29, sensorAPIWrapper.calculateCentimetersFromDiscreteValue(testValue));
    }
}
