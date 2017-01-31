package LeetCode;

//https://leetcode.com/problems/evaluate-division/
/*
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 *  and k is a real number (floating point number). Given some queries, return the answers.
 *   If the answer does not exist, return -1.0. 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class EvaluateDivision {
    
	Map<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
	Map<String, Boolean> visited = new HashMap<String, Boolean>();
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		
		Map<String, Double> edges = new HashMap<String, Double>();
		int n = equations.length;
		
		for (int i = 0; i < n; i++)
		{
			String[] str = equations[i];
			String eq = str[0] + "/" + str[1];
			
			if (!graph.containsKey(str[0]))
			{				
				ArrayList<String> list = new ArrayList<String>();
				list.add(str[1]);
				graph.put(str[0], list);
			}
			else
			{
				ArrayList<String> list = graph.get(str[0]);
				list.add(str[1]);
				graph.put(str[0], list);
			}
			if (!graph.containsKey(str[1]))
			{				
				ArrayList<String> list = new ArrayList<String>();
				list.add(str[0]);
				graph.put(str[1], list);
			}
			else
			{
				ArrayList<String> list = graph.get(str[1]);
				list.add(str[0]);
				graph.put(str[1], list);
			}
			
			visited.put(str[0], false);
			visited.put(str[1], false);
			
			double  val = values[i];
			String eq2 = str[1] + "/" + str[0];			
			if (!edges.containsKey(eq))
			{
				edges.put(eq, val);				
			}
			if (!edges.containsKey(eq2))
			{
				edges.put(eq2, 1.0 / val);				
			}
		}
		
		int m = queries.length;
		double[] result = new double[m];
		for (int i = 0; i < m; i++)
		{
			String[] query = queries[i]; 
			String a = query[0];
			String b = query[1];
			Map<String, String> path = null;
			
	    	if (!graph.containsKey(a) || !graph.containsKey(b))
	    	{
	    		result[i] = -1.0;
	    	}
	    	else if (a == b)
	    	{
	    		result[i] = 1.0;
	    	}
	    	else
	    	{
	    		path = bfs(query);	    		    
				if (path == null)
				{
					result[i] = -1.0;
				}
				else
				{
					double multiplication = 1;
					for (Map.Entry<String, String> entry : path.entrySet())
					{
						String edge = entry.getKey() + "/" + entry.getValue();
						double factor = edges.get(edge);
						multiplication *= factor;
					}
					result[i] = multiplication;
				}
	    	}
		}
		
        return result;
    }
	
    private Map<String, String> bfs(String[] query)
    {
    	String a = query[0];
    	String b = query[1];    	    
    	
    	Map<String, String> path = new HashMap<String, String>();
    	
		for (String entry : visited.keySet())
		{
			visited.put(entry, false);
		}
		    	
        Queue<String> queue = new LinkedList<String>();
        if(query == null) return null;
        
        queue.add(a);

        while(!queue.isEmpty())
        {
            //removes from front of queue
            String r = queue.remove(); 
            visited.put(r, true);

            for(String n: graph.get(r))
            {
            	if (!visited.get(n))
            	{
                    queue.add(n);
                    path.put(r, n);
                    visited.put(n, true);
                    
                    if (n == b)
                    {
                    	return path;
                    }
                }
            }
        }
        
        return null;
    }
}
