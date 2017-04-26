import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import HackerRank.BinarySearchIceCreamParlor.Data;

public class ListCollection {
	
	public List<Integer> list = new ArrayList<>();
	public int[] tab = new int[1000];
	
	public void listManipulate()
	{
		list.clear();

		for (int i = 0; i < 10; ++i)
		{
			list.add(5*i-i*i);
		}
		
		list.add(3);
		list.add(7);
		int valueAtIndex = list.get(0);
		
		int index = 1;
		list.add(index, 33);
		
		int listSize = list.size();
		boolean contains2 = list.contains(2);
				
		int indexOf2 = list.lastIndexOf(2);
		
		boolean isEmpty = list.isEmpty();
		
		list.set(index, 55);
		
		//list.removeIf(filter)
		
		list.remove(index);
		
		String stringList = list.toString();
		
		//list = list.subList(0, 10*index);
		
		//Comparator<Integer> comp = IntComparator;
		list.sort(IntComparator);
		
		//Predicate<Integer> pred = isEven();
		list.removeIf(isEven());
	}
	
	private static Comparator<Integer> IntComparator = new Comparator<Integer>() 
	{
		@Override
		public int compare(Integer arg0, Integer arg1) {
			if (arg1 < arg0)
			{
				return -1;
			}
			else if (arg1 > arg0)
			{
				return 1;
			}
			return 0;
		}
	};	

    private static Predicate<Integer> isEven() {
    	Predicate<Integer> pred = null;//i -> (i % 2 == 1);
    	return pred;
        //return p -> (p % 2 == 1);
    }
    
    //sorted increasingly
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
     
	
}