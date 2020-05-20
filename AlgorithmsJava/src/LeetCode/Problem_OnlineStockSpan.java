package LeetCode;
import java.util.*;

public class Problem_OnlineStockSpan {

	class StockSpanner {

		List<Integer> list = new ArrayList<>();
		List<Integer> values = new ArrayList<>();
		
		int current = -1;
		
	    public StockSpanner() {
	    	//list = Arrays.asList(100, 80, 60, 70, 60, 75, 85);
	    }
	    
	    public int next(int price) {
	    	list.add(price);
	    	current++;
	    	
	    	int res = get(current-1, price);
	    	values.add(res+1);
	        return res+1;
	    }
	    
	    private int get(int index, int price) {
	    	if (index < 0) return 0;
	    	int val = list.get(index);
	    	if (val > price) return 0;

	    	int val2 = values.get(index);
	    	int prev = get(index-val2, price);
    		return val2 + prev;
	    }
	}
	
	public static void main(String[] args) {
		StockSpanner pro = new Problem_OnlineStockSpan().new StockSpanner();
		List<Integer> l = Arrays.asList(100, 80, 60, 70, 60, 75, 85);
		for (int i : l) {
			pro.next(i);
		}
		
	}
	
}
