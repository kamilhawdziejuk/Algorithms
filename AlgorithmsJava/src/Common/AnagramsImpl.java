package Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnagramsImpl
{    
	public static void main(String [ ] args)
	{
		AnagramsImpl sol = new AnagramsImpl();
		String s1 = "bbbababaaabbbb";//"abdcghbaabcddij";
		String s2 = "ba";//"bcda";
		s1 = "ABACDABCABA";
		s2 = "BA";
		List<Integer> ints = sol.getAnagramIndices(s1, s2);
		int res = 0;
	}
	
    public void Init(Map<Character, Integer> map, String needle)
    {
        for (Character key : map.keySet()){
        	map.put(key, 0);
        }
    }
    
    private static Map<Character, Integer> Init(String needle)
    {
         Map<Character, Integer> map = new HashMap<Character, Integer>();
         for (int i = 0; i < needle.length(); i++)
         {
             char c = needle.charAt(i);
             if (map.containsKey(c))
             {
            	 
            	 map.put(c, map.get(c)+1);
             }
             else{
                 map.put(c, 1);
             }
         }
         return map;
    }
    
    public List<Integer> getAnagramIndices(String haystack, String needle)
    {
    	List<Integer> res = new ArrayList<Integer>();
    	Map<Character, Integer> map = Init(needle);
     
    	int cnt = needle.length();

    	int candidate = 0;

    	for (int i = 0; i < haystack.length(); i++)
    	{
    		if (cnt == needle.length()) {
    			candidate = i;
    		}
         
    		char c = haystack.charAt(i);
    		if (map.containsKey(c) && map.get(c)>0)
    		{
    			map.put(c, map.get(c)-1);
    			cnt--;
              
    			if (cnt == 0)
    			{
    				res.add(candidate);
    				map = Init(needle);
    				cnt = needle.length();
    				i = candidate;
    			}
    		}
    		else if (map.containsKey(c))
    		{
    			i--;
    			map = Init(needle);
    			cnt = needle.length();  
    		}
    		else
    		{
    			map = Init(needle);
    			cnt = needle.length();
    		}
    	}
    	return res;
    }
}