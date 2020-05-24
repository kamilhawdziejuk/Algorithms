package LeetCode;

import java.util.*;

//https://leetcode.com/problems/interval-list-intersections/

public class Intersections {
	
	public static void main(String[] args) {
		Intersections prog = new Intersections();
		int[][] A = {{0,2},{5,10},{13,23},{24,25}};
		int[][] B = {{1,5},{8,12},{15,24},{25,26}};
		prog.intervalIntersection(A, B);
		
	}
    public int[][] intervalIntersection(int[][] A, int[][] B) {
    	
    	int n = A.length;
    	int m = B.length;
    	int i=-1;
    	int j=-1;
    	List<int[]> list = new ArrayList<>();
    	
    	while (i < n || j < m) {
    		
    		int[] intervalA = takeNext(A, i);
    		int[] intervalB = takeNext(B, j);
    		
    		if (intervalA == null && intervalB == null) break;
    		
    		if (intervalA == null) {
    			j++;
    		} else if (intervalB == null) {
    			i++;
    		}
    		else if (intervalA[0] < intervalB[0]) {
    			i++;
    		} else {
    			j++;
    		}
    		
    		if (i >= 0 && j >= 0) {
    			int[] interval = intersect(A[i], B[j]);
    			if (interval != null) {
    				list.add(interval);
    			}
    		}
    	}
    	
    	int[][] res = new int[list.size()][2];
    	for (int k = 0; k < list.size(); k++) {
    		res[k] = list.get(k);
    	}
    	return res;
    }
    
    private int[] takeNext(int[][] intervals, int i) {
    	return (i+1 < intervals.length) ? intervals[i+1] : null;
    }
    
    private int[] intersect(int[] intervalA, int[] intervalB) {
    	int[] interval = new int[2];
    	interval[0] = Math.max(intervalA[0], intervalB[0]);
    	interval[1] = Math.min(intervalA[1], intervalB[1]);
    	if (interval[0] <= interval[1]) {
    		return interval;
    	}
    	return null;
    }
}
