import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;

public class APIQueue {
	
	class IncComparator implements Comparator<Integer>
	{
	    @Override
	    public int compare(Integer x, Integer y)
	    {
	        if (x == y) return 0;
	        if (x < y) return -1;
	        return 1;
	    }
	}
	
	Queue<Integer> q;
	
	public static void main(String[] args) {
		APIQueue sol = new APIQueue();
		sol.Test();
	}
	
	public void Test()
	{
		Queue<Integer> q = new PriorityQueue<>(new IncComparator());
		
		q.offer(4);
		q.offer(3);
		q.offer(3);

		boolean is = q.contains(4);
		int a = q.poll(); //retrieves and removes the head!
		int b = q.peek(); //retrieves the head
		
		String s;
		q.offer(4); //insert
	}
}
