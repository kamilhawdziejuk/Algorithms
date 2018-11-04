//https://leetcode.com/problems/minimum-window-substring/
	
package LeetCode;
import java.util.*;

public class MinimumWindowSubstring {
	public class Window {
	       
        Map<Character, Integer> data = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();//t
        public int level = 0;
        
        public int begin = 0;
        public int end = 0;

        public int LengthFound = Integer.MAX_VALUE;
        public int BeginFound = -1;
        
        private void update(String s) {
            if (level == 0) {
                if (end-begin < LengthFound) {
                	LengthFound = end-begin;
                	BeginFound = begin;
                }
            }
        }
        
        public void init(String t) {
           for (Character c : t.toCharArray()) {
               map.put(c, map.getOrDefault(c, 0)+1);
            }        
            level =	map.keySet().size();
        }        
                     
        public void add(String s, int position) {
        	
        	Character c = s.charAt(position);
            if (map.containsKey(c)) {                       	
                data.put(c, data.getOrDefault(c, 0)+1);    
                if ((int)data.get(c) == (int)map.get(c))
                {
                    level--;                
                }
            }
            
            end = position+1;
            update(s);

        }
        
        public void remove(String s, int position) {
            Character c = s.charAt(position);
            
            if (map.containsKey(c)) {
           
                if ((int)data.get(c) == (int)map.get(c))
                {
                    level++;                
                }    
                data.put(c, data.get(c)-1);                               
            }
            
            begin = position+1;
            update(s);
        }
        
    }
    
    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
               
        Window wind = new Window();
        wind.init(t);
                        
        wind.begin = 0;
        wind.end = 0;
        wind.add(s,  0);        
        
        while (wind.end < s.length() || wind.level == 0) {            
                    	
            if (wind.level == 0) {
                wind.remove(s, wind.begin);
            }
            else {
                wind.add(s, wind.end);
            }
        }
        
        if (wind.BeginFound != -1) {
        	String res = s.substring(wind.BeginFound, wind.BeginFound + wind.LengthFound);
        	return res;
        }
        return "";
    }
}
