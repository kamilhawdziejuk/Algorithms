import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;


import org.junit.Test;

public class BinaryHeapTest {

	  BinaryHeap heap;
		 
	  @Before
	  public void setUp() throws Exception {
		  
		  heap = new BinaryHeap(5);
	  }
	
	@Test
	public void test() {
		heap.insert(5);
		heap.insert(2);
		heap.insert(10);
		heap.insert(1);
		heap.insert(24);
		int min = heap.findMin();
		assertTrue(min == 1);
		int min2 = heap.findMin();
		assertTrue(min2 == 1);
		heap.deleteMin();
		int min3 = heap.findMin();
		assertTrue(min3 == 2);
	}

}
