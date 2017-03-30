package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SubstringQueries {

	int n;
	int q;
	String[] s;
	public void Read()
	{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String[] s = new String[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.next();
        }
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int res = Common(s[x], s[y]);
            System.out.println(res);
            // your code goes here
        }		
	}
	
	private int Common(String s1, String s2)
	{
		int n1 = s1.length();
		int n2 = s2.length();
		int longest = 0;
		for (int i = 0; i < n1; i++)
		{
			for (int j = 0; j < n2; j++)
			{
				int cnt = 0;
				int k1 = i;
				int k2 = j;
				while (k1 < n1 && k2 < n2)
				{
					if (s1.charAt(k1) == s2.charAt(k2))
					{
						cnt++;
						if (cnt > longest)
						{
							longest = cnt;
						}
					}
					else
					{
						cnt = 0;
					}
					k1++;
					k2++;
				}
			}
		}
		return longest;
	}
	
    public static void main(String[] args) {
    	SubstringQueries sol = new SubstringQueries();
    	sol.Read();
    }
}
