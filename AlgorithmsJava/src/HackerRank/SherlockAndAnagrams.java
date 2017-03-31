package HackerRank;

import java.util.*;

public class SherlockAndAnagrams {
	
	private Map<Character, Integer> getAnagram(String str)
	{	
		Map<Character, Integer> chars = new HashMap<Character, Integer>();
		for (Character c : str.toCharArray())
		{
			if (chars.containsKey(c)) {
				chars.put(c, chars.get(c)+1);
			}
			else {
				chars.put(c, 1);
			}
		}
		return chars;
	}
	
	private boolean AreEqual(Map<Character, Integer> map1, Map<Character, Integer> map2)
	{
		if (map1.keySet().size() != map2.keySet().size()) return false;
		for (Map.Entry<Character, Integer> entry : map1.entrySet())
		{
			Character key = entry.getKey();
			Integer value = entry.getValue();
			if (!map2.containsKey(key)) return false;
			if (map2.get(key) != value) return false;
		}
		return true;
	}
	
	private int calc(String str)
	{
		int cnt = 0;
		int n = str.length();
		for (int len = 1; len < n; len++)
		{
			for (int i = 0; i <= n-len; i++)
			{
				for (int j = i+1; j <= n-len; j++)
				{
					String str1 = str.substring(i, i + len);
					String str2 = str.substring(j, j + len);
					Map<Character, Integer>  anagram1 = getAnagram(str1);
					Map<Character, Integer>  anagram2 = getAnagram(str2);
					if (AreEqual(anagram1, anagram2))
					{
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
    public static void main(String[] args) {
    	SherlockAndAnagrams sol = new SherlockAndAnagrams();
    	int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
        	String str = in.next();
        	System.out.println(sol.calc(str));
        }    	
    }
}
