package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class AGraphProblem {

	int n;
	int[][] g;
	
	public void Read()
	{
        Scanner in = new Scanner(System.in);
        String str;
        n = in.nextInt();
        g = new int[n][n];
        for(int g_i=0; g_i < n; g_i++){
            for(int g_j=0; g_j < n; g_j++){
                g[g_i][g_j] = in.nextInt();
            }
        }
	}
	
	public void Calc()
	{
		Set<Integer> nums = new HashSet<Integer>();
		for (int i = 0; i < n; i++)
		{
			nums.add(i);
		}
		double result = 0;
		Set<Integer> resultSet = new HashSet<Integer>();
		
		Set<Set<Integer>> subsets = GenerateSubsets(nums);
		/*subsets.clear();
		
		Set<Integer> bestSet = new HashSet<Integer>();
		bestSet.add(0);
		bestSet.add(1);
		bestSet.add(2);
		bestSet.add(3);
		subsets.add(bestSet);
		*/
		for (Set<Integer> set : subsets)
		{
			double size = (double)set.size();
			if (size >= 3)
			{
				double triangles = (double)CalcSubgraphs(set);
				double amount =  triangles / size;
				if (result < amount)
				{
					result = amount;
					resultSet = set;
				}
			}
		}
		System.out.println(resultSet.size());
		for (Integer elem : resultSet)
		{
			System.out.print(elem+1);
			System.out.print(" ");
		}
	}
	
	public int CalcSubgraphs(Set<Integer> set)
	{
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		int m = list.size();
		int cnt = 0;
		for (int i = 0; i < m-2; i++)
		{
			for (int j = i+1; j < m-1; j++)
			{
				for (int k = j+1; k < m; k++)
				{
					int a = list.get(i);
					int b = list.get(j);
					int c = list.get(k);
					if (g[a][b] == 1 && g[a][c] == 1 && g[b][c] == 1)
					{
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	public Set<Set<Integer>> GenerateSubsets(Set<Integer> set)
	{
		Set<Set<Integer>> results = new HashSet<Set<Integer>>();
		int n = set.size();
		int amount = (int) Math.pow(2, n);
		for (int nr = 0; nr < amount; nr++)
		{
			String data = Integer.toBinaryString(nr);
			int length = data.length();
			Set<Integer> result = new HashSet<>();
			int i = 0;
			for (Integer elem : set)
			{
				if (i >= length) break;
				if (data.charAt(length-i-1) == '1')
				{
					result.add(elem);
				}
				i++;
			}
			//Print(result);
			results.add(result);
		}
		return results;
	}
	
	public static void main(String[] args) {
		AGraphProblem solution = new AGraphProblem();
		solution.Read();
		solution.Calc();
	}

}
