package LeetCode;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CombinationSumTest {
	CombinationSum test;
	 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new CombinationSum();
	  }
	
	@Test
	public void test() {
		int[] nums = {1,2,3};
		int result = test.combinationSum4(nums, 4);
		assertTrue(result == 7);
	}
}
