package HackerRank;

import java.util.*;
import java.util.stream.Collectors;

public class Challenge1 {

	public static void main(String[] args) {
		find_all_possible_teams();
	}

	
	 
	static void find_all_possible_teams() {
		
		Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
		    public int compare(String str1, String str2) {

		    	if (str1.length() < str2.length()) {
		    		return -1;
		    	}
		    	else if (str1.length() > str2.length()) {
		    		return 1;
		    	}
		    	return str1.compareTo(str2);
		    }
		};

		
		
    	Scanner in = new Scanner(System.in);
        String dane = in.nextLine();
		
		Set<Character> set = new HashSet<>();
		for (Character c : dane.toCharArray()) {
			set.add(c);
		}
	
		
		
		List<String> list = new ArrayList<>();
		
		int n = set.size();
		int amount = (int) Math.pow(2, n);
		for (int nr = 0; nr < amount; nr++)
		{
			String data = Integer.toBinaryString(nr);
			int length = data.length();
			Set<Character> result = new HashSet<>();
			int i = 0;
			for (Character elem : set)
			{
				if (i >= length) break;
				if (data.charAt(length-i-1) == '1')
				{
					result.add(elem);
				}
				i++;
			}
	
			String res = "";
			for (Character c : result) {
				res += c;
			}			
			char tempArray[] = res.toCharArray(); 
	        Arrays.sort(tempArray); 
	        res = new String(tempArray); 
			list.add(res);
		}
		
		Collections.sort(list, ALPHABETICAL_ORDER);
		
		for (String elem : list) {
			System.out.println(elem);
		}
					
    }
	 
	 
	 
	 

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	 
	 
	 
	    // Complete the merge_overlapping_intervals function below.
	    static void merge_overlapping_intervals() {

	 
	    	class Interval {
	    		public int start;
	    		public int end;
	    		
	    		public Interval(int _start, int _end) {
	    			start = _start;
	    			end = _end;
	    		}
	    	}
	    	
	    	class IntervalComparator implements Comparator<Interval>
	    	{
	    	    public int compare(Interval i1, Interval i2)
	    	    {
	    	        return i1.start - i2.start;
	    	    }
	    	}
	    	
	    	List<Interval> intervals = new ArrayList<>(); 
	    	
	    	Scanner in = new Scanner(System.in);
	         int n = in.nextInt();
	         for (int i = 0; i < n; i++) {
	             int begin = in.nextInt();
	             int end = in.nextInt();
	             
	             Interval interval = new Interval(begin, end);
	             intervals.add(interval);
	         }
	    	
	         if (n == 0) {
	        		System.out.println("0");
	        		return;
	         }
	         if(n == 1)
	         {
	        	 System.out.println("1");
	        	 System.out.println(intervals.get(0).start + " " + intervals.get(0).end);
	        	 return;
	         }

	         Collections.sort(intervals, new IntervalComparator());

	         Interval first = intervals.get(0);
	         int start = first.start;
	         int end = first.end;

	         ArrayList<Interval> result = new ArrayList<Interval>();

	         for (int i = 1; i < intervals.size(); i++) {
	             Interval current = intervals.get(i);
	             if (current.start <= end) {
	                 end = Math.max(current.end, end);
	             } else {
	                 result.add(new Interval(start, end));
	                 start = current.start;
	                 end = current.end;
	             }
	         }

	         result.add(new Interval(start, end));
	         System.out.println(result.size());
	         for (int i = 0; i < result.size(); i++) {
	        	 System.out.println(intervals.get(i).start + " " + intervals.get(i).end);
	         }
	         
	    }
	 
	 
	 
     static void best_hotels() {

         class Data implements Comparable<Data> {    
             
             private int id;
             public double val;
             
             public Data(int _id, double _val){
                 val = _val;
                 id = _id;
             }
             @Override
             public int compareTo(Data arg0) {
                 
                 if (this.val > arg0.val)
                 {
                     return -1;
                 }
                 else if (this.val < arg0.val)
                 {
                     return 1;
                 }
                 if (this.id < arg0.id) {
                     return -1;
                 }
                 else if (this.id > arg0.id) {
                     return 1;
                 }
                 return 0;
             }            
         }
      
         
         Map<Integer, Double> map = new HashMap<>();
         Map<Integer, Long> amount = new HashMap<>();
         
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         for (int i = 0; i < n; i++) {
             int id = in.nextInt();
             long score = in.nextLong();             
             
             map.put(id, map.getOrDefault(id, 0.0)+score);
             
             if (amount.containsKey(id)) {
                 amount.put(id, amount.get(id)+1L);
             }
             else {
                 amount.put(id, 1L);                 
             }
         }
         
             List<Data> list = new ArrayList<Data>();
            for (Map.Entry<Integer, Long> entry : amount.entrySet())
            {
                Integer key = entry.getKey();
                Long value = entry.getValue();
                double val = map.get(key) / value;
                Data elem = new Data(key, val);
                list.add(elem);
            }
            
            Collections.sort(list);
            
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
     }
}
