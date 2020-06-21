package LeetCode;
import java.util.*;

public class InsertInterval {
       
    public static void main(final String[] args) {
        InsertInterval prog = new InsertInterval();
        int[][] intervals = new int[10000][2];// {{1, 2}, {3,4}, {5, 6}, {7, 8}};

        for (int i = 1; i<= 10000; i++) {
            intervals[i-1][0] = 2*(i-1)+1;
            intervals[i-1][1] = 2*i;
        }
        
        int[] newInterval = {0,20001};
        prog.insert(intervals, newInterval);
    }

    public class Interval implements Comparable<Interval> {		
        public int Begin;
        public int End;
		public Interval(final int begin, final int end){
            this.Begin = begin;
            this.End = end;
		}
		@Override
		public int compareTo(final Interval arg0) {
			
			if (this.Begin < arg0.Begin)
			{
				return -1;
            }
            else if (this.Begin == arg0.Begin) {
                return this.End - arg0.End;
            }
			return 1;
		}			
    }

    public int[][] insert(final int[][] intervals, final int[] newInterval) {
        final List<Interval> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        list.add(new Interval(newInterval[0], newInterval[1]));
        Collections.sort(list);
        

        final List<Interval> res = new ArrayList<>();
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).End >= list.get(i+1).Begin) {
                list.get(i+1).End = Math.max(list.get(i).End, list.get(i+1).End); 
                list.get(i+1).Begin = Math.min(list.get(i).Begin, list.get(i+1).End);
                list.get(i).Begin = list.get(i).End = 0;
            } else {
                res.add(list.get(i));
            }
        }

        res.add(list.get(list.size()-1));
        int size = res.size();

        int[][] val = new int[size][2];
        for (int i = 0; i < res.size(); i++) {
            val[i][0] = res.get(i).Begin;
            val[i][1] = res.get(i).End;
        }
        return val;
    }
}