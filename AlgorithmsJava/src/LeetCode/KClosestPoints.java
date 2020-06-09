package LeetCode;

import java.util.Comparator;
import java.util.*;

public class KClosestPoints {

	public static void main(String[] args) {
		KClosestPoints sol = new KClosestPoints();
		int[][] data = {{10,20},{30,200},{400,50},{30,20}};
		sol.twoCitySchedCost(data);
	}
	
	class Point {
		public int nr;
		public int X;
		public int Y;
	}
	
	class DistComparator implements Comparator<Point>
	{
	    @Override
	    public int compare(Point p1, Point p2)
	    {
	    	double dist1 = Math.abs(p1.X - p1.Y);
	    	double dist2 = Math.abs(p2.X - p2.Y);
	        if (dist1 <= dist2) return 1;
	        return -1;
	    }
	}
	
	public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	Point point = new Point();
        	point.X = costs[i][0];
        	point.Y = costs[i][1];
        	point.nr = i;
        	list.add(point);
        }
        int sum = 0;
        list.sort(new DistComparator());
        int n1 = n/2;
        int n2 = n/2;
        for (int i = 0; i < n; i++) {
        	int x = list.get(i).X;
        	int y = list.get(i).Y;
        	if (x < y) {
        		if (n1 > 0) {
        			n1--;
        			sum+=x;
        		} else {
        			n2--;
        			sum+=y;
        		}
        	} else {
        		if (n2 > 0) {
        			n2--;
        			sum+=y;
        		} else {
        			n1--;
        			sum+=x;
        		}
        	}
        }
        return sum;
    }
	
	class IncComparator implements Comparator<Point>
	{
	    @Override
	    public int compare(Point p1, Point p2)
	    {
	    	double dist1 = Math.sqrt(p1.X * p1.X + p1.Y * p1.Y);
	    	double dist2 = Math.sqrt(p2.X * p2.X + p2.Y * p2.Y);
	        if (dist1 <= dist2) return 1;
	        return -1;
	    }
	}
    
    public int[][] kClosest(int[][] points, int K) {
    	Queue<Point> q = new PriorityQueue(new IncComparator());
        for (int i = 0; i < points.length; i++) {
        	Point point = new Point();
        	point.X = points[i][0];
        	point.Y = points[i][1];
        	point.nr = i;
        	q.offer(point);
            if (q.size() > K) {
                q.poll();
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
        	Point point = q.poll();
        	res[i][0] = point.X;
        	res[i][1] = point.Y;
        }
        return res;
    }
}
