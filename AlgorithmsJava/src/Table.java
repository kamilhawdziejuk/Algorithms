
public class Table {
	
	 public int maxSubArray(int[] nums) {		
	        if(nums==null || nums.length==0) return 0;
	        if(nums.length==1) return nums[0];
	        
	        int dp[] = new int[nums.length]; 
	        int max = nums[0]; 
	        dp[0] = nums[0];
	        
	        for (int i = 1; i < nums.length; i++) {            
	            dp[i] = Math.max(dp[i-1] + nums[i] ,nums[i]);
	            max = Math.max(max, dp[i]);
	        }
	        return max;
	    }
	 
	 public static double[] extendArraySize(double [] array){
		    double [] temp = array.clone();
		    array = new double[array.length + 1];
		    System.arraycopy(temp, 0, array, 0, temp.length);
		    return array;
		}
}
