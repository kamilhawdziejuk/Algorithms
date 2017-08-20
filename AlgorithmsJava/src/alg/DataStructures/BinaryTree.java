//http://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
//100%

package alg.DataStructures;
import java.util.*;

public class BinaryTree {
	
    /* Given a binary tree. Print its nodes in level order  using array for implementing queue  */
    void printLevelOrder(Node root) 
    {
    	Queue<Node> queue = new java.util.LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
            /* poll() removes the present head.
            For more information on poll() visit 
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
  
 // A simple function to print leaf nodes of a binary tree
    void printLeaves(Node n) {
    	if (n == null)
    		return;
    	// Print it if it is a leaf node
    	if (n.left == null && n.right == null) {
    		System.out.println(n.data + " ");
    	}
    	printLeaves(n.left);
    	printLeaves(n.right);
    }

    private boolean isLeaf(Node n) {
     return n != null && n.left == null && n.right == null;
    }

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node n) {
    	if (n == null || isLeaf(n))
    		return;
    	// to ensure top down order, print the node
    	// before calling itself for left subtree
    	if (n.left != null) {
    		System.out.println(n.data + " ");
    		printBoundaryLeft(n.left);
    	} 
    	else if (n.right != null) {
    		System.out.println(n.data + " ");
    		printBoundaryLeft(n.right);
    	}
    	// do nothing if it is a leaf node, this way we avoid
    	// duplicates in output
    }

    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node n) {
    	if (n == null || isLeaf(n))
    		return;
    	// to ensure bottom up order, first call for right
    	// subtree, then print this node
    	if (n.right != null) {
    		printBoundaryRight(n.right);
    	} 
    	else if (n.left != null) {
    		printBoundaryRight(n.left);
    	}
    	System.out.println(n.data + " ");
    	// do nothing if it is a leaf node, this way we avoid
    	// duplicates in output
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node root) {
    	if (root == null)
    		return;
    	System.out.println(root.data + " ");
    	// Print the left boundary in top-down manner.
    	printBoundaryLeft(root.left);
    	
    	// Print all leaf nodes
    	printLeaves(root);

    	// Print the right boundary in bottom-up manner
    	printBoundaryRight(root.right);
    }
}
