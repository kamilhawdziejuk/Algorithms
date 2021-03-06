
import java.util.*;
import java.util.stream.Collectors;

public class APIArray {
    	
	 public static void main(String[] args) {
		 
		 APIArray sol = new APIArray();
		 
		 int[] t = {0,1,2,3,4,5,6,7,8,9};
		 print(t);
		 change(t);
		 print(t);
		 
		 //converting List to Array
		 List<Integer> list = Arrays.stream(t)		// IntStream
					.boxed()  		// Stream<Integer>
					.collect(Collectors.toList());
		 
		 int[] table = list.stream().
				 mapToInt(Integer::intValue).toArray();
		 
		 list.sort((a,b) -> { return a.compareTo(b); });
		 
		 Arrays.sort(t);
		 
	     List<List<Integer>> res = new ArrayList<List<Integer>>();
	     List<Integer> list2 = new ArrayList<>();
		 
		 StringBuilder sb = new StringBuilder();
		 
	 }
	 
	 
	 private static void print(int[] tab)
	 {
		 for (int i = 0; i < tab.length; i++) {
			 System.out.print(tab[i] + " ");
		 }
		 System.out.println();
	 }
	 
	 //tab is sent via reference so change occurs
	 private static void change(int[] tab)
	 {
		 tab[1] = -1;
		 tab[0] = -1;
	 }
}
