package alg.DataStructures;

import org.junit.*;
import java.util.*;


public class BinaryTreeTest {
	BinaryTree test;
		 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new BinaryTree();
	  }
	
	@Test
	public void test() {		
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node2 = new Node(2);

		node1.left = node3;
		node1.right = node2;
		
		test.printBoundary(node1);		
	}

}
