package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CalcArraySize {

    static long getArrayKb(int n, int[] d){
        // Complete this function
    	
    	long res = 1;
    	for (int i = 0; i < n; i++) {
    		res *= d[i];
    	}
    	    	
    	
    	return (long)(res/256);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //  Return the size of the multidimensional array in kilobytes. Return only the integer part.
        int n = in.nextInt();
        int[] d = new int[n];
        for(int d_i=0; d_i < n; d_i++){
            d[d_i] = in.nextInt();
        }
        long result = getArrayKb(n, d);
        System.out.println(result);
    }
	
}
