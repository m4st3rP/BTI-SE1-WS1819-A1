package service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JUnitTestFrameDistanceClassificator {

	private IDistanceClassificator distanceClassificator;
	
	@Before
	public void initialize() {
		distanceClassificator = new DistanceClassificator();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidModeArguments() {
		distanceClassificator.determineDistanceClass('c', 10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDistanceArguments() {
		distanceClassificator.determineDistanceClass('a', -1);
	}
	
	@Test
	public void testCaseNonSensibility() {
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
		DistanceClasses dc = null;
		for(int distance = 0; distance < 8; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.CLOSE, dc);
		}
	}
	
	@Test
	public void testForMiddleModeA() {
		DistanceClasses dc = null;
		for(int distance = 8; distance < 18; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.MIDDLE, dc);
		}
	}
	
	@Test
	public void testForFarModeA() {
		DistanceClasses dc = null;
		for(int distance = 18; distance < 25; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.FAR, dc);
		}
	}
	
	@Test
	public void testForOffModeA() {
		DistanceClasses dc = null;
		for(int distance = 25; distance < 30; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.OFF, dc);
		}
	}
	//----------------
	@Test
	public void testForCloseModeB() {
		DistanceClasses dc = null;
		for(int distance = 0; distance <= 5; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.CLOSE, dc);
		}
	}
	
	@Test
	public void testForMiddleModeB() {
		DistanceClasses dc = null;
		for(int distance = 6; distance < 10; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.MIDDLE, dc);
		}
	}
	
	@Test
	public void testForFarModeB() {
		DistanceClasses dc = null;
		for(int distance = 11; distance < 14; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.FAR, dc);
		}
	}
	
	@Test
	public void testForOffModeB() {
		DistanceClasses dc = null;
		for(int distance = 14; distance < 20; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.OFF, dc);
		}
	}
	
}
