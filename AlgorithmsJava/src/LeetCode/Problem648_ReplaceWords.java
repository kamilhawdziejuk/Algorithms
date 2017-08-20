//https://leetcode.com/problems/replace-words/
//100%
package LeetCode;

import java.util.*;

public class Problem648_ReplaceWords {

    class TrieNode {
    	
    	public Map<Character, TrieNode> Map = new HashMap<>();    	
        public char Rep;
        int Cnt = 0;
        public boolean isEnd = false;

        public TrieNode() {
        	
        }	
        
        public TrieNode(Character rep) {
            Rep = rep;
            Cnt++;
        }	
    }
	
	public class Trie {		
	
		private TrieNode root;
	 
	    public Trie() {
	        root = new TrieNode();
	    }       
	
	    public String GetPrefix(String word)
	    {
	        TrieNode p = root;
	        String result = new String();
	        
	        for (int i=0; i<word.length(); i++) {
	            
	            if (p.isEnd) {
	            	return result;
	            }
	            
	            char c = word.charAt(i);
	            if (p.Map.containsKey(c)) {
	            	result += c;
	            	p = p.Map.get(c);
	            }
	            else {
	            	return null;
	            }
	        }
	        return null;
	    }
	    
	    public void insert(String word) {
	    	TrieNode p = root;
	      
	        for (int i=0; i < word.length(); i++) {
	            
	        	char c = word.charAt(i);
	            
	            if (p.Map.containsKey(c))
	            {
	            	TrieNode tmp = p.Map.get(c);
	            	p = tmp;
	            } else {	           
	            	TrieNode node = new TrieNode(c);
	            	node.Cnt = p.Cnt+1;
	            	p.Map.put(c,  node);
	            	p = node;
	            }
	        }
	        p.isEnd=true;
	    }		
		
	}

    public String replaceWords(List<String> dict, String sentence) {
    	
    	Trie trie = new Trie();
    	for (int i = 0; i < dict.size(); i++) {
    		String str = dict.get(i);
    		trie.insert(str);
    	}
    	
		String[] splitStr = sentence.trim().split("\\s+");
		String result = null;
		
		for (int i = 0; i < splitStr.length; i++) {
			String str = splitStr[i];
			String res = trie.GetPrefix(str);
			if (res != null) {
				if (result == null) {
					result = new String();
					result = res;
				}
				else {
					result = result + " " + res; 
				}				
			}
			else {
				if (result == null) {
					result = new String();
					result = str;
				}
				else {
					result = result + " " + str; 
				}
			}
		}
		
    	return result;
    }
}
