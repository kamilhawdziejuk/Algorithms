public class BinarySearch {

    private BinarySearch() { }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param  a the array of integers, must be sorted in ascending order
     * @param  key the search key
     * @return index of key in array <tt>a</tt> if present; <tt>-1</tt> otherwise
     */
    public static int indexOfExactKey(int[] tab, int key) {
        int lo = 0;
        int hi = tab.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < tab[mid]) hi = mid - 1;
            else if (key > tab[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    public static int indexOfFirstLowerOrEqualKey(int tab[], int key)
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
}