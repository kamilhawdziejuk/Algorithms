import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GraphWeighten {
		
	public int vertices;
    List<Vertex> nodes = new LinkedList<Vertex>();
    
    private static int cost = 0;
    private static Set<Edge> path = null;
    private static List<Vertex> unvisited = null;
    private static Queue<Edge> edgesAvailable = new PriorityQueue<Edge>();;
    
    public static Set<Edge> getMinimumSpanningTree(GraphWeighten graph, Vertex start) {
        if (graph == null)
            throw (new NullPointerException("Graph must be non-NULL."));

        // Reset variables
        cost = 0;
        path = null;
        unvisited = null;
        edgesAvailable = null;

        // Prim's algorithm only works on undirected graphs
        path = new LinkedHashSet<Edge>();

        unvisited = new ArrayList<Vertex>();
        unvisited.addAll(graph.nodes);
        unvisited.remove(start);

        edgesAvailable = new PriorityQueue<Edge>();

        Vertex vertex = start;
        while (!unvisited.isEmpty()) {
            for (Edge e : vertex.adjacencies) {
                if (unvisited.contains(e.target))
                    edgesAvailable.add(e);
            }

            Edge e = edgesAvailable.remove();
            cost += e.weight;
            path.add(e);

            vertex = e.target;
            unvisited.remove(vertex);
        }

        return path;
    }
}
