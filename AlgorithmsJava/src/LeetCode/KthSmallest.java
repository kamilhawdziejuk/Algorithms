package LeetCode;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallest {

	class Data {
		public int Row;
		public int Col;
		public int Val;
	}
	
	public static void main(String[] args) {
		KthSmallest prog = new KthSmallest();
		int[][] matrix = {
				{ 1,  5,  9 },
		          { 10, 11, 13 },
		          {12, 13, 15}
		          };
		prog.kthSmallest(matrix, 8);

	}
	
    public int kthSmallest(int[][] matrix, int k) {
    	int n = matrix.length;
    	Data[] tab = new Data[n];
    	for (int i = 0; i < n; i++) {
    		tab[i] = new Data();
    		tab[i].Row = i;
    		tab[i].Col = 0;
    		tab[i].Val = matrix[i][0];
    	}
    	
    	
    	Data data = pickSmallest(tab);
    	int nr = 1;
    	if (nr == k) {
    		return data.Val;
    	}
    	move(tab, data, matrix);
    	while (nr < k) {
    		data = pickSmallest(tab);
    		++nr;
    		if (nr == k) {
    			return data.Val;
    		}
    		move(tab, data, matrix);
    		
    	}
    	return data.Val;
    }
    
    private Data pickSmallest(Data[] tab) {
    	int n = tab.length;
    	Data data = tab[0];
		for (int i = 0; i < n; i++) {
			if (tab[i].Val < data.Val) {
				data = tab[i];
			}
		}
		return data;
    }
    
    private void move(Data[] tab, Data data, int[][] matrix) {
    	int n = tab.length;
    	int i = data.Row;
    	int j = data.Col;
    	if (data.Col == n-1) {
    		tab[data.Row].Val = Integer.MAX_VALUE;
    	} else {
    		tab[data.Row].Col++;
    		tab[data.Row].Val = matrix[i][j+1];
    	}
    }

}
