package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Poles {

	class Pole
	{
		int x;
		int w;
	}
	
	class Data
	{
		int pos;
		BigInteger val;
		
	}
	
	private int n;
	private int k;	
	private Pole[] tab;
	private List<Data> list;
	private List<Integer> res;
	private int M[][];
	private int p[];
	
	private void Read()
	{
        Scanner in = new Scanner(System.in);        
        n = in.nextInt();
        k = in.nextInt();        
        tab = new Pole[n];
        list = new ArrayList<Data>();
        res = new ArrayList<Integer>();
        
        M = new int[n+1][];
        p = new int[n+1];
        for (int i = 0; i <= n; i++) M[i] = new int[k+1];
        
        for(int i = 0; i < n; i++){
            int x_i = in.nextInt();
            int w_i = in.nextInt();
            
            Pole p = new Pole();
            p.w = w_i;
            p.x = x_i;
            
            tab[i] = p;
        }
	}
	
	private BigInteger Sum()
	{
		BigInteger result = BigInteger.ZERO;
		int j = n-1;
		for (int i = 0; i < k; i++)
		{
			int nr = res.get(i);
			BigInteger sum = BigInteger.ZERO;

			int pos = n-j;
			while (pos != nr)
			{
				int x_diff = tab[j].x - tab[j-1].x;
				sum = sum.add(BigInteger.valueOf(tab[j].w));				

				BigInteger x = BigInteger.valueOf(x_diff);
				BigInteger mult = sum.multiply(x);				
				result = result.add(mult);
				
				j--;
				pos = n-j;
			}
			j--;
		}
		return result;
	}
	
	//TODO int->long
	private void Partition()
	{
		int sum = 0;
		for (int i = n-1; i > 0; i--)
		{
			int x_diff = tab[i].x - tab[i-1].x;
			sum += tab[i].w;	
			int mult = (sum * x_diff);
			
			int j = n-i;
			p[j] = p[j-1] + mult;
		}		
		for (int i = 1; i <= n; i++)
		{
			M[i][1] = p[i];
		}

		for (int i=1; i <=  k; i++)
		{
			int s_i = tab[n-i].x;
			M[1][i] = s_i;
		}

		int INF = 2000000000;
		for (int i = 2; i <=n ;i++)
		{
			for (int j = 2; j <= k; j++)
			{
				M[i][j] = INF;
				for (int x = 1; x <= i-1; x++)
				{
					int s = Math.max(M[x][j-1],p[i]-p[x]);
					if (M[i][j] > s)
					{
						M[i][j] = s;
					}
				}
			}
		}
	}
	
	private void Calc()
	{
		BigInteger sum = BigInteger.ZERO;
		for (int i = n-1; i > 0; i--)
		{
			int x_diff = tab[i].x - tab[i-1].x;
			sum = sum.add(BigInteger.valueOf(tab[i].w));	
			
			Data d = new Data();
			d.pos = n-i;
			
			BigInteger x = BigInteger.valueOf(x_diff);
			BigInteger mult = sum.multiply(x);				
			
			d.val = mult;
			list.add(d);
		}		
		
		Collections.sort(list, (o1, o2) -> o2.val.compareTo(o1.val));
		for (int i = 0; i < k-1; i++)
		{			
			res.add(list.get(i).pos);
		}
		res.add(n);
		
		Collections.sort(res, (o1, o2) -> o1 - o2);
	}
	
    public static void main(String[] args) {
		
        Poles solution = new Poles();
        solution.Read();
        solution.Partition();
    }
}
