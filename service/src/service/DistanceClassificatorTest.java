package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DistanceClassificatorTest {

	private IDistanceClassificator distanceClassificator;
	
	@Before
	public void initialize() {
		distanceClassificator = new IrDistanceClassificator();
	}

	@Test
	public void NegativeDistanceArgumentTest() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.CLOSE;
		char mode = 'A';
		int dist = -1;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void CaseSensitivityTest() {
		distanceClassificator.determineDistanceClass('a', 5);
		distanceClassificator.determineDistanceClass('A', 5);
		distanceClassificator.determineDistanceClass('b', 5);
		distanceClassificator.determineDistanceClass('B', 5);
	}
	
	@Test
	public void ID1_candidate_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.CLOSE;
		char mode = 'A';
		int dist = 6;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID1_inner_bound_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.CLOSE;
		char mode = 'A';
		int dist = 7;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID2_candiate_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'A';
		int dist = 10;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	/*
	 * FAILURE
	 */
	@Test
	public void ID2_inner_bound_Test1() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'A';
		int dist = 8;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID2_inner_bound_Test2() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'A';
		int dist = 17;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID3_candiate_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'A';
		int dist = 23;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID3_inner_bound_Test1() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'A';
		int dist = 18;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID3_inner_bound_Test2() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'A';
		int dist = 24;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	/*
	 * FAILURE
	 */
	@Test
	public void ID4_candidate_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.OFF;
		char mode = 'A';
		int dist = 26;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp,  res );
	}
	
	/*
	 * FAILURE
	 */
	@Test
	public void ID4_inner_bound_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.OFF;
		char mode = 'A';
		int dist = 25;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp,  res );
	}
	
	@Test
	public void ID5_candidate_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.CLOSE;
		char mode = 'B';
		int dist = 3;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID5_inner_bound_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.CLOSE;
		char mode = 'B';
		int dist = 5;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID6_candidate_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'B';
		int dist = 7;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID6_inner_bound_Test1() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'B';
		int dist = 6;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID6_inner_bound_Test2() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.MIDDLE;
		char mode = 'B';
		int dist = 9;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID7_candidate_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'B';
		int dist = 12;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID7_inner_bound_Test1() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'B';
		int dist = 10;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID7_inner_bound_Test2() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.FAR;
		char mode = 'B';
		int dist = 13;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test
	public void ID8_candidate_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.OFF;
		char mode = 'B';
		int dist = 23;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	/*
	 * FAILURE
	 */
	@Test
	public void ID8_inner_bound_Test() {
		DistanceClasses res;
		DistanceClasses exp = DistanceClasses.OFF;
		char mode = 'B';
		int dist = 14;
		
		res = distanceClassificator.determineDistanceClass(mode, dist);
		assertEquals("Mode:<" + mode + "> Distance:<" + dist + ">", exp, res);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void ID9_candidate_Test() {
		char mode = 'C';
		int dist = 6;
		distanceClassificator.determineDistanceClass(mode, dist);
	}
	
	/*
	 * FAILURE
	 */
	@Test
	public void ID10_candidate_Test() {
		char mode = '$';
		int dist = 6;
		DistanceClasses dc = null;
		boolean exceptionThrown = false;
		try {
			dc = distanceClassificator.determineDistanceClass(mode, dist);
		}catch(IndexOutOfBoundsException e){
			exceptionThrown = true;
		}
		assertTrue("Mode:<" + mode + "> expected:" + IndexOutOfBoundsException.class.getSimpleName()
				+ " but was:<" + dc + ">", exceptionThrown);
	}
	
}
