import java.util.ArrayList;
import java.util.List;

public class GraphCycle {
	
	boolean[] marked;
	boolean[] onStack;
	int N;
	
	List<Integer>[] graph;
	
	public void initialize()
	{
		N = 100;
		marked = new boolean[N];
		onStack = new boolean[N];
		graph = (List<Integer>[]) new List[N];		
	}
	
	public void manipulate()
	{
		int key = 0;
		int item = 2;
		if(graph[key] == null) 
		{
			graph[key] = new ArrayList<Integer>();
		}
        graph[key].add(item);		
	}
	
	//dfs
	public boolean hasCycle(int vertex, List<Integer>[] g){
	    marked[vertex] = true;
	    onStack[vertex] = true;
	    boolean hasCycle = false;
	    if(g[vertex] != null){
	        for(int w: g[vertex]){
	            if(!marked[w]) {
	                hasCycle = hasCycle(w, g);
	                if(hasCycle == true) break;
	            }
	            else if(onStack[w]==true) {
	                hasCycle = true;
	                break;
	            }
	        }
	    }
	    onStack[vertex] = false;
	    return hasCycle;
	}
}
