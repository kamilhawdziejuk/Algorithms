package LeetCode;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Problem553_OptimalDivisionTest {
	Problem553_OptimalDivision test;
	 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new Problem553_OptimalDivision();
	  }
	
	@Test
	public void test() {
		int[] nums = {1000,100,10,2};
		String result = test.optimalDivision(nums);
		assertTrue(result.equals("1000/(100/10/2)"));
	}
}
