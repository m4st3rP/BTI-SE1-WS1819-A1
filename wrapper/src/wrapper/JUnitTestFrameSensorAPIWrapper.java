package wrapper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitTestFrameSensorAPIWrapper {
	

    @Test
    public void testCalculateCentimetersFromDiscreteValue() {
        char testValue = 246;
        ISensorAPI sensorAPIstub = new SensorAPIStub(testValue);
        SensorAPIWrapper sensorAPIWrapper = new SensorAPIWrapper(sensorAPIstub);

        sensorAPIWrapper.t();
        assertEquals(29, sensorAPIWrapper.d());
    }
    
    @Test
    public void testCalculateCentimetersFromDiscreteValueAutomated() {
    	for(char distance = 5; distance < 30; distance++) {
    		char discreteValue = computeDiscreteDistanceValue(distance);
	        ISensorAPI sensorAPIstub = new SensorAPIStub(discreteValue);
	        SensorAPIWrapper sensorAPIWrapper = new SensorAPIWrapper(sensorAPIstub);
	        sensorAPIWrapper.t();
	        char measuredDistance = sensorAPIWrapper.d();
	        assertEquals(distance, measuredDistance);
    	}
        
    }
    
    @Test(expected = IllegalStateException.class)
    public void testMeasureWithoutTrigger() {
    	char testValue = 1;
        ISensorAPI sensorAPIstub = new SensorAPIStub(testValue);
        SensorAPIWrapper sensorAPIWrapper = new SensorAPIWrapper(sensorAPIstub);
        sensorAPIWrapper.d();
    }
    
    @Test
    public void testMeasureWithMultiTrigger() {
    	char testValue = 150;
    	ISensorAPI sensorAPIstub = new SensorAPIStub(testValue);
    	SensorAPIWrapper sensorAPIWrapper = new SensorAPIWrapper(sensorAPIstub);
    	sensorAPIWrapper.t();
    	char c1 = sensorAPIWrapper.d();
    	sensorAPIWrapper.t();
    	char testValue2 = 200;
    	((SensorAPIStub)sensorAPIstub).setDiscreteDistanceValue(testValue2);
    	char c2 = sensorAPIWrapper.d();
    	assertNotEquals(c1, c2);
    }
    
    @Test
    public void testValidArgumentBoundary() {
    	ISensorAPI sensorAPIstub = new SensorAPIStub((char)0);
    	ISensorAPI sensorAPIstub2 = new SensorAPIStub((char)255);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidArguments() {
    	char testValue = 256;
    	ISensorAPI sensorAPIstub = new SensorAPIStub(testValue);
    }
    
    @Test
    public void testUnreliableMeasurementAutomated() {
    	boolean result = false;
    	for(char c = 0; c <= 4; c++) {
    		char discreteDisVal = computeDiscreteDistanceValue(c);
    		ISensorAPI sensorAPIstub = new SensorAPIStub(discreteDisVal);
    		SensorAPIWrapper sensorAPIWrapper = new SensorAPIWrapper(sensorAPIstub);
    		sensorAPIWrapper.t();
    		try {
    			sensorAPIWrapper.d();
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