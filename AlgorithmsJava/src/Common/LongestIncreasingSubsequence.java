package Common;

//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
/*The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence 
 * of a given sequence such that all elements of the subsequence are sorted in increasing order.
 */

public class LongestIncreasingSubsequence {

	public int lis(int arr[],int n)
    {
          int lis[] = new int[n];
          int i,j,max = 0;
 
          /* Initialize LIS values for all indexes */
           for ( i = 0; i < n; i++ )
              lis[i] = 1;
 
           /* Compute optimized LIS values in bottom up manner */
           for ( i = 1; i < n; i++ )
              for ( j = 0; j < i; j++ ) 
                         if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
 
           /* Pick maximum of all LIS values */
           for ( i = 0; i < n; i++ )
              if ( max < lis[i] )
                 max = lis[i];
 
            return max;
    }
}
