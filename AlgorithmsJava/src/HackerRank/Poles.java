package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Poles {
	
	class Pole
	{
		long x;
		long w;
	}
	
	private int n;
	private int k;	
	private Pole[] tab;
	long[][] M;
	long[][] falls;
	
	private void Read()
	{
        Scanner in = new Scanner(System.in);        
        n = in.nextInt();
        k = in.nextInt();        
        tab = new Pole[(int)n];
        
        M = new long[n+1][n+1];
        for (int i = 0; i <= n; i++) M[i] = new long[n+1];
        
        falls = new long[n+1][n+1];
        for (int i = 0; i <= n; i++) falls[i] = new long[n+1];
        
        for(int i = 0; i < n; i++){
            int x_i = in.nextInt();
            int w_i = in.nextInt();
            
            Pole p = new Pole();
            p.w = w_i;
            p.x = x_i;
            
            tab[i] = p;
        }
	}
	
	private long Calc(int from, int to) //from >= to
	{
		if (from == to) return 0;		
		if (falls[from][to] == 0)
		{		
			long result = 0;
			long sum = 0;
			for (int i = from; i > to; i--)
			{
				long x_diff = tab[i].x - tab[i-1].x;
				sum += tab[i].w;						
				long mult = sum * x_diff;
				result += mult;
			}		
			falls[from][to]=result;
		}
		return falls[from][to];
	}
	
	private long CalcM(int to, int K) //finally to==0
	{
		if (M[to][K] == 0)
		{
			if (K == 1)
			{
				M[to][K] = Calc(n-1, to);
			}
			else
			{
				long sumMin = Long.MAX_VALUE;
				for (int i= to+1; n-i >= K-1; i++)
				{
					long ki = CalcM(i, K-1);
					long down = Calc(i-1, to);
					long sum = down + ki;
					sumMin = Math.min(sumMin, sum);
				}
				M[to][K] = sumMin;
			}
		}
		return M[to][K];
	}
	
    public static void main(String[] args) {		
    	Poles solution = new Poles();
        solution.Read();
        long result = solution.CalcM(0, solution.k);
        System.out.println(result);
    }
}
