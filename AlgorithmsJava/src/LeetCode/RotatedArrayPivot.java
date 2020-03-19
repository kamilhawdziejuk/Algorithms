/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
You are given a target value to search. If found in the array return true, otherwise return false.
 * 
 */
package LeetCode;

import java.util.Arrays;

public class RotatedArrayPivot {
	
	public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    
    public boolean search(int[] nums, int target, int start, int end) {
		//return false if start pointer bigger than end pointer or this part of array is sorted and target isn't there
        if(start > end || (nums[start] < nums[end] && (target < nums[start] || target > nums[end]))) {
            return false;
        }
		
        int middlePoint = (start + end) / 2;
        //return true if target is found
		if (nums[middlePoint] == target) {
            return true;
        }
		//devide this part of array on two parts and check each of them
        return search(nums, target, start, middlePoint - 1) || search(nums, target, middlePoint + 1, end);
    }
}
