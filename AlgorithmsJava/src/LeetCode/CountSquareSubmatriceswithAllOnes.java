package LeetCode;

//May 21st Challange
//Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
public class CountSquareSubmatriceswithAllOnes {
	
	public static void main(String[] args) {
		CountSquareSubmatriceswithAllOnes sol = new CountSquareSubmatriceswithAllOnes();
		int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
		sol.countSquares(matrix);
	}
	
	class Data {
		public int up;
		public int left;
		public int cnt;
		public Data() {
			up = left = cnt = 0;
		}
	}
	

	private Data[][] prep(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		Data[][] res = new Data[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res[i][j] = new Data();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j == 0) {
					res[i][j].left = matrix[i][j];
				} else {
					res[i][j].left = matrix[i][j] == 1 ? res[i][j-1].left + 1 : 0;
				}
			}
		}
		
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				if (i == 0) {
					res[i][j].up = matrix[i][j];
				} else {
					res[i][j].up = matrix[i][j] == 1 ? res[i-1][j].up + 1 : 0;
				}
			}
		}
		
		return res;
	}
	
    public int countSquares(int[][] matrix) {
    	Data[][] res = prep(matrix);
		int n = matrix.length;
		int m = matrix[0].length;
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 1) {
					res[i][j].cnt = 1;
					if (i > 0 && j > 0) {
						int val = Math.min(res[i-1][j].up, res[i][j-1].left);
						int val2 = Math.min(val,  res[i-1][j-1].cnt);
						res[i][j].cnt += val2;
					}
					count += res[i][j].cnt;
				}
			}
		}
        return count;
    }
		
}
