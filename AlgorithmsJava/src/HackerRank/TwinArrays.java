package HackerRank;
import java.util.*;

public class TwinArrays {

	List<Data> list2 = new ArrayList<Data>();
	List<Data> list1 = new ArrayList<Data>();
	Scanner in;
	
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

    public void Read() {
    	in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int val = in.nextInt();
            Data data = new Data(i, val);
            list1.add(data);
        }
        
        for(int i = 0; i < n; i++){
            int val = in.nextInt();
            Data data = new Data(i, val);
            list2.add(data);
        }
    }
    
    public Data Get2(int withoutPos) {
    	int n = list1.size();
    	int min = Integer.MAX_VALUE;
    	Data dataMin = null;
    	for (int i = 0; i < n; i++) {
    		Data data = list2.get(i);
    		if (data.pos != withoutPos) {
    			if (data.val <= min) {
    				min = data.val;
    				dataMin = data;
    			}
    		}
    	}
    	return dataMin;
    }
    
    public Data Get1(int withoutPos) {
    	int n = list1.size();
    	int min = Integer.MAX_VALUE;
    	Data dataMin = null;
    	for (int i = 0; i < n; i++) {
    		Data data = list1.get(i);
    		if (data.pos != withoutPos) {
    			if (data.val <= min) {
    				min = data.val;
    				dataMin = data;
    			}
    		}
    	}
    	return dataMin;
    }
    
    public int Calc() {
    	Data d11 = Get1(-1);
    	Data d12 = Get1(d11.pos);
    	
    	Data d21 = Get2(-1);
    	Data d22 = Get2(d21.pos);
    	
    	if (d11.pos != d21.pos) {
    		return d11.val + d21.val;
    	} else {
    		return Math.min(d11.val + d22.val, d12.val + d21.val);
    	}
    }
    
    public static void main(String[] args) {
    	TwinArrays sol = new TwinArrays();
    	sol.Read();
    	int result = sol.Calc();
    	System.out.println(result);
    }
}
