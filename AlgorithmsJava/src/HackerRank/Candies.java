package HackerRank;

import java.util.Scanner;

import alg.Sorts.DataSort.Data;

import java.util.*;

public class Candies {
	
	Scanner in = new Scanner(System.in);	
	int n;
	int res[];
	Data data[];
	List<Data> lowest;
	
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
	
	public void Read()
	{
        n = in.nextInt();
        res = new int[n];
        
        for (int i = 0; i < n; i++) {
        	res[i] = 0;
        }
        
        data = new Data[n];
        for (int i = 0; i < n; i++) {
        	int val = in.nextInt();
        	data[i] = new Data(i, val);
        }
	}
	
	public void CalcLowest()
	{
		lowest = new ArrayList<Data>();
		if (n == 1)
		{
			lowest.add(data[0]);
			return;
		}
		for (int i = 0; i < n; i++)
		{
			if (i > 0)
			{
				if (i < n-1)
				{
					if (data[i].val < data[i-1].val && data[i].val <= data[i+1].val)
					{
						lowest.add(data[i]);
					} 
					else if (data[i].val <= data[i-1].val && data[i].val < data[i+1].val)
					{
						lowest.add(data[i]);
					}
				}
				else { //i == n-1
					if (data[i].val < data[i-1].val) {
						lowest.add(data[i]);
					}
				}
			}
			else { //i==0
				if (data[i].val < data[i+1].val)
				{
					lowest.add(data[i]);
				}
			}
		}
		Collections.sort(lowest);
	}
	
	private void Fill(int pos)
	{
		//left:
		int val = data[pos].val;
		int left = pos-1;
		while (left >= 0) {
			if (data[left].val > data[left+1].val) {
				if (res[left] == 0) {
					res[left] = res[left+1]+1;
				} else {
					res[left] = Math.max(res[left], res[left+1]+1);
					break;
				}
				left--;
			} else {
				break;
			}
		}
		int right = pos+1;
		while (right < n) {
			if (data[right].val > data[right-1].val) {
				if (res[right] == 0) {
					res[right] = res[right-1]+1;
				} else {
					res[right] = Math.max(res[right], res[right-1]+1);
					break;
				}
				right++;
			} else {
				break;
			}
		}
	}
	
	public void FillAll()
	{
		for (int i = 0; i < lowest.size(); i++)
		{
			int pos = lowest.get(i).pos;
			if (res[pos] == 0) {
				res[pos] = 1;
			}
			Fill(pos);
		}
		for (int i = 0; i < n; i++) {
			if (res[i] == 0) {
				res[i] = 1;
			}
		}
		//calc result:
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += res[i];
		}
		System.out.println(sum);
	}
	
    public static void main(String[] args) {

    	Candies sol = new Candies();
    	sol.Read();
    	sol.CalcLowest();
    	sol.FillAll();
    }
}
