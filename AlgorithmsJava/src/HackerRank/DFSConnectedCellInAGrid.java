package HackerRank;
//https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class DFSConnectedCellInAGrid {

	public class Point
	{
		public int row;
		public int col;
		public Point(int _x, int _y) { row= _x; col = _y;}
	}

	int cnt = 0;
    int grid[][];
    int n;
    int m;
    
    boolean IsIn(Point p)
    {
    	return p.row >= 0 && p.col >= 0 && p.row < n && p.col < m;
    }
    
    List<Point> getNexts(Point p)
    {
    	List<Point> list = new ArrayList<Point>();
    	Point p1 = new Point(p.row-1, p.col-1);
    	Point p2 = new Point(p.row-1, p.col);
    	Point p3 = new Point(p.row-1, p.col+1);
    	Point p4 = new Point(p.row, p.col-1);
    	Point p5 = new Point(p.row, p.col+1);
    	Point p6 = new Point(p.row+1, p.col-1);
    	Point p7 = new Point(p.row+1, p.col);
    	Point p8 = new Point(p.row+1, p.col+1);

    	if (IsIn(p1)) list.add(p1);
    	if (IsIn(p2)) list.add(p2);
    	if (IsIn(p3)) list.add(p3);
    	if (IsIn(p4)) list.add(p4);
    	if (IsIn(p5)) list.add(p5);
    	if (IsIn(p6)) list.add(p6);
    	if (IsIn(p7)) list.add(p7);
    	if (IsIn(p8)) list.add(p8);

    	return list;
    }
	
    public void dfs(Point p)
    {       
    	cnt++;
    	grid[p.row][p.col] *= -1;
    			
    	List<Point> nexts = getNexts(p);
        for(Point next : nexts)
        {
            if(grid[next.row][next.col] == 1)
            {
                dfs(next);
            }
        }
    }

    public void read()
    {
    	Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        grid = new int[n][m];

        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
    }
    
    public void calc()
    {
    	int maxCnt = 0;
    	for (int i = 0; i < n; i++)
    	{
    		for (int j = 0; j < m; j++)
    		{
    			if (grid[i][j] == 1)
    			{
    				cnt = 0;
    				dfs(new Point(i,j));
    				maxCnt = Math.max(cnt,  maxCnt);
    			}
    		}
    	}
    	System.out.println(maxCnt);
    }
	
	public static void main(String[] args) {
        
		DFSConnectedCellInAGrid sol = new DFSConnectedCellInAGrid();
        sol.read();
        sol.calc();
    }
}
