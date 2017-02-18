package Common;

import java.util.*;

/*
Implement an algorithm to convert the number to a natural language string.
*/

public class NumberToNaturalLanguage {

	Map<Integer, String> units = new HashMap<Integer, String>();
	Map<Integer, String> teens = new HashMap<Integer, String>();
	Map<Integer, String> tens = new HashMap<Integer, String>();
	Map<Integer, String> map3 = new HashMap<Integer, String>();

	private void Init()
	{
		units.put(0, "zero");
		units.put(1, "one");
		units.put(2, "two");
		units.put(3, "three");
		units.put(4, "four");
		units.put(5, "five");
		units.put(6, "six");
		units.put(7, "seven");
		units.put(8, "eight");
		units.put(9, "nine");
	    
		teens.put(11, "eleven");
		teens.put(12, "twelve");
		teens.put(13, "thirteen");
		teens.put(14, "fourteen");
		teens.put(15, "fifteen");
		teens.put(16, "sixteen");
		teens.put(17, "seventeen");
		teens.put(18, "eightteen");
		teens.put(19, "nineteen");
	    
	    tens.put(10, "ten");
	    tens.put(20, "twenty");
	    tens.put(30, "thirty");
	    tens.put(40, "fourty");
	    tens.put(50, "fifty");
	    tens.put(60, "sixty");
	    tens.put(70, "seventy");
	    tens.put(80, "eighty");
	    tens.put(90, "ninety");
	    
	    map3.put(1, "houndred");
	    map3.put(2, "thousand");
	    map3.put(3, "million");
	    map3.put(4, "billion");
	    map3.put(5, "trillion");
	    //etc.
	}

	public String GetNaturalLanguageVersion(long number)//12 (trillion) 789 (billion) 123 (million) 456 (thousand) 789 (hundred) 123
	{
		Init();
		String result = "";
		List<Integer> list = Split(number);
		for (int i = 0; i < list.size(); i++)
		{
			int number3 = list.get(i);
			if (i == 0)
			{
				result = GetNatural3(number3);
			}
			else 
			{
				String suffix = map3.get(i+1);
				result = GetNatural3(number3) + " " + suffix + " " + result;
			}
		}
		return result;
	}

	private String GetNatural3(int number)
	{
		String result = "";
    	//abc
    	int a = number / 100;
    	int bc = number - a*100;
    	int b = bc / 10;
    	int c = bc - b*10;
		
    	if (a > 0)
    	{
    		result = units.get(a) + " " + map3.get(1);
    	}
    	if (b > 0)
    	{
    		if (b == 1)
    		{
    			if (a != 0)
    			{
    				result = result + " " + teens.get(bc);
    			}
    			else
    			{
    				result = result + " " + tens.get(b*10);
    			}
    		}
    		else //(b > 1)
    		{
    			result = result + " " + tens.get(b*10);
    			if (c > 0)
        		{
        			result = result + " " + units.get(c);
        		}
    		}
    	}
    	else //if (b == 0)
    	{
    		if (c > 0)
    		{
    			result = result + " " + units.get(c);
    		}
    	}
    		
	    return result;
	}
	
	private List<Integer> Split(long number)
	{
		List<Integer> result = new ArrayList<Integer>();
		String s = String.valueOf(number);
		int i = s.length()-1;
		String str = "";
		while (i >= 0)
		{
			str = s.charAt(i) + str;
			if (str.length() == 3)
			{
				result.add(Integer.parseInt(str));
				str = "";
			}
			i--;
		}
		if (str.length() > 0)
		{
			result.add(Integer.parseInt(str));
		}
		return result;
	}
	
}
