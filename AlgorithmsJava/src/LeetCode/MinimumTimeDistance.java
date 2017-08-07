//https://leetcode.com/problems/minimum-time-difference/description/
//100%

package LeetCode;

import java.util.*;

public class MinimumTimeDistance {  
	
	private boolean[] times;
	
	public int Converse(String str) {
		if (str.charAt(0) == '0') {
			return Integer.valueOf(str.charAt(1) + "");
		}
		else {
			int a = Integer.valueOf(str.charAt(0) + "");
			int b = Integer.valueOf(str.charAt(1) + "");
			return 10*a+b;
		}
	}
	
	public int ConverseTime(String str) {
		String hour = str.substring(0, 2);
		String mins = str.substring(3,5);
		int h = Converse(hour);
		int m = Converse(mins);
		return 60*h + m;
	}
	
    public int findMinDifference(List<String> timePoints) {
    	int n = timePoints.size();
    	if (n >= 1440) return 0;
    	
    	times = new boolean[1440*2+1];
    	for (int i = 0; i < n; i++) {
    		String str = timePoints.get(i);
    		int time = ConverseTime(str);
    		
    		if (times[time]) {
    			return 0;
    		}
    		
    		times[time] = true;
    		if (time < 720) {
    			times[1440+time] = true;
    		}
    	}
    	
    	int prev = -1;
    	int curr = -1;
    	int res = 1440;
    	for (int i = 0; i < 1440*2; i++) {
    		curr = i;
    		
    		if (times[i]) {
    			if (prev != -1) {
    				res = Math.min(res, Math.abs(curr - prev));
    			}
				prev = curr;
    		}
    	}
        return res;
    }
	
}
