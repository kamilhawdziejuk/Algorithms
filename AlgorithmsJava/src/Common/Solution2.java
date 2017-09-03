package Common;

import java.util.*;

public class Solution2 {
	
	int rows;
	int cols;
	
	public static void main(String [ ] args)
	{
		Solution2 sol = new Solution2();
		List<List<Integer>> fields = new ArrayList<List<Integer>>();
		
		//1 1 1
		//3 0 2
		
		List<Integer> list1 = new ArrayList<>();		
		list1.add(1);
		list1.add(1);
		list1.add(1);
		
		List<Integer> list2 = new ArrayList<>();		
		list2.add(3);
		list2.add(0);
		list2.add(2);

		fields.add(list1);
		fields.add(list2);
		
		int result = sol.levelField(2, 3, fields);
	}

	private static Comparator<Position> HeightComparator = new Comparator<Position>() 
	{
		@Override
		public int compare(Position arg0, Position arg1) {
			if (arg1.val < arg0.val)
			{
				return -1;
			}
			else if (arg1.val > arg0.val)
			{
				return 1;
			}
			return 0;
		}
	};	
	
	public class Position implements Comparable<Position>{
		public int x,y;		
		boolean isVisited = false;
		int dist = 0;
		int val = 0;
		public Position(int a, int b) {
			x = a;
			y = b;
		}
		@Override
		public int compareTo(Position pos) {
			if (pos.x == x && pos.y == y) return 0;
			return -1;
		}
	}
	
	//main method
	public int levelField(int numRows, int numColumns, List<List<Integer>> field)
    {
    	rows = numRows;
    	cols = numColumns;
    	
    	List<Position> trees = FindTrees(field);
    	trees.sort(HeightComparator);
    	Position last = new Position(0,0);
    	
    	int total = 0;
    	
    	for (int i = 0; i < trees.size(); i++) {
    		Position currentTree = trees.get(i);
    		int length = bfs(field, last, currentTree);
    		
    		if (length > 0) {
    			total += length;
    		}
    		else {
    			return -1;
    		}
    		last = currentTree;
    	}
    	return total;
    }
	
	Map<Position, Boolean> visitedBFS = new HashMap<Position, Boolean>();
	
	private int bfs(List<List<Integer>> field, Position root, Position target)
    {
		visitedBFS.clear();
        //Since queue is a interface
        Queue<Position> queue = new LinkedList<Position>();
        if(root == null) return -1;

        root.isVisited = true;        
        root.dist = 0;        
        queue.add(root);

        while(!queue.isEmpty())
        {
            //removes from front of queue
        	Position r = queue.remove();
        	if (r == target) {
        		return r.dist;
        	}
            visitedBFS.put(r, true);
            
        	List<Position> adj = getNext(rows, cols, r.x, r.y);
        	
            for(Position next: adj)
            {
            	int val = getVal(field, next);
            	if (val == 0 ) continue;
            	
                if(!visitedBFS.containsKey(next))// !next.isVisited
                {
                	next.dist = r.dist+1;
                    queue.add(next);
                    next.isVisited = true;
                }
            }
        }
        return -1;
    }
    
    private List<Position> FindTrees(List<List<Integer>> field) {
    	List<Position> trees = new ArrayList<Position>();
    	
    	for (int i = 0; i < field.size(); i++) {
    		List<Integer> row = field.get(i);
    		for (int j = 0; j < row.size(); j++) {
    			Position node = new Position(i,j);
    			node.val = row.get(j);
    			if (node.val > 1) { //tree
    				trees.add(node);
    			}
    		}
    	}
    	return trees;
    }
        
    boolean check(int rows, int cols, Position pos) {
    	return pos.x >= 0 && pos.y >= 0 && pos.x < cols && pos.y < cols;
    }
    
    int getVal(List<List<Integer>> field, Position p) {
    	return getVal(field, p.x, p.y);
    }
    
    
    int getVal(List<List<Integer>> field, int r, int c) {
    	List<Integer> row = field.get(r);
    	return row.get(c);
    }
    
	List<Position> getNext(int rows, int cols, int r, int c)
	{
		List<Position> positions = new ArrayList<Position>();
		Position p1 = new Position(r-1,c);
		Position p2 = new Position(r+1,c);
		Position p3 = new Position(r,c-1);
		Position p4 = new Position(r,c+1);
		
		if (check(rows, cols, p1)) positions.add(p1);
		if (check(rows, cols, p2)) positions.add(p2);
		if (check(rows, cols, p3)) positions.add(p3);
		if (check(rows, cols, p4)) positions.add(p4);
				
		return positions;
	}
	
}
