package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChoosingWhiteBalls {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String balls = in.next();
        
        double result = 0;
        
        if (k == 1)
        {
        	double whites = 0;
        	for (int i = 0; i < n; i++)
        	{
        		if (balls.charAt(i) == 'W' || balls.charAt(n-i-1) == 'W')
        		{
        			whites++;
        		}        			     			        			        			 
        	}
        	if (whites > 0)
        	{
        		result = whites / n;
        	}
        }
        else if (k == 2)
        {
        	
        }
        DecimalFormat df = new DecimalFormat("0.0000000");
        System.out.println(df.format(result));
        // your code goes here
    }
    
}
