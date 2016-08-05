import java.util.LinkedList;

public class Node {
    public String data;
    public int dist;
    public int inDegree;
    public boolean isVisited = false;
    LinkedList<Node> adj = new LinkedList<Node>( );

    public void addAdjNode(final Node Child){
    	adj.add(Child);
        Child.inDegree++;
    }

    public Node(String data) {
        super();
        this.data = data;
    }
}