package LeetCode;
import java.util.*;

//https://leetcode.com/problems/uncrossed-lines/
public class UncrossedLines {

	public static void main(String[] args) {
		
		UncrossedLines prog = new UncrossedLines();
		int[] A = {2,1};
		int[] B = {1,2,1,2};
		
		prog.maxUncrossedLines(A, B);
	}
	
	public int maxUncrossedLines_optimal(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                dp[i][j] = -1;
            }
        }
        
        return lcs(A, B, 0, 0, dp);
    }
    
    
    int lcs(int[] A, int[] B, int i, int j, int[][] dp){
        if(i == A.length || j == B.length){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(A[i] == B[j]){
            return dp[i][j] = 1 + lcs(A, B, i + 1, j + 1, dp);
        }
        else{
            return dp[i][j] = Math.max(lcs(A, B, i + 1, j, dp), lcs(A, B, i, j + 1, dp));
        }
    }
	
	int[] t1;
	int[] t2;
	int n;
	int m;
	
    public int maxUncrossedLines(int[] A, int[] B) {
    	prep(A, B);
    	
    	if (n == 0 || m == 0) return 0;
    	
    	int[][] d = new int[n][m+1];
    	fill(d);
    	
    	for (int k = 0; k < n; k++) {
    		for (int k2 = 0; k2 < m; k2++) {
    			if (t2[k2] == t1[k]) {
    				d[k][1] = k2;
    				break;
    			}
    		}
    	}
    	
    	int max = 1;
    	for (int k = 0; k < n; k++) {    		
    		int current = t1[k];
    		for (int j = 2; j <= (k+1); j++) {
    			if (j > m) break; 
    			for (int i = 0; i < k; i++) {
    				int val = d[i][j];
    				int index = d[i][j-1];
    				if (index >= 0) {
    					int foundIndex = find(t1[k], index+1); 					
    					if (foundIndex >= 0) {
    						if (val == -1) {
    							d[k][j] = foundIndex;
    						}
    						else if (foundIndex < val) {
    							d[k][j] = foundIndex;
    						}
    						max = Math.max(j,  max);
    					}
    				}
    			} 			
    		}
    	}
    	
        return max;
    }
    
    private int find(int val, int startPos) {
		for (int p = startPos; p < m; p++) {
			if (t2[p] == val) {
				return p;
			}
		}
		return -1;
    }
    
    private void fill(int[][] tab) {
    	for (int[] row: tab) {
    		Arrays.fill(row, -1);
    	}
    	    
    }
	
	private void prep(int[] A, int[] B) {
		Set<Integer> set = new HashSet<>();
    	for (int i = 0; i < A.length; i++) {
    		set.add(A[i]);
    	}
    	
    	Set<Integer> common = new HashSet<>();
    	
    	for (int i = 0; i < B.length; i++) {
    		if (set.contains(B[i])) {
    			common.add(B[i]);
    		}
    	}
    	
    	List<Integer> lA = new ArrayList<>();
    	List<Integer> lB = new ArrayList<>();
    	
		for (int i = 0; i < A.length; i++) {
			if (common.contains(A[i])) {
				lA.add(A[i]);
			}
		}
		
		for (int i = 0; i < B.length; i++) {
			if (common.contains(B[i])) {
				lB.add(B[i]);
			}
		}
		
    	if (A.length < B.length) {
    		t1 = lA.stream().mapToInt(i->i).toArray();
    		t2 = lB.stream().mapToInt(i->i).toArray();
    	} else {
    		t2 = lA.stream().mapToInt(i->i).toArray();
    		t1 = lB.stream().mapToInt(i->i).toArray();
    	}
    	
    	n = t1.length;
    	m = t2.length;
	}
	

}
