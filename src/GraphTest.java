import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;


public class GraphTest {

	  Graph g;
	 
	  @Before
	  public void setUp() throws Exception {
		  
		    g = new Graph();
		    g.vertices=8;

		    Node TEN = new Node("10");
		    Node ELEVEN = new Node("11");
		    Node TWO = new Node("2");
		    Node THREE = new Node("3");
		    Node FIVE = new Node("5");
		    Node SEVEN = new Node("7");
		    Node EIGHT = new Node("8");
		    Node NINE = new Node("9");

		    SEVEN.adj.add(ELEVEN);
		    ELEVEN.inDegree++;
		    SEVEN.adj.add(EIGHT);
		    EIGHT.inDegree++;
		    FIVE.adj.add(ELEVEN);
		    ELEVEN.inDegree++;
		    THREE.adj.add(EIGHT);
		    EIGHT.inDegree++;
		    THREE.adj.add(TEN);
		    TEN.inDegree++;
		    ELEVEN.adj.add(TEN);
		    TEN.inDegree++;
		    ELEVEN.adj.add(TWO);
		    TWO.inDegree++;
		    ELEVEN.adj.add(NINE);
		    NINE.inDegree++;    
		    EIGHT.adj.add(NINE);
		    NINE.inDegree++;    

		    g.nodes.add(TWO);
		    g.nodes.add(THREE);
		    g.nodes.add(FIVE);
		    g.nodes.add(SEVEN);
		    g.nodes.add(EIGHT);
		    g.nodes.add(NINE);
	  }
	
	@Test
	public void test() {
		List<Node> res = Graph.topologicalSort(g);
	}

}
