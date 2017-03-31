package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BinarySearchIceCreamParlor {

	public class Data implements Comparable<Data> {	
		
		private int pos;
		private int val;
		
		public Data(int _pos, int _val){
			val = _val;
			pos = _pos;
		}
		@Override
		public int compareTo(Data arg0) {
			
			if (this.val < arg0.val)
			{
				return -1;
			}
			else if (this.val > arg0.val)
			{
				return 1;
			}
			return 0;
		}			
	}
	
	int t;
	Data[] a;
	int m, n;
	Scanner in = new Scanner(System.in);
	
	void init()
	{
        t = in.nextInt();		
	}
	
	void read()
	{
		m = in.nextInt();
        n = in.nextInt();
        a = new Data[n];
        for(int i = 0; i < n; i++){
            int ai = in.nextInt();
            Data data = new Data(i, ai);
            a[i] = data;
        }

        Arrays.sort(a);
        
        Data first = null;
        Data second = null;
        for (int i = 0; i < n-1; i++)
        {
        	first = a[i];
        	int secondIndex = indexOfExactKey(m-first.val, i+1);
        	if (secondIndex != -1)
        	{
        		second = a[secondIndex];
        		break;
        	}        	
        }
        int minId = Math.min(first.pos, second.pos)+1;
        int maxId = Math.max(first.pos, second.pos)+1;

        System.out.println(minId + " " + maxId);
	}
	
    public int indexOfExactKey(int key, int pos0) {
        int lo = pos0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid].val) hi = mid - 1;
            else if (key > a[mid].val) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
	
    public static void main(String[] args) {
    	BinarySearchIceCreamParlor sol = new BinarySearchIceCreamParlor();
    	sol.init();
        for(int a0 = 0; a0 < sol.t; a0++){
            sol.read();
        }
    }
}
