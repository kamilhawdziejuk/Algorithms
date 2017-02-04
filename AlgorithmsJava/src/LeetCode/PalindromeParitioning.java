package LeetCode;
import java.util.*;

//https://leetcode.com/problems/palindrome-partitioning/
/*
 *  Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s. 
 */

public class PalindromeParitioning {

	private List<List<Integer>> graph = new ArrayList<List<Integer>>();
	private List<List<String>> result = new ArrayList<List<String>>();		
	private String str;
	private int n;
	
    public List<List<String>> partition(String s) {
    	
    	if (s == null) return result;
    	n = s.length();
    	if (n == 0) return result;
    	
    	if (n == 1)
    	{
    		List<String> res = new ArrayList<String>();
    		res.add(s.charAt(0) + "");
    		result.add(res);
    		return result;
    	}
    	str = s;
    	for (int i = 0; i < n; i++) {
    		graph.add(i, new ArrayList<Integer>());
    		graph.get(i).add(i);
    	}    	    
    	
    	for (int i = 0; i < n - 1; i++)
    	{
    		for (int j = i+1; j < n; j++)
    		{
    			if (IsPalindrom(i, j))
    			{
    				graph.get(i).add(j);
    			}
    		}
    	}
    	
    	List<String> empty = new ArrayList<String>();
    	calc(empty, 0);
    	    	
        return result;
    }
    
    private void calc(List<String> list, int pos)
    {
    	if (pos == n)
    	{
    		result.add(list);
    		return;
    	}
    	List<Integer> nexts = graph.get(pos);
    	for (int i = 0; i < nexts.size(); i++)
    	{
    		List<String> list2 = new ArrayList<String>(list.size());
    		for (int k = 0; k < list.size(); k++) list2.add(list.get(k));    		
        	//Collections.copy(list2, list);    		
        	
        	int pos2 = nexts.get(i);
        	String part = str.substring(pos,  pos2+1);
        	list2.add(part);
        	
        	calc(list2, pos2+1);
    	}
    }
    
    private boolean IsPalindrom(int a, int b)
    {
    	while (a < b)
    	{
    		if (str.charAt(a) != str.charAt(b))
    		{
    			return false;
    		}
    		a++;
    		b--;
    	}
    	return true;
    }
}
