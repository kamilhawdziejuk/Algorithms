package HackerRank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Coins {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int coins[] = new int[m];
	        int d[] = new int[n+1];
	        for(int coins_i=0; coins_i < m; coins_i++){
	            coins[coins_i] = in.nextInt();
	        }
	        
	        d[0] = 0;
	        for (int i = 0; i <=n; i++) {
	            for (int j = 0; j < m; j++) {
	                 if (i - coins[j] >= 0) {
	                	 int prev = i-coins[j];
	                	 if (prev == 0)
	                	 {
	                		 d[i] += 1;
	                	 }
	                	 else
	                	 {
	                		 int dPrev = d[prev];
	                		 d[i] += dPrev;
	                	 }
	                 }
	            }                            
	        }
	        System.out.println(d[n]);
	    }
}
