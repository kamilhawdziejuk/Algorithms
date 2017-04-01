package alg.DataStructures;

public class LinkedList {
	
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	 public ListNode rotateRight(ListNode head, int k) {
	        int n = calcSize(head);
	        if (n == 0 || k == 0) return head;
	        if (k >= n && (k % n == 0)) return head;
	        
	        k = k % n;
	        int i = 1;        
	        ListNode newhead = null;
	        ListNode tmp = head;
	        while (tmp.next != null)
	        {
	            if (i == n-k)
	            {
	                newhead = tmp.next;
	            }
	            i++;
	            tmp = tmp.next;
	        }
	        tmp.next = head;
	        for (i = 0; i < n-k; i++)
	        {
	        	tmp = tmp.next;
	        }
	        tmp.next = null;
	        
	        return newhead;
	    }
	    
	    public int calcSize(ListNode head) {
	        return head != null ? 1 + calcSize(head.next) : 0;
	    }
}
