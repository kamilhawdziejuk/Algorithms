package LeetCode;

import java.util.*;

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