package LeetCode;

import java.util.Comparator;
import java.util.*;

public class KClosestPoints {

	public static void main(String[] args) {
		KClosestPoints sol = new KClosestPoints();
	}



	class TreeAncestor {


		class Node implements Comparable<Node> {
			public int node;
			public int parentNr;
		
			public Node(int n, int p) {
				node = n;
				parentNr = p;
			}
			
			@Override
			public boolean equals(Object obj) { //needed for list.contains
						return this.node == ((Node) obj).node &&
						this.parentNr == ((Node) obj).parentNr;
			}
		
			@Override
			public int compareTo(Node arg0) { //needed for map.containsKey
				if (node == arg0.node && parentNr == arg0.parentNr) {
					return 0;
				}
				return -1;
			}
			
			@Override
			public int hashCode() { //needed for map.containsKey
				//x * 31 + y
				return this.node * 31 + this.parentNr;
			}
		}

		int[] par;
		int n;
		Map<Node, Integer> map = new HashMap<>();

		public TreeAncestor(int n, int[] parent) {
			int m = parent.length;
			par = new int[m];
			n = m;
			for (int i = 0; i < n; i++) {
				par[i] = parent[i];
			}
		}
		
		public int getKthAncestor(int node, int k) {
			if (k <= 0) return -1;
			if (k == 1) {
				if (node != 0) {
					return par[node];
				} else {
					return -1;
				}
			} else {
				if (node != 0) {
					Node data = new Node(node, k);
					if (map.containsKey(data)) {
						return map.get(data);
					}
					int val = getKthAncestor(par[node], k-1);
					map.put(data, val);
					return val;
				} else {
					return -1;
				}
			}
		}
	}

	private static Comparator<Map.Entry<Integer, Integer>> ValueComparator  = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(
          Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
	};

	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i],0);
			}
			map.put(arr[i], map.get(arr[i])+1);
		}

	    List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());    
		Collections.sort(entries, ValueComparator);	  
		
		int removed = 0;
		int sum = 0;
		for (Map.Entry<Integer, Integer> kvp : entries) {
			int val = kvp.getValue();
			if (sum + val > k) {
				break;
			} else {
				sum += val;
				removed++;
			}
		}
		int size = entries.size();
		return size-removed;
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
