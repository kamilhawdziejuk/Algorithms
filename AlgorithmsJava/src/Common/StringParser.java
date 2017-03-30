package Common;

import java.util.HashSet;
import java.util.Set;

import HackerRank.SubstringQueries;

public class StringParser {
	Set<Character> vowels = new HashSet<Character>();
	
	private void Init()
	{
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		vowels.add('Y');
	}
	
    public static void main(String[] args) {
    	run("ThIs is p");
    }
	
	public static String run(String p) {
		StringParser sol = new StringParser();
		sol.Init();
		int nr_vowels = sol.CountVowels1(p);
		int nr_consontants = sol.CountConsonants1(p);
		String reverse2 = sol.Reverse2("ThIs is p");
		String dash3 = sol.Dash3(p);
		String pv4 = sol.pv4(p);
		
		String result = nr_vowels + " " + nr_consontants + "::" + reverse2 + "::" + dash3 + "::" + pv4;
		return result;
	}
	
	private String pv4(String p)
	{
		String result = new String();
		char[] chars = p.toCharArray();
		for (Character c : chars)
		{
			if (Character.isLetter(c))
			{
				if (IsVowel(c))
				{
					result += "pv";
				}
				result += c;
			}
			else
			{
				result += c;
			}
		}
		return result;
	}
	
	private String Dash3(String p)
	{
		String[] arr = p.split(" ");
		String result = new String();
		
		for (int i = 0; i < arr.length; i++)
		{
			result += arr[i];
			if (i < arr.length-1)
			{
				result += "-";
			}
		}
		
		return result;
	}
	
	private String Reverse2(String p)
	{
		String[] arr = p.split(" ");
		
		for (int i = 0; i < arr.length; i++)
		{
			String str = "";
			
			for (int j = 0; j < arr[i].length(); j++)
			{
				char c = arr[i].charAt(j);
				if (Character.isLetter(c))
				{
					if (Character.isUpperCase(c))
					{
						str += Character.toLowerCase(c);
					}
					else
					{
						str += Character.toUpperCase(c);
					}
				}
				else
				{
					str += c;
				}
			}
			
			arr[i] = str;
		}
		
		String result = new String();
		for (int i = arr.length-1; i>=0; i--)
		{
			result += arr[i];
			if (i > 0)
			{
				result += " ";
			}
		}
		return result;
	}
	
	private boolean IsVowel(Character c)
	{
		if (c.isLetter(c))
		{
			char upperC = Character.toUpperCase(c);
			return vowels.contains(upperC);
		}
		return false;
	}
	
	private int CountVowels1(String p)
	{
		int cnt = 0;
	    char[] chars = p.toCharArray();

	    for (char c : chars) {
	        if(Character.isLetter(c)) 
	        {
	        	char upperC = Character.toUpperCase(c);
	        	if (vowels.contains(upperC))
	        	{
	        		cnt++;	
	        	}
	        }
	    }
	    return cnt;
	}
	
	private int CountConsonants1(String p)
	{
		int cnt = 0;
	    char[] chars = p.toCharArray();

	    for (char c : chars) {
	        if(Character.isLetter(c)) 
	        {
	        	char upperC = Character.toUpperCase(c);
	        	if (!vowels.contains(upperC))
	        	{
	        		cnt++;	
	        	}
	        }
	    }
	    return cnt;
	}
}
