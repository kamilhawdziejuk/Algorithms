import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Graph {
	
	List<Node> visitedDFS = new LinkedList<Node>();
	List<Node> visitedBFS = new LinkedList<Node>();
	
	public int vertices;
    List<Node> nodes = new LinkedList<Node>();
	
    public static List<Node> topologicalSort(Graph graph) {
    	List<Node> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<Node>();
        int vertexProcessesCtr = 0;
        for(Node m : graph.nodes){
            if(m.inDegree==0){
                ++vertexProcessesCtr;
                q.add(m);
                result.add(m);
                //System.out.println(m.data);
            }
        }
        while(!q.isEmpty()) {
            Node m = q.poll();

            for(Node child : m.adj){
                --child.inDegree;
                if(child.inDegree==0){
                    q.add(child);
                    ++vertexProcessesCtr;
                    result.add(child);
                    //System.out.println(child.data);
                }
            }
            	
        }
        return result;
    }
    
    public void dfs(Node root)
    {       
        if(root == null) return;
        visitedDFS.add(root);
        root.isVisited = true;
        for(Node next : root.adj)
        {
            if(!next.isVisited)
            {
                dfs(next);
            }
        }
    }
    
    public void bfs(Node root)
    {
        //Since queue is a interface
        Queue<Node> queue = new LinkedList<Node>();
        if(root == null) return;

        root.isVisited = true;
        queue.add(root);

        while(!queue.isEmpty())
        {
            //removes from front of queue
            Node r = queue.remove(); 
            visitedBFS.add(r);

            //Visit child first before grandchild
            for(Node next: r.adj)
            {
                if(!next.isVisited)
                {
                    queue.add(next);
                    next.isVisited = true;
                }
            }
        }
    }
    
}