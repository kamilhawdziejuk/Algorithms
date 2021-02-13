//581. Shortest Unsorted Continuous Subarray
//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

package LeetCode;
import java.util.Stack;

class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> pos = new Stack<>();
        int n = nums.length;
        int max = nums[0];
        int l = n-1;
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (stack.size() > 0) {
                if (max <= nums[i]) {
                    stack.push(nums[i]);
                    pos.push(i);
                    max = nums[i];
                } else {
                    r = i;
                    while (stack.size() > 0 && stack.peek() > nums[i]) {
                        stack.pop();
                        l = Math.min(l, pos.peek());
                        pos.pop();
                    }
                    stack.push(nums[i]);
                    pos.push(i);
                }
            } else {
                stack.push(nums[i]);
                pos.push(i);
                max = nums[i];
            }
        }
        return l < n-1 ? r-l+1 : 0;
    }
}