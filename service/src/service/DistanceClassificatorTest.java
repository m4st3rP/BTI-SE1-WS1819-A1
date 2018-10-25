package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

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
		assertEquals(exp, res);
	}
	
	@Test
	public void ID2Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'A';
		int dist = 10;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(exp, res);
	}
	
	@Test
	public void ID3Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'A';
		int dist = 23;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(exp, res);
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
		assertEquals("Mode:A, Distance:" + dist +", Expected: OFF", exp,  res );
	}
	
	@Test
	public void ID5Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.CLOSE;
		char mode = 'B';
		int dist = 3;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(exp, res);
	}
	
	@Test
	public void ID6Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'B';
		int dist = 7;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(exp, res);
	}
	
	@Test
	public void ID7Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'B';
		int dist = 12;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(exp, res);
	}
	
	@Test
	public void ID8Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.OFF;
		char mode = 'B';
		int dist = 23;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals(exp, res);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void ID9Test() {
		char mode = 'C';
		int dist = 6;
		distanceClassificator.determineDistanceClass(mode, dist);
	}
	
	/*
	 * FAILURE
	 */
	@Test
	public void ID10Test() {
		HashMap<Character, DistanceClasses> hm = new HashMap<>();
		boolean exceptionThrown = true;
		for(char ch = 0; ch < Character.MAX_VALUE; ch++) {
			if(ch == 'A' || ch == 'B') {
				continue;
			}
			try {
				DistanceClasses dc = distanceClassificator.determineDistanceClass(ch, 10);
				hm.put(ch, dc);
				exceptionThrown = false;
			}catch(IndexOutOfBoundsException e) {
				//do nothing.
			}
		}
		if(!exceptionThrown) {
			System.out.println("Exception not thrown for invalid chars:");
			for(Character c : hm.keySet()) {
				System.out.printf("<%c> => %s\n", c, hm.get(c));
			}
			System.out.println("Number of invalid arguments, for which no exception has been thrown: " + hm.size());
			System.out.println("########## END ##########");
		}
		assertTrue("No exception thrown for invalid mode argument", exceptionThrown);
	}
	
}
