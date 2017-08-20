//http://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

package alg.DataStructures;

import java.util.*;

public class BinaryTree {
	
	public class LevelNode {		
		public int Level = 0;
		public Node Item = null;
		public boolean Taken = false;
		public LevelNode(Node item, int level) {
			Item = item;
			Level = level;
		}
	}
	
	Node root;
	List<LevelNode> list = new ArrayList<>();
	 
    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */
    void printLevelOrder() 
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
    
    void FillLevelOrder() 
    {
    	Queue<LevelNode> queue = new java.util.LinkedList<>();
        queue.add(new LevelNode(root, 1));
        
        while (!queue.isEmpty()) 
        {
            //poll() removes the present head.
            LevelNode tempNode = queue.poll();
            //System.out.print(tempNode.data + " ");
            list.add(tempNode);
 
            /*Enqueue left child */
            if (tempNode.Item.left != null) {
                queue.add(new LevelNode(tempNode.Item.left, tempNode.Level+1));
            }
 
            /*Enqueue right child */
            if (tempNode.Item.right != null) {
                queue.add(new LevelNode(tempNode.Item.right, tempNode.Level+1));
            }
        }
    }
    
	void printBoundary(Node node)
	{
		root = node;
		FillLevelOrder();
		int lastLevel = 0;
		for (int i = 0; i < list.size(); i++) {
			LevelNode levelNode = list.get(i);
			if (!levelNode.Taken) {
				if (levelNode.Level > lastLevel) {
					levelNode.Taken = true;
					lastLevel = levelNode.Level;
					System.out.print(levelNode.Item.data + " ");
				}
			}
		}
		lastLevel++;
		for (int i = list.size()-1; i > 0; i--) {
			LevelNode levelNode = list.get(i);
			if (!levelNode.Taken) {
				if (levelNode.Level < lastLevel) {
					levelNode.Taken = true;
					lastLevel = levelNode.Level;
					System.out.print(levelNode.Item.data + " ");
				}
			}
		}
			
		// Your code here
	}
	
}
