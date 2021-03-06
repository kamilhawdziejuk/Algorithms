package LeetCode;
import java.util.*;

import alg.DataStructures.DoubleLinkedList;
import alg.DataStructures.DoubleListNode;
import alg.Sorts.DataSort.Data;

public class Challenge30Days {
	
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	
	public static void main(String[] args) {
		Challenge30Days prog = new Challenge30Days();
		ListNode l1 = prog.new ListNode(1);
		ListNode l2 = prog.new ListNode(2);
		ListNode l3 = prog.new ListNode(3);
		ListNode l4 = prog.new ListNode(4);
		ListNode l5 = prog.new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		prog.oddEvenList(l1);
		
		prog.frequencySort("Aabb");
		
    	for (int i = 0; i < 32; i++) {
    		int val2 = 1 << i;
    		System.out.println(val2);
    	}		
		prog.findComplement(1);
	}
	
	//Input: 1->2->3->4->5->NULL
	//Output: 1->3->5->2->4->NULL
	//https://leetcode.com/problems/odd-even-linked-list/
	public ListNode oddEvenList(ListNode head) {
    	ListNode oddStart = head;
    	ListNode evenStart = null;
    
    	ListNode oddCurr = head;
    	ListNode evenCurr = null;
    
        if (oddCurr == null) return null;
           
    	while (oddCurr.next != null) {
    		if (evenCurr == null) {
        		evenCurr = oddCurr.next;
        		evenStart = evenCurr;
    		} else {
    			evenCurr.next = oddCurr.next;
    			evenCurr = evenCurr.next;
    		}
    		oddCurr.next = oddCurr.next.next;
    		if (oddCurr.next != null) {
        		oddCurr = oddCurr.next;    			
    		}
    	}
        if (evenCurr != null) {
    	    evenCurr.next = null;            
        }
    	oddCurr.next = evenStart;
        return oddStart;
    }
    
	class DataC implements Comparable<DataC> {
		public char c;
		public int cnt;
		@Override
		public int compareTo(DataC arg0) {
			
			if (this.cnt < arg0.cnt)
			{
				return 1;
			}
			else if (this.cnt > arg0.cnt)
			{
				return -1;
			}
			return 0;
		}			
	}

    public String frequencySort(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	for (Character c : s.toCharArray()) {
    		if (!map.containsKey(c)) {
    			map.put(c, 0);
    		}
    		map.put(c, map.get(c)+1);
    	}
    	
    	List<DataC> list = new ArrayList<>();
    	for (Character c : map.keySet()) {
    		DataC data = new DataC();
    		data.c = c;
    		data.cnt = map.get(c);
    		list.add(data);
    	}
    	
    	Collections.sort(list);
    	String res = "";
    	StringBuilder str = new StringBuilder();
    	for (DataC data : list) {
    		char c = data.c;
    		int cnt = data.cnt;
    		
    		for (int i = 0; i < cnt; i++) {
    			str.append(c);
    		}
    	}
    	res = str.toString();
    	return res;   
    }
	
    public int findComplement(int num) {
    	int res = 0;
    	for (int i = 0; i < 32; i++) {
    		int val2 = 1 << i;
    		if (val2 > num) break;
    		int num2 = (num & val2);
    		if (num2 != val2) {
    			res += val2;
    		}
    		
    	}
    	return res;
    }
	
	//challenge 29
	 int max = Integer.MIN_VALUE;
	   
    public int maxPathSum(TreeNode root) {
        calc(root);
        return max;
    }
    
    private int calc(TreeNode root) {
        int valLeft = root.left != null ? calc(root.left): 0; 
        int valRight = root.right != null ? calc(root.right) : 0; 
        int maxInner = maxTab(new int[] {root.val, root.val + valLeft, root.val + valRight});
        max = maxTab(new int[] {max, maxInner, root.val + valRight + valLeft});
        return maxInner;
    }
    
    private int maxTab(int[] tab) {
    	int m = tab[0];
    	for (int i = 1; i < tab.length; i++) {
    		m = Math.max(m,  tab[i]);
    	}
    	return m;
    }
	
	
	//challenge 28
	class FirstUnique {
		
		class ListNode {
	        final int value;
	        ListNode next;
	        ListNode previous;

	        ListNode(int value) {
	            this.value = value;
	        }
	    }
		
	    private final ListNode head = new ListNode(999);
	    private final ListNode tail = new ListNode(999);
	    private final Map<Integer, ListNode> map;
	    private int nodesCount;
		
	    public FirstUnique(int[] nums) {
	        this.map = new HashMap<>();
	        head.next = tail;
	        tail.previous = head;
	        this.nodesCount = 0;
	        
	        for (int i = 0; i < nums.length; i++) {
	        	this.add(nums[i]);
	        }
	    }
	    
	    public void add(int num) {
	        if (map.containsKey(num)) {
	            ListNode node = map.get(num);
	            deleteNode(node);
	        } else {
	            ListNode newNode = new ListNode(num);
	            map.put(num, newNode);
	            insertAtTheTail(newNode);
	        }
	    }
	    
	    public int showFirstUnique() {
	        if (isEmpty()) return -1;
	        return head.next.value;
	    }

	    private void deleteNode(ListNode node) {
	        ListNode next = node.next;
	        ListNode previous = node.previous;
	        if (previous != null && next != null) {
	            previous.next = next;
	            next.previous = previous;
	            node.next = null;
	            node.previous = null;
	            nodesCount--;
	        }
	    }

	    private void insertAtTheTail(ListNode newNode) {
	        ListNode previous = tail.previous;
	        newNode.previous = previous;
	        previous.next = newNode;
	        newNode.next = tail;
	        tail.previous = newNode;
	        nodesCount++;
	    }

	    private boolean isEmpty() {
	        return nodesCount == 0;
	    }
	}

	/**
	 * Your FirstUnique object will be instantiated and called as such:
	 * FirstUnique obj = new FirstUnique(nums);
	 * int param_1 = obj.showFirstUnique();
	 * obj.add(value);
	 */
	
	//challenge 27
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
    
        int[][] left = left_matrix(matrix, n, m);
        int[][] top = top_matrix(matrix, n, m);
        
        int[][] L = new int[n][m];
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (matrix[i][j] == '1') {
        			L[i][j] = Math.min(left[i][j], top[i][j]);
        			if (i > 0 && j > 0) {
        				L[i][j] = Math.min(L[i][j], L[i-1][j-1]+1);
        			}
        	
        		} else {
        			L[i][j] = 0;
        		}
        		
        	}
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		max = Math.max(max,  L[i][j]);
        	}
        }
        
        return max*max;
    }
    
    public int[][] left_matrix(char[][] matrix, int n, int m) {
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
        	mat[i][0] = matrix[i][0] == '1' ? 1 : 0;
        	for (int j = 1; j < m; j++) {
        		if (matrix[i][j] == '0') {
        			mat[i][j] = 0;
        		} else {
        			mat[i][j] = 1 + mat[i][j-1];
        		}
        	}
        }
        return mat;
    }
    
    public int[][] top_matrix(char[][] matrix, int n, int m) {
        int[][] mat = new int[n][m];
        for (int j = 0; j < m; j++) {
        	mat[0][j] = matrix[0][j] == '1' ? 1 : 0;
        	for (int i = 1; i < n; i++) {
        		if (matrix[i][j] == '0') {
        			mat[i][j] = 0;
        		} else {
        			mat[i][j] = 1 + mat[i-1][j];
        		}
        	}
        }
        return mat;
    }
	
	//challange 26
	public int longestCommonSubsequence(String text1, String text2) {
        char[] x = text1.toCharArray();
        char[] y = text2.toCharArray();
        return lcs(x,y,x.length, y.length);
    }
    
    private int lcs(char[] x, char[] y, int m, int n) {
        int l[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    l[i][j] = 0;
                } else if (x[i-1] == y[j-1]) {
                    l[i][j] = 1 + l[i-1][j-1];
                } else {
                    l[i][j] = Math.max(l[i-1][j], l[i][j-1]);                    
                }
            }
        }
        return l[m][n];
    }
	
	//challange 23
	public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < nums.length; i++) {
        	        	
            if (set.contains(i)) {
                for (int j = 1; j <= nums[i]; j++) {
                    int next = i + j;
                    if (next == nums.length-1) {
                        return true;
                    } else {
                        set.add(next);                        
                    }
                }
            }
        }
        return false;
    }
	
	//challange 22 - optimal implementation using LinkedHashMap
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
	
	//challange 22
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
	
	//challenge 21
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
	
	//day 20 challange
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
