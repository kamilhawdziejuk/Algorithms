import java.util.*;


public class Edge implements Comparable<Edge>
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
    
    @Override
    public int compareTo(Edge e) {
        if (this.weight < e.weight)
            return -1;
        if (this.weight > e.weight)
            return 1;
        return 0;
    }
}