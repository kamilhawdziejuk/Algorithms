package LeetCode;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {

	public static void main(String[] args) {
		CourseSchedule pro = new CourseSchedule();
	}
	
	class Node {
	    public int data;
	    public int inDegree;
	    public boolean isVisited = false;
	    public boolean isBeingVisited = false;
	    public LinkedList<Node> adj = new LinkedList<Node>( );

	    public void addAdjNode(final Node Child){
	    	adj.add(Child);
	        Child.inDegree++;
	    }

	    public Node(int data) {
	        super();
	        this.data = data;
	    }
	}
	
	public class Graph {
		
	    List<Node> nodes = new LinkedList<Node>();
		
	    private boolean hasCycle(Node sourceVertex) {
	        sourceVertex.isBeingVisited = true;
	     
	        for (Node neighbor : sourceVertex.adj) {
	            if (neighbor.isBeingVisited) {
	                // backward edge exists
	                return true;
	            } else if (!neighbor.isVisited && hasCycle(neighbor)) {
	                return true;
	            }
	        }
	     
	        sourceVertex.isBeingVisited = false;;
	        sourceVertex.isVisited = true;
	        return false;
	    }
	    
	    public boolean hasCycle() {
	        for (Node vertex : this.nodes) {
	            if (!vertex.isVisited && hasCycle(vertex)) {
	                return true;
	            }
	        }
	        return false;
	    }
	}
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	Graph g = new Graph();
    	for (int i = 0; i < numCourses; i++) {
    		g.nodes.add(new Node(i));
    	}
    	for (int i = 0; i < prerequisites.length; i++) {
    		int prev = prerequisites[i][1];
    		int next = prerequisites[i][0];
    		g.nodes.get(prev).addAdjNode(g.nodes.get(next));
    	}
    	boolean hasCycle = g.hasCycle();
        return !hasCycle;
    }

}
