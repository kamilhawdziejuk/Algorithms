package LeetCode;

import java.util.LinkedList;
import java.util.*;

public class PossibleBipartition {

	public class Elem {
	    public int val;
	    List<Elem> adj = new LinkedList<Elem>( );
	    public Elem(int data) {
	        this.val = data;
	    }
	}
	
	public static void main(String[] args) {
		
		PossibleBipartition prog = new PossibleBipartition();
		int[] A = {2,1};
		int[] B = {1,2,1,2};
		
		int[][] dislikes = {{1,2},{1,3},{2,3}};
				
		prog.possibleBipartition(3, dislikes);
		//prog.maxUncrossedLines(A, B);
	}
	
	Map<Integer, Integer> visited = new HashMap<>();
    List<Elem> list = new ArrayList<>();
	
    public boolean possibleBipartition(int N, int[][] dislikes) {
        for (int i = 1; i <= N; i++) {
        	list.add(new Elem(i));
        }
        
        for (int i = 0; i < dislikes.length; i++) {
        	int a = dislikes[i][0];
        	int b = dislikes[i][1];
        	list.get(a-1).adj.add(new Elem(b));
        	list.get(b-1).adj.add(new Elem(a));
        }
        
        for (int i = 0; i < list.size(); i++ ) {
        	if (!visited.containsKey(i+1)) {
            	if (!dfs(list.get(i), 0)) {
            		return false;
            	}
        	}
        }
        
        return true;
    }
    
    public boolean dfs(Elem root, int nr)
    {       
    	int be = nr % 2 == 0 ? 1 : -1;
        if(root == null) return true;
        if (visited.containsKey(root.val)) {
        	if (visited.get(root.val) != be) {
        		return false;
        	} else {
        		return true;
        	}
        }
        visited.put(root.val, be);
        for(Elem next : list.get(root.val-1).adj)
        {
        	if (!dfs(next, nr+1)) {
        		return false;
        	}
        }
        return true;
    }
    
}
