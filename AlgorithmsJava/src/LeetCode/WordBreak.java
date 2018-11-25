//https://leetcode.com/problems/word-break/

package LeetCode;
import java.util.*;

public class WordBreak {
	Queue<Integer> q = new PriorityQueue<>();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        
        q.offer(0);
        
        while (!q.isEmpty()) {
            int pos = q.poll();
            if (pos == n) {
                return true;
            }
            for (String word : wordDict) {                
                int next = pos+word.length();
                if (!q.contains(next)) {
                    if (s.startsWith(word, pos)) {                                              
                        q.offer(next);
                    }                    
                }                
            }                        
        }       
        return false;
    }
}
