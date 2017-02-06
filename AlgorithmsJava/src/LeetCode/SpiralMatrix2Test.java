package LeetCode;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SpiralMatrix2Test {

	 SpiralMatrix2 test;
	 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new SpiralMatrix2();
	  }
	
	@Test
	public void test() {
		int[][] tab  = test.generateMatrix(2);
		assertTrue(tab[0][0] == 1);
		assertTrue(tab[0][1] == 2);
		assertTrue(tab[1][1] == 3);
		assertTrue(tab[1][0] == 4);
	}
}
