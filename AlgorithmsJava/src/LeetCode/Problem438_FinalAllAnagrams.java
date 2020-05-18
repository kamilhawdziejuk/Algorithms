package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Problem438_FinalAllAnagrams {
	
	
	public static void main(String[] args) {
		Problem438_FinalAllAnagrams sol = new Problem438_FinalAllAnagrams();
		sol.checkInclusion("ab", "eidbaooo");
	}
		
	
	class Anagram implements Comparable<Anagram> {
		public Map<Character, Integer> map = new HashMap<>();
		
		public Anagram(String s) {
	        for (int i = 0 ; i < s.length() ;i++) {
	        	this.Add(s.charAt(i));
	        }									
		}
		
		public void Update(char toRemove, char toAdd) {
			map.put(toRemove, map.get(toRemove)-1);
			if (map.get(toRemove) == 0) map.remove(toRemove);
			if (!map.containsKey(toAdd)) {
				map.put(toAdd, 0);
			}
			map.put(toAdd, map.get(toAdd)+1);
		}
		
		public void Add(char toAdd) {
			if (!map.containsKey(toAdd)) map.put(toAdd, 0);
			map.put(toAdd, map.get(toAdd)+1);			
		}

		@Override
		public int compareTo(Anagram o) {
			// TODO Auto-generated method stub
			for (Character c : o.map.keySet()) {
				if (!o.map.containsKey(c) || !this.map.containsKey(c)) return -1;
				Integer val = o.map.get(c);
				Integer val2 = this.map.get(c);
				if ((int)val != (int)val2) return -1;									
			}
			return 0;
		}
	}
	
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        if (n < m) return res;
        Anagram anagramP = new Anagram(p);
        Anagram anagramS = new Anagram(s.substring(0, m));
        
        if (anagramP.compareTo(anagramS) == 0) {
        	res.add(0);
        }
        
        for (int i = m ; i < n ;i++) {
        	char toAdd = s.charAt(i);
        	char toRemove = s.charAt(i-m);
        	anagramS.Update(toRemove, toAdd);
        	if (anagramP.compareTo(anagramS) == 0) {
        		res.add(i-m+1);
        	}
        }
        
        return res;
    }
    
    //567. Permutation in String
    public boolean checkInclusion(String s1, String s2) {
        List<Integer> list = findAnagrams(s2, s1);
        if (list.size() > 0) return true;
        return false;
    }
	
}
