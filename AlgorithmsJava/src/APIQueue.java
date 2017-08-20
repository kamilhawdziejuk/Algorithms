import java.util.PriorityQueue;
import java.util.Queue;

public class APIQueue {
	Queue<Integer> q = new PriorityQueue<>();
	
	public void Test()
	{
		int a = q.poll(); //retrieves and removes the head!
		int b = q.peek(); //retrieves the head
		
		q.offer(4); //insert
	}
}
