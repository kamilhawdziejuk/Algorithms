package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CartesianCountry {

    
    static long getMaxBridges(long x1, long y1, long x2, long y2, long xC, long yC){
        // Complete this function
    	
    	long w = Math.min( Math.abs(xC-x1), Math.abs(x2-xC));
    	long h = Math.min( Math.abs(yC-y1), Math.abs(y2-yC));

    	return ((2*w+1)*(2*h+1)-1)/2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //  Return the maximum number of bridges the Rulers will commission.
        long x1 = in.nextLong();
        long y1 = in.nextLong();
        long x2 = in.nextLong();
        long y2 = in.nextLong();
        long xC = in.nextLong();
        long yC = in.nextLong();
        long result = getMaxBridges(x1, y1, x2, y2, xC, yC);
        System.out.println(result);
    }
	
}
