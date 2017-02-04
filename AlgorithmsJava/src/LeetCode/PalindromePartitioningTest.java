package LeetCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;



import org.junit.Test;

public class PalindromePartitioningTest {

	PalindromeParitioning test;
		 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new PalindromeParitioning();
	  }
	
	@Test
	public void test() {
		List<List<String>> result = test.partition("aab");
		assertTrue(result.size() == 2);
	}
}
