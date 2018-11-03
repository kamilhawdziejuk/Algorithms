//https://leetcode.com/problems/word-squares/

package LeetCode;

import java.util.*;

public class WordSquares {
	
	class Square {
		public int N;
		private List<String> list = new ArrayList<>();		
		public int level = 0;
		
		public Square(int n) {
			N = n;
			for (int i = 0; i < n; i++) {
				list.add("");
			}
		}

		public Square(Square data) {
			N = data.N;
			for (int i = 0; i < N; i++) {
				list.add("");
			}
			
			level = data.level;
		
			List<String> listTmp = data.getRepresentation();
			for (int i = 0; i < listTmp.size(); i++) {
				list.set(i, listTmp.get(i));
			}
		}
		
		public boolean isValid() {
			return level == N;
		}
				
		public List<String> getRepresentation() {
			return list;
		}
		
		public String getPrefix() {
			return list.get(level);
		}
				
		public boolean canAdd(String word) {
			String wordToFill = list.get(level);			
			if (word.startsWith(wordToFill)) {
				return true;
			}			
			return false;
		}
		
		public void add(String word) {
			list.set(level, word);
			
			for (int i = level+1; i < N; i++) {
				String stri = list.get(i);
				stri = stri + word.charAt(i);
				list.set(i, stri);
			}
			level++;
		}
	}

	List<List<String>> res = new ArrayList<List<String>>();
	Map<String, Set<String>> map;
	
    public List<List<String>> wordSquares(String[] words) {   	
    	
    	if (words == null || words.length == 0) {
    		return null;
    	} 		    	
    	
    	int wordSize = words[0].length();   	    	
    	Square current = new Square(wordSize);
    	List<String> wordList = new ArrayList<>(Arrays.asList(words));
    	
    	buildPrefixes(wordList);
    	
		build(current, 0, wordList);
    	
        return res;
    }
    
    private void buildPrefixes(List<String> words) {
    	map = new HashMap<>();
    	for (String word : words) {
    		
    		for (int i = 1; i <= word.length(); i++) {
    			
    			String key = word.substring(0, i);
    			
    			if (map.containsKey(key)) {
    				continue;
    			}
    			else {
    				
    				map.put(key, new HashSet<String>());
    				for (String word2 : words) {
    					if (word2.startsWith(key)) {
    						Set<String> set = map.get(key);
    						set.add(word2);
    						map.put(key, set);
    					}
    				}    				
    			}    			
    		}
    		
    	}
    	
    	Set<String> allWords = new HashSet<String>(words);
    	map.put("", allWords);
    }
    
    private void build(Square current, int level, List<String> words) {
    	    	
    	String pref = current.getPrefix();
    	Set<String> toConsider = map.get(pref);
    	
    	if (toConsider != null) {

        	for (String word : toConsider) {
        		
        		if (current.canAdd(word)) {
        			Square next = new Square(current);
        			next.add(word);
        			
        			if (next.isValid()) {
        				res.add(next.getRepresentation());
        			} else {
        				if (level < word.length()) {
        					
            				build(next, level+1, words);    					
        				}
        			}
        		}
        	}    		
    		
    	}
    }
}
