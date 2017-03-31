package alg.Sorts;

public class Mergesort {

	private static long swaps = 0;
	  
	//sorts the array and additional counts the inversions  
    public static long countInversions(int[] arr){
        swaps = 0;
        mergeSort(arr, new int[arr.length], 0, arr.length-1);
        return swaps;
    }
    
    static void merge(int[] arr, int[] helper, int low, int mid, int high){
        for(int i = low; i <= high; i++){
            helper[i] = arr[i];
        }
        
        int i = low, j = mid + 1, k = low;
        while(i <= mid && j <= high){
            if(helper[i] <= helper[j]){
                arr[k++] = helper[i++];
            }else{
                arr[k++] = helper[j++];
                swaps += (mid - i) + 1;
            }
        }
        while(i <= mid){
            arr[k++] = helper[i++];
        }
    }
    
    static void mergeSort(int[] arr, int[] helper, int low, int high){
        
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(arr, helper, low, mid);
            mergeSort(arr, helper, mid+1, high);
            merge(arr, helper, low, mid, high);
        }
    }
	
}
