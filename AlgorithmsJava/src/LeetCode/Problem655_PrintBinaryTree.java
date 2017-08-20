//https://leetcode.com/problems/print-binary-tree/description/
//100%
package LeetCode;

import java.util.*;

import alg.DataStructures.TreeNode;


public class Problem655_PrintBinaryTree {

	int _lenght;
	Map<TreeNode, Integer> positions = new HashMap<>();	
	Map<TreeNode, Integer> levels = new HashMap<>();	
	
	List<String> getRow(List<TreeNode> row) {
		List<String> rowStr = new ArrayList<String>();
		for (int i = 0; i < _lenght-1; i++) rowStr.add("");
		
		int rowSize = row.size();
		for (int i = 0; i < rowSize; i++) {
			TreeNode node = row.get(i);
			int pos = positions.get(node);
			rowStr.set(pos, String.valueOf(node.val));
		}    			
		return rowStr;
	}
	
	List<List<String>> printLevelOrder(TreeNode root) 
    {
		List<List<String>> results = new ArrayList<List<String>>();
		
		int level = 0;
    	Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(root);
        
        List<TreeNode> row = new ArrayList<>();
        
        while (!queue.isEmpty()) 
        {
            //poll() removes the present head.
        	TreeNode tempNode = queue.poll();
        	int currentLevel = levels.get(tempNode);
        	
        	if (currentLevel > level) {
        		
    			List<String> rowStr = getRow(row);
    			results.add(rowStr);
    			
    			//prepare for new one
        		row.clear();
        		row.add(tempNode);        			
        		
        		level = currentLevel;
        	}
        	else { //same level
        		row.add(tempNode);
        	}
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        
		List<String> rowStr = getRow(row);
		results.add(rowStr);
        
        return results;
    }
	
    void parse(int a, int b, TreeNode root, int level) {
    	if (root == null) return;
    	int mid = a + (b-a)/2;
    	positions.put(root, mid);
    	levels.put(root, level);
    	parse(a, mid-1, root.left, level+1);
    	parse(mid+1, b, root.right, level+1);    	
    }
    
	int maxDepth(TreeNode root) {
		if (root == null)
		{
			return 0;
		}
		else
		{
			int dLeft = 1 + maxDepth(root.left);
			int dRight = 1 + maxDepth(root.right);
			return Math.max(dLeft, dRight);
		}
	}	
	  
    public List<List<String>> printTree(TreeNode root) {
    	int depth = maxDepth(root);
    	_lenght = (int) Math.pow(2, depth);
    	parse(0, _lenght-1, root, 0); 
    	List<List<String>> res = printLevelOrder(root);
		return res;        
    }	  
}
