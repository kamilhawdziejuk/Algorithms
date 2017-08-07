package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PatternCount {

    static int patternCount(String s){
        // Complete this function
    	int cnt = 0;
    	int n = s.length();
    	boolean started = false;
    	for (int i = 0; i < n; i++) {
    		if (i > 0) {    			
    			Character c = s.charAt(i);
    			if (c != '0') {
    				if (c == '1') {
    					if (started) {
    						cnt++;
    						started = false;
    					}
    				}
    				else {
        				started = false;    					
    				}
    			} else {
    				Character cPrev = s.charAt(i-1);
    				if (cPrev == '1') {
    					started = true;
    				}
    			}
    		}
    	}
    	return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = patternCount(s);
            System.out.println(result);
        }
    }
}
