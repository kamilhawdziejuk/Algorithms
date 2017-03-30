package HackerRank;

import java.util.*;

public class BFSShortestReachInAGraph {
	
	Scanner in = new Scanner(System.in);
	int q;
	int n;
	int m;
	int s;
	private List<List<Integer>> graph;
	private int results[];
	private int visited[];
	
	private void ReadQ()
	{
		q = in.nextInt();
	}
	
	private void ReadGraph()
	{        
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<List<Integer>>();
        results = new int[n];
        visited = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        for (int i = 0; i < n; i++) visited[i] = 0;
        
        for (int i = 0; i < m; i++)
        {
        	int a = in.nextInt();
        	int b = in.nextInt();
        	graph.get(a-1).add(b-1);
        }
        
        s = in.nextInt()-1;
	}
	
	private void CalcGraph()
	{
		bfs(s);
		for (int i = 0; i < n; i++)
		{
			if (i != s)
			{
				int dist = visited[i] == 0 ? -1 : 6 * visited[i];
				System.out.print(dist + " ");
			}
		}
		System.out.println();
	}
	
	private void bfs(int root)
    {
        //Since queue is a interface
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[root] = 0;
        
        queue.add(root);

        while(!queue.isEmpty())
        {
            //removes from front of queue
            int r = queue.remove();
            //Visit child first before grandchild
            for(Integer next : graph.get(r))
            {
                if(visited[next] == 0)
                {
                    queue.add(next);
                    visited[next] = visited[r]+1;
                }
            }
        }
    }
	
    public static void main(String[] args) {
    	BFSShortestReachInAGraph sol = new BFSShortestReachInAGraph();
    	sol.ReadQ();
    	
        for (int i = 0; i < sol.q; i++)
        {
        	sol.ReadGraph();
        	sol.CalcGraph();
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
	
}
