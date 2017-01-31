package LeetCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;


public class EvaluateDivisionTest {
	EvaluateDivision test;
	 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new EvaluateDivision();
	  }
	
	@Test
	public void test() {
		String[][] equations = {{"a", "b"}, {"b", "c"}};
		double[] values = {2.0, 3.0};
		String[][] queries = { {"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}, {"b", "a"}};
		double[] result = test.calcEquation(equations, values, queries);		
		assertTrue(result != null);
		
		assertTrue(result[0] == 6.0);
		assertTrue(result[1] == 3.0);
		assertTrue(result[2] == -1.0);
		assertTrue(result[3] == 1.0);
		assertTrue(result[4] == -1.0);
		assertTrue(result[5] == 0.5);
	}

}
