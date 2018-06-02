//https://practice.geeksforgeeks.org/problems/word-boggle/0

package geeksforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class WordBoggle {	

	int T;
	int x;
	int n,m;
	String[] dict;
	char boggle[][];
	int largest = 0;
	List<String> res = new ArrayList<>();
	
	public static void main(String [ ] args)
	{	
		WordBoggle data = new WordBoggle();
		data.Read();	
		data.Calc();		
	}
	
	private boolean exists(String word) {
		for (int i = 0; i < x; i++) {
			if (dict[i].equals(word)) {
				return true;
			}
		}
		return false;
	}
		
	private boolean canBe(String word) {
		for (int i = 0; i < x; i++) {
			if (dict[i].startsWith(word)) {
				return true;
			}
		}
		return false;
	}
	
	public void Calc() 
	{
        for (int r = 0; r < m; r++)
        {
            for (int c = 0; c < n; c++)
            {
            	Calc(r,c, boggle[r][c] + "");
            }
        }
        java.util.Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
        	System.out.print(res.get(i));
        	System.out.print(" ");
        }
	}
	
	private void Calc(int r, int c, String current) {
		if (current.length() > largest) {
			return;
		}
		if (exists(current) && !res.contains(current)) {
			res.add(current);
		}
		if (!canBe(current)) {
			return;
		}
			
		if (ok(r-1,c-1)) Calc(r-1,c-1, current + boggle[r-1][c-1]);
		if (ok(r-1,c)) Calc(r-1,c, current + boggle[r-1][c]);
		if (ok(r-1,c+1)) Calc(r-1,c+1, current + boggle[r-1][c+1]);
		
		if (ok(r,c-1)) Calc(r,c-1, current + boggle[r][c-1]);
		if (ok(r,c+1)) Calc(r,c+1, current + boggle[r][c+1]);
		
		if (ok(r+1,c-1)) Calc(r+1,c-1, current + boggle[r+1][c-1]);
		if (ok(r+1,c)) Calc(r+1,c, current + boggle[r+1][c]);
		if (ok(r+1,c+1)) Calc(r+1,c+1, current + boggle[r+1][c+1]);
	}
	
	private boolean ok(int r, int c) {
		return (r >= 0 && c >= 0 && r < m && c < n);
	}
	
	void Read() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
			T = Integer.parseInt(br.readLine());		
			for (int i = 0; i < T; ++i) {
				
				largest = 0;
				x = Integer.parseInt(br.readLine());				
				String line = br.readLine();
				
				dict = Arrays.asList(line.split(" ")).toArray(new String[0]);
				for (int j = 0; j < dict.length; j++) {
					largest = Math.max(largest, dict[j].length());
				}

				line = br.readLine();
				List<String> nums = Arrays.asList(line.split(" "));
				m = Integer.parseInt(nums.get(0));				
				n = Integer.parseInt(nums.get(1));				

				line = br.readLine();
				List<String> elems = Arrays.asList(line.split(" "));

				int it = 0;
				boggle = new char[m][n];
		        for (int r = 0; r < m; r++)
		        {
		            for (int c = 0; c < n; c++)
		            {
		                boggle[r][c] = elems.get(it++).charAt(0);		
		            }
		        }
	        }			
		} catch (Exception e) {
			e.printStackTrace();
		}              
	}
	
}
