//https://www.hackerrank.com/contests/w33/challenges/transform-to-palindrome/problem
// 100%

package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TransformToPalindrome {

	Scanner in;
	int n, k, m;
	int[] tab;
	Map<Integer, Integer> groupToMin = new HashMap<>(); //each number points to some group
	Map<Integer, Node> nodes = new HashMap<>();
	int groupNr = 0;
	int currentMin = 0;
	
	public class Node {
	    public int val;
	    public int groupNr;
	    public boolean isVisited = false;
	    LinkedList<Node> adj = new LinkedList<Node>( );

	    public void addAdjNode(final Node Child){
	    	adj.add(Child);
	    }

	    public Node(int _val) {
			val = _val;
	    }
	}
	
    public void dfs(Node root, int _groupNr)
    {       
        if(root == null) return;
        root.isVisited = true;
        root.groupNr = _groupNr;
        if (currentMin > root.val) {
        	currentMin = root.val;
        }
        for(Node next : root.adj)
        {
            if(!next.isVisited)
            {
                dfs(next, _groupNr);
            }
        }
    }
   
	
	public TransformToPalindrome() {
		in = new Scanner(System.in);
	}
	
    public void Read() {

        n = in.nextInt();
        k = in.nextInt();
        m = in.nextInt();
        for(int i = 0; i < k; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            
            if (!nodes.containsKey(x)) {
            	Node node = new Node(x);
            	nodes.put(x, node);
            } 
            if (!nodes.containsKey(y)) {
            	Node node = new Node(y);
            	nodes.put(y, node);
            } 
            Node nodeX = nodes.get(x);
            Node nodeY = nodes.get(y);
            nodeX.addAdjNode(nodeY);
            nodeY.addAdjNode(nodeX);
        }
        
        tab = new int[m];
        for(int i=0; i < m; i++){
            tab[i] = in.nextInt();
        }
    }
    
    public void Calc() {
    	
		for (Map.Entry<Integer, Node> entry : nodes.entrySet())
		{
			Integer nr = entry.getKey();
			Node node = entry.getValue();
			
			if (!node.isVisited) {
				groupNr++;
				currentMin = node.val;
				this.dfs(node, groupNr);
				
				this.groupToMin.put(groupNr, currentMin);
			}
		}	
		
		//update group nr to smallest
		for (Map.Entry<Integer, Node> entry : nodes.entrySet())
		{
			Integer nr = entry.getKey();
			Node node = entry.getValue();
			int newGroupNr = this.groupToMin.get(node.groupNr);
			node.groupNr = newGroupNr;
		}
    }
    
    public void Improve() {
    	for (int i = 0; i < m ;i++ ) {
    		Node node = nodes.get(tab[i]);
    		if (node != null) {
	    		int groupNr = node.groupNr;
	    		tab[i] = groupNr;
    		}
    	}
    }

    public class Data {
    	public boolean IsCenter = false;
    	public int Value = 0;
    }
       
    public void Find() {
    	Data data[] = new Data[m];
    	for (int i = 0 ; i < m; i++) {
    		data[i] = new Data();
    		data[i].IsCenter = false;
    		data[i].Value = 0;
    	}

    	for (int pos = 0; pos < m; pos++) {
    		
    		int val = tab[pos];
        	int size = 0;

    		for (int j = m-1; j >= pos; j--) {
    			
    			if (data[j].Value > size) {
    				size = data[j].Value;
    			}
    			else {
	    			int val2 = tab[j];    				    			
	    			if (val == val2) {
	    				data[j].Value = Math.max(data[j].Value, size+1);
	    				if (j == pos) {
	    					data[j].IsCenter = true;
	    				}
	    			}
    			}
    		}
    	}

    	int maxPalindromLength = 0;
    	for (int i = 0; i < m ;i++) {
    		if (data[i].IsCenter) {
    			maxPalindromLength = Math.max(data[i].Value*2-1,  maxPalindromLength);
    		}
    		else {
    			maxPalindromLength = Math.max(data[i].Value*2,  maxPalindromLength);
    		}
    		
    	}
    	System.out.println(maxPalindromLength);
    }
    
    public static void main(String[] args) {
    	TransformToPalindrome sol = new TransformToPalindrome();
    	sol.Read();
    	sol.Calc();
    	sol.Improve();
    	sol.Find();
    }
	
}
