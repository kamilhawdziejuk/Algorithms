// https://practice.geeksforgeeks.org/problems/meta-strings/0
	
package geeksforgeeks;

import java.io.*;
import java.util.*;

public class MetaStrings {

	int T;
	
	public static void main(String [ ] args)
	{	
		MetaStrings data = new MetaStrings();
		data.Calc();		
	}
	
	int Check(String s1, String s2) {
		List<Integer> positions = new ArrayList<>();
		if (s1.length() == s2.length()) {
			for (int i = 0; i < s1.length();i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					positions.add(i);
				}
			}			
		}
		if (positions.size() == 2) {
			int p1 = positions.get(0);
			int p2 = positions.get(1);
			if (s1.charAt(p1) == s2.charAt(p2) && s1.charAt(p2) == s2.charAt(p1)) {
				return 1;
			}
		}
		return 0;
	}
	
	void Calc() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
			T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; ++i) {
	        	String s1 = br.readLine();
	        	String s2 = br.readLine();
	        	System.out.println(Check(s1, s2));
	        }			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
	}	
}
