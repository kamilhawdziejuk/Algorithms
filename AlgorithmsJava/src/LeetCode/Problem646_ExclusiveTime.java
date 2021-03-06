//https://leetcode.com/problems/exclusive-time-of-functions/description/
//ongoing..
//100%

package LeetCode;
import java.util.*;

public class Problem646_ExclusiveTime {

    public int[] exclusiveTime(int n, List<String> logs) {
    	
    	Map<Integer, Integer> counts = new HashMap<>();
    	for (int i = 0; i < n; i++) {
    		counts.put(i, 0);
    	}
    	
    	Stack<Integer> stack = new Stack<>();
    	int lastTime = -1;
    	for (int i = 0; i < logs.size(); i++) {
    		String log = logs.get(i);
    		String[] data = log.split("\\:");
    		int id = Integer.valueOf(data[0]);
    		boolean isStart = data[1].startsWith("s");
    		int moment = Integer.valueOf(data[2]);
    		if (!isStart) {
    			moment+=1;
    		}
    		
    		if (moment >= lastTime) {
    			if (isStart) {
    				if (stack.size() > 0) {
    					int idLast = stack.peek();
    					int diff = moment - lastTime;
    					counts.put(idLast, counts.get(idLast) + diff);
    				}
    				stack.push(id);    		
    			}
    			else { //we sum
    				int idLast = stack.pop();
    				int diff = moment - lastTime;
    				counts.put(idLast, counts.get(idLast) + diff);
    			}
				lastTime = moment;    			
    		}
    		    		    	    		
    	}
    	int[] result = new int[n];
    	for (int i = 0; i < n; i++) {
    		result[i] = counts.get(i);
    	}
        return result;
    }
}
