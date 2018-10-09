package wrapper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUnitTestFrameSensorAPI {
    @Test
    public void testCalculateCentimetersFromDiscreteValue() {
        var sensorapi = new SensorAPI();
        char testValue = 246;
        assertEquals(29, sensorapi.calculateCentimetersFromDiscreteValue(testValue));
    }
}
