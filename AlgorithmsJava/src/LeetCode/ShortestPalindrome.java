package LeetCode;

/*
 * https://leetcode.com/problems/shortest-palindrome/
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation. 
 */
public class ShortestPalindrome {
	
	public class Best
	{
		int pos;
		boolean take;
		int dl;
	}
	
	Best best = new Best();
	
	//pos - max polowa!
	public int test(String s, int pos, boolean take)
	{
		int n = s.length();
		int res = 0;
		if (take)
		{
			int length = pos;
			boolean ok = true;
			for (int i = 1; i<=length; i++)
			{
				int p1 = pos-i;
				int p2 = pos+i;
				
				if (p2 >= n) return -1;
				
				char c1 = s.charAt(p1);
				char c2 = s.charAt(p2);
				if (c1 != c2)
				{
					return -1;
				}
			}
			return 1 + 2 * length;
		}
		else //before
		{
			int length = pos;
			boolean ok = true;
			for (int i = 1; i<=length; i++)
			{
				int p1 = pos-i;
				int p2 = pos+i-1;
				
				char c1 = s.charAt(p1);
				char c2 = s.charAt(p2);
				if (c1 != c2)
				{
					return -1;
				}			
			}
			return 2 * length;
		}
	}
	
    public String shortestPalindrome(String s) {
    	int n = s.length();
    	
    	if (n == 0) return "";
    	if (n == 1) return s;
    	
    	best.dl = 0;
    	for (int i = 0; i <= n/2;i++)
    	{
    		if (i > 0)
    		{
    			int dl = test(s, i, true);
    			if (dl > 0)
    			{
    				if (best.dl < dl) 
    				{
    					best.dl = dl;
    					best.pos = i;
    					best.take = true;
    				}
    			}
    			dl = test(s, i, false);
    			if (dl > 0)
    			{
    				if (best.dl < dl) 
    				{
    					best.dl = dl;
    					best.pos = i;
    					best.take = false;
    				}
    			}
    		}
    	}
    	
    	if (best.dl == 0)
    	{
    		String str = s.substring(1, s.length());
    		str = new StringBuilder(str).reverse().toString();
    		String result = str + s;
    		return result;
    	}
    	else
    	{
	    	int pos = 2*best.pos;
	    	if (best.take)
	    	{
	    		pos = 2*best.pos+1;
	    	}
			String str = s.substring(pos, s.length());
			str = new StringBuilder(str).reverse().toString();
			String result = str + s;
			return result;
    	}
    }
}
