package LeetCode;

public class LeetCode236 {

	public static void main(String[] args) {
		LeetCode236 sol = new LeetCode236();
		
		TreeNode n37 = sol.new TreeNode(37);
		TreeNode n34_ = sol.new TreeNode(-34);
		TreeNode n48_ = sol.new TreeNode(-48);
		TreeNode n100_ = sol.new TreeNode(-100);
		TreeNode n101_ = sol.new TreeNode(-101);
		TreeNode n48 = sol.new TreeNode(48);
		TreeNode n54_ = sol.new TreeNode(-54);
		TreeNode n71_ = sol.new TreeNode(-71);
		TreeNode n22_ = sol.new TreeNode(-22);
		TreeNode n8 = sol.new TreeNode(8);
		
		n37.left = n34_;
		n37.right = n48_;
		n34_.right = n100_;
		n48_.left = n101_;
		n48_.right = n48;
		n48.left = n54_;
		n54_.left = n71_;
		n54_.right = n22_;
		n22_.right = n8;
		
		TreeNode res = sol.lowestCommonAncestor(n37,  n71_, n48);
		
	}
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	    
	    class NodeX {
	        TreeNode node;
	        int val;
	        
	        NodeX(TreeNode node_, int val_) {
	            val = val_;
	            node = node_;
	        }
	    }
	   
	     
	    private NodeX count(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null) {
	            return new NodeX(null, 0);
	        }
	        
	        int cnt = 0;
	        if (root.val == p.val) {
	            cnt = 1;
	        } else if (root.val == q.val) {
	            cnt = 2;
	        }
	        
	        NodeX leftX = count(root.left, p, q);
	        NodeX rightX = count(root.right, p, q);
	        
	        if (leftX.val == 3) {
	            return new NodeX(root.left, 3);
	        } else if (rightX.val == 3) {
	            return new NodeX(root.right, 3);
	        } else if (leftX.val + rightX.val + cnt == 3) {
	            return new NodeX(root, 3);
	        } else if (leftX.val > 0) {
	            return new NodeX(root.left, leftX.val+cnt);
	        } else if (rightX.val > 0) {
	            return new NodeX(root.right, rightX.val+cnt);
	        } else {
	            return new NodeX(root, cnt);
	        }
	    }
	    
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        NodeX node = count(root, p, q);
	        if (node.val == 3) {
	            return node.node;
	        } else {
	            return root;
	        }
	    }
	   
	
}
