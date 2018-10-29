package LeetCode;

import java.util.*;


public class EvaluateDivision2 {
    
	class Edge {
		public final Node target;
	    public final double weight;
	    public Edge(Node argTarget, double argWeight)
	    { 
	    	target = argTarget; weight = argWeight; 
	    }
	    
	    @Override
	    public boolean equals(Object obj) {
	    	return this.target.equals(((Edge) obj).target);
	    }
	}

	class Node implements Comparable<Node> {
		public String data;
		public List<Edge> adj = new LinkedList<Edge>( );
    
		public void add(final Edge Child){
			adj.add(Child);
		}

	    public Node(String data) {
	        super();
	        this.data = data;
	    }
	    
	    @Override
	    public boolean equals(Object obj) { //needed for list.contains
	    	        return this.data.equals(((Node) obj).data);
	    }
	
		@Override
		public int compareTo(Node arg0) { //needed for map.conainsKey
			if (data.equals(arg0.data)) {
				return 0;
			}
			// TODO Auto-generated method stub
			return -1;
		}
		
		@Override
	    public int hashCode() { //needed for map.containsKey
	        return this.data.hashCode();
	    }
	}

	List<Node> list = new LinkedList<Node>();

	private void build(String[][] equations, double[] values)
	{
		int n = values.length;
		
		//build:
		for (int i = 0 ; i < n; i++) {
			String a = equations[i][0];
			String b = equations[i][1];
			
			Node node_a = new Node(a);
			Node node_b = new Node(b);
			
			Edge edge_b = new Edge(node_b, values[i]);
			Edge edge_a = new Edge(node_a, 1/values[i]);
	
			if (!list.contains(node_a)) {	
				list.add(node_a);
			}
			
			int indexa = list.indexOf(node_a);
			if (!list.get(indexa).adj.contains((Edge)edge_b)) {
				list.get(indexa).adj.add(edge_b);
			}
	
			if (!list.contains(node_b)) {
				list.add(node_b);
			}
			
			int indexb = list.indexOf(node_b);
			if (!list.get(indexb).adj.contains((Edge)edge_a)) {
				list.get(indexb).adj.add(edge_a);
			}
		}
	
	}
	
	private double find(String a, String b) {
				
		Node node_a = new Node(a);
		Node node_b = new Node(b);
		
		if (!list.contains(node_a)) {
			return -1;
		}
		
		Map<Node, Double> map = new HashMap<>();
		Stack<Node> stack = new Stack<>();
		
		int index = list.indexOf(node_a);
		Node node = list.get(index);
		
		stack.push(node);
	    map.put(node, 1.0);
		
		while (!stack.isEmpty()) {
		
			Node top0 = stack.pop();
	        Node top = list.get(list.indexOf(top0));
	        
	        
			if (top.equals(node_b)) {
				return map.get(top);
			}
			
			double fact = 1;
			if (map.containsKey(top)) {
				fact = map.get(top);
			}
			else {
				map.put(top, fact);
			}
			
			for (Edge edge : top.adj) {
				if (map.containsKey((Node)edge.target)) {
					continue;
				}
				map.put(edge.target, edge.weight * fact);
				stack.push(edge.target);
			}
		}
				
		return -1;
	}
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		build(equations, values);
				
		int n = queries.length;
		double[] res = new double[n];
		for (int i = 0; i < n; i++) {
			String a = queries[i][0];
			String b = queries[i][1];
			
			double ab = find(a,b);
			res[i] = ab;
			
		}
		
		return res;    
	}
}