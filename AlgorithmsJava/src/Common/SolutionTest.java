package Common;

import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	Solution test;
	
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new Solution();
	  }
	
	@Test
	public void test() {
		
		List<List<String>> codeList = new ArrayList<List<String>>();
		
		List<String> list0 = new ArrayList<>();
		list0.add("orange");
		codeList.add(list0);
		
		List<String> list1 = new ArrayList<>();
		list1.add("apple");
		list1.add("apple");
		codeList.add(list1);
		
		List<String> list2 = new ArrayList<>();
		list2.add("banana");
		list2.add("orange");
		list2.add("apple");		
		codeList.add(list2);
		
		List<String> list3 = new ArrayList<>();
		list3.add("banana");
		codeList.add(list3);
		
		List<String> shoppingCart = new ArrayList<String>();		
		shoppingCart.add("orange");
		shoppingCart.add("apple");
		shoppingCart.add("apple");
		shoppingCart.add("banana");
		shoppingCart.add("orange");
		shoppingCart.add("apple");
		shoppingCart.add("banana");
		
		int result = test.checkWinner(codeList, shoppingCart);
		//assertTrue(result == "sos");
	}

	
}
