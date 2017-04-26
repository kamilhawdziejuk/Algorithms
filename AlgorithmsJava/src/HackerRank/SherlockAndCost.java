//https://www.hackerrank.com/challenges/sherlock-and-cost
package HackerRank;

import java.util.Scanner;

public class SherlockAndCost {

	Scanner in;
	int T, N;
	int B[];
	int S[][];
	
	public int Calc() {
		
		for (int k = 1; k <= 100; k++) {
			S[1][k] = 0;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int k = 1; k <= 100; k++) {
				if (k <= B[i]) {
					S[i][k] = Math.max(S[i][k], Math.abs(k - 1) + S[i-1][1]);
                    S[i][k] = Math.max(S[i][k], Math.abs(k - B[i-1]) + S[i-1][B[i-1]]);
				}
				else {
					break;
				}
			}
		}
		int result = 0;
		for (int k = 1; k<= 100; k++) {
			result = Math.max(result, S[N][k]);
		}
		return result;
	}
	
	public void Solve() {    	
        
		in = new Scanner(System.in);
        
        T = in.nextInt();    
        for (int i = 0; i < T; i++) {
        	N = in.nextInt();
        	B = new int[N+1];
        	S = new int[N+1][101];
        	for (int j = 1; j <= N; j++) {
        		B[j] = in.nextInt();
        	}
        	int res =Calc();
        	System.out.println(res);        	
        }
	}
	
    public static void main(String[] args) {
    	
    	SherlockAndCost sol = new SherlockAndCost();
    	sol.Solve();
     }	    	    
}
