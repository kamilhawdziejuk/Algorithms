package LeetCode;
import java.util.*;

import alg.Sorts.DataSort.Data;

public class Challenge30Days {
	
	public static void main(String[] args) {
		Challenge30Days prog = new Challenge30Days();

		LRUCache cache = prog.new LRUCache( 2 /* capacity */ );
	}
	
	//challange 23 - optimal implementation using LinkedHashMap
	class LRUCache {
	    private LinkedHashMap<Integer, Integer> cache;
	    private int N;
	    
	    public LRUCache(int capacity) {
	        this.N = capacity;
	        this.cache = new LinkedHashMap<Integer, Integer>();
	    }
	    
	    public int get(int key) {
	        int result = -1;
	        
	        if(this.cache.containsKey(key)){
	            result = this.cache.get(key);
	            this.cache.remove(key);
	            this.cache.put(key, result);
	        }
	        
	        return result;
	    }
	    
	    public void put(int key, int value) {
	        if(this.cache.containsKey(key)){
	            this.cache.remove(key);
	        }else{
	            if(this.cache.size() == N){
	                Integer firstKey = this.cache.keySet().iterator().next();
	                this.cache.remove(firstKey);
	            }
	        }
	        
	        this.cache.put(key, value);
	    }
	}
	
	//challange 23
	class LRUCache_notOptimal {
		
		class Node {
			public int key;
			public int cnt;
			public int val;
		}
		
		class IncComparator implements Comparator<Node>
		{
		    @Override
		    public int compare(Node x, Node y)
		    {
		        if (x == y) return 0;
		        if (x.cnt == y.cnt) return 0;
		        if (x.cnt < y.cnt) return -1;
		        return 1;
		    }
		}

		Queue<Node> q = new PriorityQueue<>(new IncComparator());
		Map<Integer, Integer> map = new HashMap<>();
		int cap;
		int inc = 0;
		
	    public LRUCache_notOptimal(int capacity) {
	        cap = capacity;
	    }
	    
	    public int get(int key) {
	    	
	    	inc++;
	    	if (map.containsKey(key)) {
	    		inc++;
	    	
	    		for (Node n : q) {
	    			if (n.key == key) {
	    				n.cnt = inc;
	    				break;
	    			}
	    		}
	    		
	    		return map.get(key);
	    	}
	    	return -1;
	    }
	    
	    public void put(int key, int value) {
	    	inc++;
	    	if (map.containsKey(key)) {	
	    		q.removeIf(task -> task.key == key);
    			
    			Node node2 = new Node();
	    		node2.key = key;
	    		node2.val = value;
	    		node2.cnt = inc;
	    		q.offer(node2);
	    		map.put(key, value);
	    	} else {
	    		if (q.size() == this.cap) {
	    			//Node node = q.poll();
	    			Node node = q.peek();
	    			int min = node.cnt;
	    			for (Node n : q) {
	    				if (n.cnt < min) {
	    					node = n;
	    					min = n.cnt;
	    				}
	    			}
	    			q.remove(node);
	    			int keyToRemove = node.key;
	    			map.remove(node.key);
	    		}
		        map.put(key, value);
		        Node node = new Node();
		        node.key = key;
		        node.val = value;
		        node.cnt = inc;
		        q.offer(node);
	    	}
	    }
	}
	
	//challenge 22
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        while (m < n) {
        	res &= (m+1);
        	m++;
        	if (res == 0) return 0;
        }
        res &= n;
        return res;
    }
	
	//day 21 challange
    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int cnt = 0;
        int n = nums.length;
        int[] sum = new int[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
        	s += nums[i];
        	sum[i] = s;
        	
        	if (!map.containsKey(sum[i])) {
        		map.put(sum[i], new ArrayList<>());
        	}
        	map.get(sum[i]).add(i);
        }
        
        if (!map.containsKey(0)) {
        	map.put(0, new ArrayList<>());
        }
        map.get(0).add(-1);
        
        for (int i = n-1; i >= 0; i--) {
        	int val = sum[i];
        	int val2 = val-k;
    		if (map.containsKey(val2)) {	
    			List<Integer> list = map.get(val2);
    			for (int j = 0; j < list.size(); j++) {
    				if (list.get(j) < i) {
    					cnt++;
    				}
    			}
    		}
    	}
        return cnt;
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
