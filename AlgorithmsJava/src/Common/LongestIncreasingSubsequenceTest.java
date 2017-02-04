package Common;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;



import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

	LongestIncreasingSubsequence test;
		 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new LongestIncreasingSubsequence();
	  }
	
	@Test
	public void test() {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
		int n = arr.length;		
		assertTrue(test.lis(arr, n) == 5);
	}
}
