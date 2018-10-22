package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class JUnitTestFrameDistanceClassificator {

	private IDistanceClassificator distanceClassificator;
	
	@Before
	public void initialize() {
		distanceClassificator = new DistanceClassificator();
	}

	@Test(expected = IllegalArgumentException.class)
	public void InvalidModeArgumentsTest() {
		distanceClassificator.determineDistanceClass('c', 10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void InvalidDistanceArgumentsTest() {
		distanceClassificator.determineDistanceClass('a', -1);
	}
	
	@Test
	public void CaseInsensitivityTest() {
		DistanceClasses dc1 = distanceClassificator.determineDistanceClass('a', 5);
		DistanceClasses dc2 = distanceClassificator.determineDistanceClass('A', 5);
		assertEquals(dc1, dc2);
		//------
		dc1 = distanceClassificator.determineDistanceClass('b', 5);
		dc2 = distanceClassificator.determineDistanceClass('B', 5);
		assertEquals(dc1, dc2);
	}
	
	@Test
	public void CloseModeATest() {
		DistanceClasses dc = null;
		for(int distance = 0; distance < 8; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.CLOSE, dc);
		}
	}
	
	@Test
	public void MiddleModeATest() {
		DistanceClasses dc = null;
		for(int distance = 8; distance < 18; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.MIDDLE, dc);
		}
	}
	
	@Test
	public void FarModeATest() {
		DistanceClasses dc = null;
		for(int distance = 18; distance < 25; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.FAR, dc);
		}
	}
	
	@Test
	public void OffModeATest() {
		DistanceClasses dc = null;
		for(int distance = 25; distance < 30; distance++) {
			dc = distanceClassificator.determineDistanceClass('a', distance);
			assertEquals(DistanceClasses.OFF, dc);
		}
	}
	//----------------
	@Test
	public void CloseModeBTest() {
		DistanceClasses dc = null;
		for(int distance = 0; distance <= 5; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.CLOSE, dc);
		}
	}
	
	@Test
	public void MiddleModeBTest() {
		DistanceClasses dc = null;
		for(int distance = 6; distance < 10; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.MIDDLE, dc);
		}
	}
	
	@Test
	public void FarModeBTest() {
		DistanceClasses dc = null;
		for(int distance = 11; distance < 14; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.FAR, dc);
		}
	}
	
	@Test
	public void OffModeBTest() {
		DistanceClasses dc = null;
		for(int distance = 14; distance < 20; distance++) {
			dc = distanceClassificator.determineDistanceClass('b', distance);
			assertEquals(DistanceClasses.OFF, dc);
		}
	}
	
	@Test
	public void ID1Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.CLOSE;
		char mode = 'a';
		int dist = 6;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID2Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'a';
		int dist = 10;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID3Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'a';
		int dist = 23;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID4Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.OFF;
		char mode = 'a';
		int dist = 26;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID5Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.CLOSE;
		char mode = 'b';
		int dist = 3;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID6Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'b';
		int dist = 7;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID7Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'b';
		int dist = 12;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID8Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.OFF;
		char mode = 'b';
		int dist = 23;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID9Test() {
		boolean exthrown = false;
		char mode = 'c';
		int dist = 6;
		
		try {
			distanceClassificator.determineDistanceClass(mode, dist);
		} catch (Exception e) {
			exthrown = true;
		}
		
		assertTrue(exthrown);
	}
	
}
