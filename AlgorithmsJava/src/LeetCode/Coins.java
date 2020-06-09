package LeetCode;

import java.util.*;
import java.util.stream.IntStream;

public class Coins {

	public static void main(String[] args) {
		Coins sol = new Coins();
		int[] coins = {1,2,5};
		sol.change(5, coins);
	}
	
	int[][] data = new int[5001][501];
    public int change(int amount, int[] coins) {
    	
    	int[] sorted = IntStream.of(coins)
    	        .boxed()
    	        .sorted(Comparator.reverseOrder())
    	        .mapToInt(i -> i)
    	        .toArray();
    	
    	for (int i = 0; i <= 5000; i++) {
    		for (int j = 0; j <= coins.length; j++) {
    			data[i][j] = -1;
    		}
    	}
    	
    	int res = process(amount, sorted, 0);
        return res;
    }
    
    private int process(int amount, int[] coins, int pos) {
    	if (amount == 0) return 1;
    	if (pos >= coins.length) return 0;

    	if (data[amount][pos] != -1) {
    		return data[amount][pos];
    	}
    	
    	int sum = 0;
		int val = coins[pos];
		int k = 0;
		while (k * val <= amount) {
			int sumK = process(amount - k*val, coins, pos+1);
			sum += sumK;
			k++;
		}
		data[amount][pos] = sum;
    	return sum;
    }
    
    

}
