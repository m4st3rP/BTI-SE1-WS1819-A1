package service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DistanceClassificatorTest {

	private IDistanceClassificator distanceClassificator;
	
	@Before
	public void initialize() {
		distanceClassificator = new IrDistanceClassificator();
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void InvalidModeArgumentsTest() {
		distanceClassificator.determineDistanceClass('c', 10);
	}
	
	@Test
	public void InvalidModeArgumentsTest_2() {
		System.out.println("### Invalid Characters: ###");
		for(char ch = 0; ch < Character.MAX_VALUE; ch++) {
			if(ch == 'A' || ch == 'B') {
				continue;
			}
			try {
				DistanceClasses dc = distanceClassificator.determineDistanceClass(ch, 10);
				System.out.println("Char: <" + ch + "> , DistanceClass: " + dc);
			}catch(IndexOutOfBoundsException e) {
				//do nothing.
			}
		}
		System.out.println("### Invalid Characters End ###");
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void InvalidDistanceArgumentsTest() {
		distanceClassificator.determineDistanceClass('a', -1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void CaseSensitivityTest() {
		DistanceClasses dc1 = distanceClassificator.determineDistanceClass('a', 5);
		DistanceClasses dc2 = distanceClassificator.determineDistanceClass('A', 5);
		dc1 = distanceClassificator.determineDistanceClass('b', 5);
		dc2 = distanceClassificator.determineDistanceClass('B', 5);
	}
	
	@Test
	public void CloseModeATest() {
		DistanceClasses dc = null;
		for(int distance = 0; distance < 8; distance++) {
			dc = distanceClassificator.determineDistanceClass('A', distance);
			assertEquals(DistanceClasses.CLOSE, dc);
		}
	}
	
	/**
	 * FAILURE
	 */
	@Test
	public void MiddleModeATest() {
		DistanceClasses dc = null;
		for(int distance = 8; distance < 18; distance++) {
			dc = distanceClassificator.determineDistanceClass('A', distance);
			assertEquals("Mode:A, Distance:" + distance +", Expected: MID", DistanceClasses.MIDDLE, dc);
		}
	}
	
	@Test
	public void FarModeATest() {
		DistanceClasses dc = null;
		for(int distance = 18; distance < 25; distance++) {
			dc = distanceClassificator.determineDistanceClass('A', distance);
			assertEquals(DistanceClasses.FAR, dc);
		}
	}
	
	/*
	 * FAILURE
	 */
	@Test
	public void OffModeATest() {
		DistanceClasses dc = null;
		for(int distance = 25; distance < 30; distance++) {
			dc = distanceClassificator.determineDistanceClass('A', distance);
			assertEquals("Mode:A, Distance:" + distance +", Expected: OFF", DistanceClasses.OFF, dc);
		}
	}
	
	@Test
	public void CloseModeBTest() {
		DistanceClasses dc = null;
		for(int distance = 0; distance <= 5; distance++) {
			dc = distanceClassificator.determineDistanceClass('B', distance);
			assertEquals(DistanceClasses.CLOSE, dc);
		}
	}
	
	@Test
	public void MiddleModeBTest() {
		DistanceClasses dc = null;
		for(int distance = 6; distance < 10; distance++) {
			dc = distanceClassificator.determineDistanceClass('B', distance);
			assertEquals(DistanceClasses.MIDDLE, dc);
		}
	}
	
	@Test
	public void FarModeBTest() {
		DistanceClasses dc = null;
		for(int distance = 11; distance < 14; distance++) {
			dc = distanceClassificator.determineDistanceClass('B', distance);
			assertEquals(DistanceClasses.FAR, dc);
		}
	}

	/*
	 * FAILURE
	 */
	@Test
	public void OffModeBTest() {
		DistanceClasses dc = null;
		for(int distance = 14; distance < 20; distance++) {
			dc = distanceClassificator.determineDistanceClass('B', distance);
			assertEquals("Mode:B, Distance:" + distance +", Expected: OFF", DistanceClasses.OFF, dc);
		}
	}
	
	@Test
	public void ID1Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.CLOSE;
		char mode = 'A';
		int dist = 6;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID2Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'A';
		int dist = 10;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID3Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'A';
		int dist = 23;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	/*
	 * FAILURE
	 */
	@Test
	public void ID4Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.OFF;
		char mode = 'A';
		int dist = 26;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:A, Distance:" + dist +", Expected: OFF", res, exp);
	}
	
	@Test
	public void ID5Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.CLOSE;
		char mode = 'B';
		int dist = 3;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID6Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'B';
		int dist = 7;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID7Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'B';
		int dist = 12;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test
	public void ID8Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.OFF;
		char mode = 'B';
		int dist = 23;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(res, exp);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void ID9Test() {
		char mode = 'C';
		int dist = 6;
		distanceClassificator.determineDistanceClass(mode, dist);
	}
	
}
