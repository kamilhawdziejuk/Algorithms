package LeetCode;

//https://leetcode.com/problems/combination-sum-iv/
/*
 * Given an integer array with all positive numbers and no duplicates, 
 * find the number of possible combinations that add up to a positive integer target.
 */

import java.util.*;

public class CombinationSum {  
	
	private int[] dp;
	
    public int combinationSum4(int[] nums, int target) {
    	if (nums == null) return 0;
    	int n = nums.length;
    	if (n == 0) return 0;
    	
    	 dp = new int[target + 1];
    	 Arrays.fill(dp, -1);
    	 dp[0] = 1;
    	
    	Arrays.sort(nums);
    	int result = combinationSum(nums, target);    	    	
        return result;
    }
    
    public int combinationSum(int[] nums, int target) 
    {
    	 if (dp[target] != -1) {
    	        return dp[target];
    	 }
    	
    	int cnt = 0;
    	int n = nums.length;
    	for (int i = 0; i < n; i++)
    	{
    		int num = nums[i];
    		if (num < target)
    		{
    			int res = combinationSum(nums, target - num);
    			cnt += res;
    		}
    		else if (num == target)
    		{
    			cnt++;
    		}
    		else
    		{
    			break;
    		}
    		
    	}
    	dp[target] = cnt;
    	return cnt;
    }
}
