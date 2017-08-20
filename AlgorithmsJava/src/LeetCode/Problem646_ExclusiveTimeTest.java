package LeetCode;

import static org.junit.Assert.assertTrue;

import java.util.*;
import org.junit.*;

public class Problem646_ExclusiveTimeTest {
	Problem646_ExclusiveTime test;
	 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new Problem646_ExclusiveTime();
	  }
	
	@Test
	public void test() {
		List<String> logs = new ArrayList<>();
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");
	
		//1		["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
		test.exclusiveTime(2, logs);
		//assertTrue(result.equals("1000/(100/10/2)"));
	}
	
	@Test
	public void test2() {
		List<String> logs = new ArrayList<>();
		logs.add("0:start:0");
		logs.add("0:start:2");
		logs.add("0:end:5");
		logs.add("0:start:6");
		logs.add("0:end:6");
		logs.add("0:end:7");

		//1		["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
		test.exclusiveTime(1, logs);
		//assertTrue(result.equals("1000/(100/10/2)"));
	}
}
