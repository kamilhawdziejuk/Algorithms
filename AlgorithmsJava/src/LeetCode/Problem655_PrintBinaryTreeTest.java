package LeetCode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import alg.DataStructures.TreeNode;

public class Problem655_PrintBinaryTreeTest {
	Problem655_PrintBinaryTree test;
	 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new Problem655_PrintBinaryTree();
	  }
	
	@Test
	public void test() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n2.right = n4;
		n1.left = n2;
		n1.right = n3;		

		test.printTree(n1);
	}
}
