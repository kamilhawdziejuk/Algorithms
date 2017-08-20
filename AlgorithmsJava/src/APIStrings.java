import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class APIStrings {
	
	private String str = new String();
	
	public static void main(String [ ] args)
	{
		APIStrings sol = new APIStrings();
		List<String> list = new ArrayList<>();
		list.add("jeden");
		list.add("dwa");
		Object o;
		
		String test = "abc";
		String part = test.substring(0, 0); //returns empty
		String part2 = test.substring(0, 1); //returns "a"
		
		String res = sol.encode(list);
		List<String> list2 = sol.decode(res);
	}
	
	public void methodsOnString()
	{
		char c = str.charAt(0);
		int i = str.indexOf('a'); //first occurance of 'a'
		
		int fromIndex = 2;
		int i2 = str.indexOf('a', fromIndex);
		
		String str10 = String.valueOf(10);
		int k = Integer.valueOf("10");

		String strFirst2Chars = str.substring(0,2);
		
		char[] chars = str10.toCharArray();
		Arrays.sort(chars);
		String sorted10 = String.valueOf(chars);
	}
	
	public String[] SplitBySpaces(String str) {
		String[] splitStr = str.trim().split("\\s+");
		return splitStr;
	}
    
    String calcUnique(String w)
    {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < w.length(); ++i)
        {
            set.add(w.charAt(i));
        }
        String result = new String();
        for (Character c : set)
        {
            result += c;
        }
        
        return result;
    }
	
	boolean haveSthCommon(String a, String b)
    {
		Set<Character> set = new HashSet<Character>();
		for (Character c : a.toCharArray())
		{
			set.add(c);
		}
		for (Character c: b.toCharArray())
		{
			if (set.contains(c))
			{
				return true;
			}
		}
		return false;
    }
	
   public String encode(List<String> strs) {
        String res = new String();
        int n = strs.size();
        res = n + "_";
        for (String str : strs)
        {
            res = res + str.length() + "_";
        }
        for (String str : strs)
        {
            res = res + str;
        }
        return res;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> results = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        int k = s.indexOf('_');
        int amount = Integer.valueOf(s.substring(0,k));
        for (int i = 0; i < amount; ++i)
        {
            int p = s.indexOf('_', k+1);
            String sNum = s.substring(k+1,p);
            int num = Integer.valueOf(sNum);
            nums.add(num);
            k = p;
        }
        k++;
        for (int i = 0; i < amount; ++i)
        {
        	int k2 = k+nums.get(i);
        	String res = s.substring(k, k2);
        	results.add(res);
        	k = k2;
        }
        return results;
    }
    
    public static Character firstNonRepeatedCharacter(String str)
    {
        HashMap<Character,Integer>  characterhashtable= new HashMap<Character ,Integer>();
        int i,length ;
        Character c ;
        length= str.length();  // Scan string and build hash table
        for (i=0;i < length;i++)
        {
            c=str.charAt(i);
            if(characterhashtable.containsKey(c))
            {
                // increment count corresponding to c
                characterhashtable.put(  c ,  characterhashtable.get(c) +1 );
            }
            else
            {
                characterhashtable.put( c , 1 ) ;
            }
        }
        // Search characterhashtable in in order of string str
        for (i =0 ; i < length ; i++ )
        {
            c= str.charAt(i);
            if( characterhashtable.get(c)  == 1 )
            return c;
        }
        return null ;
    }
}

