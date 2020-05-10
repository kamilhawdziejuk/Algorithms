package LeetCode;
import java.util.*;

import javax.script.ScriptException;
//SOLVED
//https://leetcode.com/problems/task-scheduler/submissions/

public class TaskScheduler {
	
	public static void main(String[] args) throws ScriptException
	{
		TaskScheduler prog = new TaskScheduler();
		char[] tasks = 
			{'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'};

		prog.leastInterval(tasks, 2);
	}
	
	public int leastInterval(char[] tasks, int n) {
    	Map<Character, Integer> size = new HashMap<>();
    	Map<Character, Integer> positions = new HashMap<>();
    	
    	int m = tasks.length;
    	int pos = -1;
    	for (int i = 0; i < m; i++) {
    		char cc = tasks[i];
    		if (!size.containsKey(cc)) {
    			size.put(cc,  0);
    		}
    		size.put(cc, size.get(cc)+1);
    		positions.put(cc,  0);
    	}
  
    	
    	for (int i = 0; i < m; i++) {

    		pos++;
      		int min = Integer.MAX_VALUE;
      		char cc = 'A';
      		for (Character entry : positions.keySet())
    		{
      			if (positions.get(entry) < min && size.get(entry) > 0) {
      				min = positions.get(entry);
      				cc = entry;
      			}
    		}
      		
      		Set<Character> set = new HashSet<>();
      		for (Character entry : positions.keySet())
    		{
    			if (size.get(entry) > 0 && positions.get(entry) <= pos) {
    				set.add(entry);
    			}
    		}
      		
      		min = 0;
      		for (Character sign : set) {
      			int leng = pos + n * size.get(sign);
      			if (leng >= min) {
      				min = leng;
      				cc = sign;
      			}
      		}
 
      		min = positions.get(cc);
    		if (min > pos) {
    			pos = min;
    		}
    		
    		size.put(cc,  size.get(cc)-1);
    		positions.put(cc,  pos+n+1);
    		
    	}
    	
    	return pos+1;
    }
}
