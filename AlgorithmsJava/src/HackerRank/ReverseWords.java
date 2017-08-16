//http://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
//100%
package HackerRank;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ReverseWords {

	char[] _chars = null;
	public ReverseWords(String str) {
		_chars = str.toCharArray();
	}

	public String getResult()
	{
		return String.valueOf(_chars);
	}
	
	public void reverse() {
		int a = -1;
		int b = 0;
		int n = _chars.length;
		if (n <= 1) return;
		while (b < n) {
			if (_chars[b] == '.') {
				reverse(a+1, b-1);
				a = b;
			}
			b++;
		}
		if (_chars[n-1] != '.') {
			reverse(a+1, b-1);
		}
	}
	
	public void reverse(int a, int b) {
		if (a >= b) {
			return;
		}
		int begin = a;
		int end = b;
		while (begin < end) {
			Character tmp = _chars[begin];
			_chars[begin] = _chars[end];
			_chars[end] = tmp;
			++begin;
			--end;
		}
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
			int amount = Integer.parseInt(br.readLine());

			for (int i = 0; i < amount; i++) {        
				String str = br.readLine();
		       
		        ReverseWords sol = new ReverseWords(str);
		        sol.reverse();
		        sol.reverse(0, str.length()-1);
		        String res = sol.getResult();
		        System.out.println(res);
	    	}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	
}
