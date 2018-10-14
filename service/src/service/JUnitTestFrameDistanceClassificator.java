package service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JUnitTestFrameDistanceClassificator {


	@Test(expected = IllegalArgumentException.class)
	public void testInvalidModeArguments() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		distanceClassificator.determineDistanceClass('c', 10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDistanceArguments() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		distanceClassificator.determineDistanceClass('a', -1);
	}
	
	@Test
	public void testCaseNonSensibility() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		DistanceClasses dc1 = distanceClassificator.determineDistanceClass('a', 5);
		DistanceClasses dc2 = distanceClassificator.determineDistanceClass('A', 5);
		assertEquals(dc1, dc2);
		//------
		dc1 = distanceClassificator.determineDistanceClass('b', 5);
		dc2 = distanceClassificator.determineDistanceClass('B', 5);
		assertEquals(dc1, dc2);
	}
	
	@Test
	public void testForCloseModeA() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		DistanceClasses dc = null;
		for(int distance = 0; distance < 8; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.CLOSE, dc);
		}
	}
	
	@Test
	public void testForMiddleModeA() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		DistanceClasses dc = null;
		for(int distance = 8; distance < 18; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.MIDDLE, dc);
		}
	}
	
	@Test
	public void testForFarModeA() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		DistanceClasses dc = null;
		for(int distance = 18; distance < 25; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.FAR, dc);
		}
	}
	
	@Test
	public void testForOffModeA() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		DistanceClasses dc = null;
		for(int distance = 25; distance < 30; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.OFF, dc);
		}
	}
	//----------------
	@Test
	public void testForCloseModeB() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		DistanceClasses dc = null;
		for(int distance = 0; distance <= 5; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.CLOSE, dc);
		}
	}
	
	@Test
	public void testForMiddleModeB() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		DistanceClasses dc = null;
		for(int distance = 6; distance < 10; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.MIDDLE, dc);
		}
	}
	
	@Test
	public void testForFarModeB() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		DistanceClasses dc = null;
		for(int distance = 11; distance < 14; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.FAR, dc);
		}
	}
	
	@Test
	public void testForOffModeB() {
		IDistanceClassificator distanceClassificator = new DistanceClassificator();
		DistanceClasses dc = null;
		for(int distance = 14; distance < 20; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.OFF, dc);
		}
	}
	
}
