package LeetCode;

import alg.DataStructures.TreeNode;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class ProblemKSmallest {
	int res = -1;
    public int kthSmallest(TreeNode root, int k) {
		walk(root, k, 0);
        return res;
    }
    
    private boolean walk(TreeNode root, int k, int cnt) {
    	if (root.left != null) {
    		if (walk(root.left, k, cnt)) return true;
    	}
    	cnt++;
    	if (cnt == k) {
    		res = root.val;
    		return true;
    	}
    	if (root.right != null) {
    		if (walk(root.right, k, cnt)) return true;
    	}
		return false;
    }
}
