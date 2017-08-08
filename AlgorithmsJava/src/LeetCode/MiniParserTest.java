package LeetCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;


public class MiniParserTest {
	MiniParser test;
	 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new MiniParser();
	  }
	
	@Test
	public void test() {
	 	String data = "[123,[456,[789]]]";
	 	data = "324"; //fine
	 	data = "[[]]";//fine
	 	data = "[1,[2],[[]],3,[]]";
	 	
		MiniParser.NestedInteger result = test.deserialize(data);		
		assertTrue(result != null);
		
	}

}
