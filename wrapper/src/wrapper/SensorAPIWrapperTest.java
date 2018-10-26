package wrapper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SensorAPIWrapperTest {

	@Test
	public void testCalculateCentimetersFromDiscreteValue() {
		char testValue = 246;
		ISensorAPI sensorAPImock = new SensorAPIMock(testValue);
		SensorAPIWrapper sensorAPIWrapper = new SensorAPIWrapper(sensorAPImock);
		assertEquals(29, sensorAPIWrapper.calculateCentimetersFromDiscreteValue());
	}

	@Test
	public void testCalculateCentimetersFromDiscreteValueAutomated() {
		for(char distance = 5; distance < 30; distance++) {
			char discreteValue = computeDiscreteDistanceValue(distance);
			ISensorAPI sensorAPImock = new SensorAPIMock(discreteValue);
			SensorAPIWrapper sensorAPIWrapper = new SensorAPIWrapper(sensorAPImock);
			assertEquals(distance, sensorAPIWrapper.calculateCentimetersFromDiscreteValue());
		}
	}

	@Test(expected = IllegalStateException.class)
	public void testMeasureWithoutTrigger() {
		char testValue = 1;
		ISensorAPI sensorAPImock = new SensorAPIMock(testValue);
		SensorAPIWrapper sensorAPIWrapper = new SensorAPIWrapper(sensorAPImock);
		sensorAPIWrapper.getSensorAPI().d();
	}

	@Test
	public void testValidArgumentBoundary() {
		ISensorAPI sensorAPImock = new SensorAPIMock((char)0);
		ISensorAPI sensorAPImock2 = new SensorAPIMock((char)255);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidArguments() {
		char testValue = 256;
		ISensorAPI sensorAPImock = new SensorAPIMock(testValue);
	}

	@Test
	public void testUnreliableMeasurementAutomated() {
		boolean result = false;
		for(char c = 0; c <= 4; c++) {
			char discreteDisVal = computeDiscreteDistanceValue(c);
			ISensorAPI sensorAPImock = new SensorAPIMock(discreteDisVal);
			SensorAPIWrapper sensorAPIWrapper = new SensorAPIWrapper(sensorAPImock);
			try {
				sensorAPIWrapper.calculateCentimetersFromDiscreteValue();
			}catch(IllegalStateException e){
				result = true;
				assertTrue(result);
			}
		}
	}

	private char computeDiscreteDistanceValue(char realDistance) {
		double realDistance_d = realDistance;
		realDistance_d = realDistance_d * Math.PI / 60;
		realDistance_d = Math.cos(realDistance_d);
		realDistance_d = 1 - realDistance_d;
		realDistance_d = realDistance_d * 265 - 5;
		if(realDistance_d < 0) {
			realDistance_d = 0;
		}
		return (char)realDistance_d;
	}

}
