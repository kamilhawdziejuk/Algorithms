package Common;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MoviesStartTimesTest {
	MoviesStartTimes test;
	 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new MoviesStartTimes();
	  }
	
	@Test
	public void test() {
		int priorities[] = { 9,2,10,4,5,1,9,3,6,7};
		int start_times[] = { 8,10,11,13,14,15,17,19,20,21}; 
		String res = test.run(priorities.length,  priorities, start_times);
		assertTrue(res == "8,11,13,15,17,19,21");
	}
}
