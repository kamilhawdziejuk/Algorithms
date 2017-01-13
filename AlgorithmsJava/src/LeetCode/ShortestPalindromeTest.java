package LeetCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;



import org.junit.Test;

public class ShortestPalindromeTest {

	 ShortestPalindrome test;
		 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new ShortestPalindrome();
	  }
	
	@Test
	public void test() {
		String res = test.shortestPalindrome("aacecaaa");
		assertTrue(res == "aaacecaaa");
	}

	@Test
	public void test2() {
		String res = test.shortestPalindrome("ba");
		assertTrue(res == "aba");
	}

}
