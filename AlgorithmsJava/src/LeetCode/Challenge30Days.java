package LeetCode;

public class Challenge30Days {
	
	public static void main(String[] args) {
		Challenge30Days prog = new Challenge30Days();
		int[] input = {8,5,1,7,10,12};
		TreeNode root = prog.bstFromPreorder(input);
	}
	
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 
	int nr = 0;
	  
	//Construct Binary Search Tree from Preorder Traversal (day 20 challange)
    public TreeNode bstFromPreorder(int[] preorder) {
    	
    	if (preorder == null || preorder.length == 0) return null;
    	TreeNode root = new TreeNode(preorder[nr]);
    	nr++;
    	root.left = calc(preorder, root, Integer.MIN_VALUE, root.val);
    	root.right = calc(preorder, root, root.val, Integer.MAX_VALUE);
        return root;
    }
	
    private TreeNode calc(int[] preorder, TreeNode parent, int from, int to) {
    	if (nr >= preorder.length) return null;
    	int val = preorder[nr];
    	if (val > from && val < to) {
    		TreeNode node = new TreeNode(preorder[nr]);
    		nr++;
    		node.left = calc(preorder, node, from, node.val);
    		node.right = calc(preorder, node, node.val, to);  
    		return node;
    	}
        return null;
    }
	
}
