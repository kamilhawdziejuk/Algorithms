package alg.Sorts;
import java.util.*;

public class DataSort {
	
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
	
	void sort()
	{
		List<Data> list = new ArrayList<Data>();
		Collections.sort(list);
		
		Data[] tab = new Data[100];
		Arrays.sort(tab);
	}
}
