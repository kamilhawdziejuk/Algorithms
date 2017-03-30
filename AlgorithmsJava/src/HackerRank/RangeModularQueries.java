package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class RangeModularQueries {

	class Query
	{
		public int x,y;
		public int left, right;
		public Query(int _x, int _y, int _left, int _right)
		{
			x = _x;
			y = _y;
			left = _left;
			right = _right;
		}
	}
	
	Query[] queries;
	int n,q;
    int[] tab;
	
	void Read()
	{
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        q = in.nextInt();
        
        tab = new int[n];
        
        for(int a_i=0; a_i < n; a_i++){
        	tab[a_i] = in.nextInt();
        }
        
        queries = new Query[q];
        
        for(int a0 = 0; a0 < q; a0++){
        	
            int left = in.nextInt();
            int right = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            Query query = new Query(x,y, left, right);
            queries[a0] = query;
        }
        
        Arrays.sort(tab);
	}
	
	void Calc()
	{
		for (int i = 0; i < q; i++)
		{
			Query query = queries[i];
			
			int rightIndex = indexOfFirstLowerOrEqualKey(query.right);
			int leftIndex = indexOfFirstHigherOrEqualKey(query.left);

			int cnt = 0;

			if (rightIndex != -1 && leftIndex != -1)
			{
				for (int j = leftIndex; j <= rightIndex; j++)
				{				
					if (query.left <= j && j <= query.right)
					{
						if (tab[j] % query.x == query.y)
						{
							cnt++;
						}
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	public int indexOfFirstLowerOrEqualKey(int key)
    {
    	int a = 0;
        int b = tab.length - 1;
        
        if (tab[a] > key) return -1;
        while (a <= b)
        {
            if (tab[b] <= key) return b;
            if (tab[a] > key) 
            {
            	return a-1;
            }
    
            int m = a + (b-a)/2;
            int value = tab[m];
            if (key < value)
            {
                b = m - 1;
            }
            else if (key > value)
            {
                a = m + 1;
            }
            else
            {
                return m;
            }
        }
        return -1;
    }
	
	public int indexOfFirstHigherOrEqualKey(int key)
    {
    	int a = 0;
        int b = tab.length - 1;
        
        if (tab[b] < key) return -1;
        while (a <= b)
        {
            if (tab[a] >= key) return a;
            if (tab[b] < key) 
            {
            	return b+1;
            }
    
            int m = a + (b-a)/2;
            int value = tab[m];
            if (key < value)
            {
                b = m - 1;
            }
            else if (key > value)
            {
                a = m + 1;
            }
            else
            {
                return m;
            }
        }
        return -1;
    }
	
    public static void main(String[] args) {

    	RangeModularQueries solution = new RangeModularQueries();
    	solution.Read();
    	solution.Calc();
    }
	
}
