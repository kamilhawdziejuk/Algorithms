package LeetCode;

public class TreeNodeIsCousins {
	
	
	 public class TreeNode 
	 {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	
	 	TreeNode parent = null;
	    
	    public boolean isCousins(TreeNode root, int x, int y) {
	        int dx = depth(root, x);
	        int dy = depth(root, y);
	        
	        if (dx != dy) return false;
	        sameParent(root, x, y);
	        return !found;
	    }
	    
	    private int depth(TreeNode root, int x) {
	        if (root == null) return -1;
	        else if (root.val == x) return 0;
	        else {
	            int dl = depth(root.left, x);
	            int dr = depth(root.right, x);
	            
	            if (dl != -1) {
	                return dl+1;
	            } else if (dr != -1) {
	                return dr+1;
	            } else {
	                return -1;
	            }
	        }  
	    }
	    
	    boolean found = false;
	    private void sameParent(TreeNode root, int x, int y) {
	        if (root.left != null && root.right != null) {
	            if ((root.left.val == x && root.right.val == y) || 
	                (root.left.val == y && root.right.val == x)) {
	                found = true;
	            }
	        }
	        if (!found && root.left != null) {
	            sameParent(root.left, x, y);
	        }
	        if (!found && root.right != null) {
	            sameParent(root.right, x, y);
	        }
	    }
}
