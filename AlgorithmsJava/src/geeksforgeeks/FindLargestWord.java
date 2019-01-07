//https://practice.geeksforgeeks.org/problems/find-largest-word-in-dictionary/0

package geeksforgeeks;

import java.util.*;

public class FindLargestWord {
	
	public static void main (String[] args) {
	    
	    Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            String[] words = new String[n];
            
            for (int k = 0; k < n; k++) {
                words[k] = in.next();
            }    
            
            String str = in.next();
            
            
            int longest = 0;
            String result = "";
            for (int j = 0; j < n; j++) {
                String word = words[j];
                if (check(str, word)) {
                    int length = word.length();
                    if (length > longest) {
                        longest = length;
                        result = word;
                    }
                }    
            }
            
            if (longest > 0) {
                System.out.println(result);
            }
        }
	}
	
	private static boolean check(String str, String word) {
	    if (word.length() > str.length()) {
	        return false;
	    }
	    int pos = 0;
	    int i;
	    for (i = 0; i < word.length(); i++) {
	        
	        while (pos < str.length() && word.charAt(i) != str.charAt(pos)) {
	            pos++;
	        }
	        
	        if (pos >= str.length()) {
	            return false;
	        }
	    }
	    return true;
	}
}
