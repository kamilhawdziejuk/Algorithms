package LeetCode;
import java.util.*;

public class CountingBits {
	
	
	public static void main(String[] args) {
		CountingBits prog = new CountingBits();
		int[] res = prog.countBits(5);
	}
	
    public int[] countBits(int num) {
    	
    	if (num == 0) {
    		int[] res = {0};
    		return res;
    	} 
    	
    	List<Integer> list = new ArrayList<>();
    	list.add(0);
    	int cnt = 1;
    	while (cnt <= num) {
    		gen(list, num+1);
    		cnt = list.size();
    	}
    	
    	int[] array = list.stream().mapToInt(i->i).toArray();
    	
    	return array; 
    }
    
    private void gen(List<Integer> list, int fin) {
    	int n = list.size();
    	if (n == fin) return;
    	for (int i = 0; i < n; i++) { 
    		list.add(list.get(i)+1);
    		if (list.size() == fin) return;
    	}
    	return;
    }
}
