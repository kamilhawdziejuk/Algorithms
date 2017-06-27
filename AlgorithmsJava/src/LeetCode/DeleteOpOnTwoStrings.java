package LeetCode;

//https://leetcode.com/problems/delete-operation-for-two-strings/#/description
//100%

public class DeleteOpOnTwoStrings {  
	
    public int minDistance(String word1, String word2) {
        int common = lcs(word1, word2);
        int out = word1.length() + word2.length() - 2*common;
        return out;
    }
    
    int lcs(String X, String Y)
    {
    	return lcs(X.toCharArray(), Y.toCharArray(), X.length(), Y.length());
    }
    
    /* Returns length of LCS for X[0..m-1], Y[0..n-1] 
     * Based on http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/*/
    int lcs( char[] X, char[] Y, int m, int n )
    {
      int L[][] = new int[m+1][n+1];
   
      /* Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
      for (int i=0; i<=m; i++)
      {
        for (int j=0; j<=n; j++)
        {
          if (i == 0 || j == 0)
              L[i][j] = 0;
          else if (X[i-1] == Y[j-1])
              L[i][j] = L[i-1][j-1] + 1;
          else
              L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
        }
      }
      return L[m][n];
    }
  
}
