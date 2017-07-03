package LeetCode;

public class Problem553_OptimalDivision {
		
	class MinMax {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		int minPos = -1;
		int maxPos = -1;
	}
	
	MinMax tab[][];
	int[] _nums;
	
    public String optimalDivision(int[] nums) {    	
    	int n = nums.length;
    	Init(nums);
    	Max(0,n-1);
    	String result = parse(0,n-1);
    	return result;
    }
    
    public String parse(int p1, int p2) {
    	String result = "";
    	if (p1 == p2) {
    		int val = _nums[p1];
    		//int maxPos = tab[p1][p2].maxPos;
    		return String.valueOf(val);
    	} else if (p1 == p2 -1){
    		int val = _nums[p1];
    		int val2 = _nums[p2];
    		String res = String.valueOf(val) + "/" + String.valueOf(val2);
    		return res;
    	}
    	else {
    		
    	}
    	return null;
    }
    
    private void Init(int [] nums) {
    	int n = nums.length;
    	_nums = new int[n];
    	for (int i = 0; i < n; i++) _nums[i] = nums[i];
    	tab = new MinMax[n][n];
    	
    	for (int i = 0; i < n; i++) {
    		tab[i] = new MinMax[n];
    		for (int j = 0; j < n; j++) {
    			tab[i][j] = new MinMax();
    		}
    	}
    	    	
    }
    
    public double Min(int p1, int p2) {
    	
    	if (tab[p1][p2].min != Double.MAX_VALUE) {
    		return tab[p1][p2].min;
    	}    	
    	else if (p1 == p2) {
    		tab[p1][p2].min = _nums[p1];
    	}
    	else if (p1 == p2-1) {
    		tab[p1][p2].min = (double)((double)_nums[p1] / (double)_nums[p2]);
    	} else {
    		for (int i = p1; i <= p2-1; i++) {
    			double x = Min(p1, i);
    			double y = Max(i+1, p2);
    			double xy = x / y;
    			if (xy < tab[p1][p2].min) {
    				tab[p1][p2].min = Math.min(tab[p1][p2].min, xy);
    				tab[p1][p2].minPos = i;
    			}
    			
    		}
    	}
    	return tab[p1][p2].min;
    }
    
    public double Max(int p1, int p2) {
    	
    	if (tab[p1][p2].max != Double.MIN_VALUE) {
    		return tab[p1][p2].max;
    	}    	
    	else if (p1 == p2) {
    		tab[p1][p2].max = _nums[p1];
    	}
    	else if (p1 == p2-1) {
    		tab[p1][p2].max = (double)((double)_nums[p1] / (double)_nums[p2]);
    	} else {
    		for (int i = p1; i <= p2-1; i++) {
    			double x = Max(p1, i);
    			double y = Min(i+1, p2);
    			double xy = x / y;
    			if (xy > tab[p1][p2].max) {
    				tab[p1][p2].max = Math.max(tab[p1][p2].max, xy);
    				tab[p1][p2].maxPos = i;
    			}
    		}
    	}
    	return tab[p1][p2].max;
    }
}
