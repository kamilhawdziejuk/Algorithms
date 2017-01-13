package HackerRank;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class TheValueOfFriendship {

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	    return map.entrySet()
	              .stream()
	              .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}
	
	public class Pair
	{
		public int a,b;
		public Pair(int _a, int _b)
		{
			a = _a;
			b = _b;
		}
	}
	
	Scanner in;
	int q;
	int n;
	int m;
	int nums[]; //visited
	ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //ile elementow ma graf
	Map<Integer, Integer> edgesAmountMap = new HashMap<Integer, Integer>(); //ile krawedzi ma graf key	
	Map<Integer, BigInteger> data = new HashMap<Integer, BigInteger>(); //ile krawedzi ma graf key
	
	BigInteger total = BigInteger.ZERO;
	BigInteger over = BigInteger.ZERO;
	
	public long Calc()
	{
        n = in.nextInt();
        m = in.nextInt();
        
        nums = new int[n+1];
        graph.clear();        
        map.clear();
        edgesAmountMap.clear();
        
        List<Pair> pairs = new ArrayList<Pair>();
        total = BigInteger.ZERO;
        over = BigInteger.ZERO;
        
        for (int i = 0; i <= n; i++)
        {
        	nums[i] = 0;
        	graph.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < m; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
  
            pairs.add(new Pair(a,b));
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int nr = 0;
        for (int i = 1; i <= n; i++)
        {
        	if (nums[i] == 0)
        	{
        		nr++;
        		
        		Queue<Integer> queue = new LinkedList<Integer>();        		
        		queue.add(i);
    
        		int cnt = 1;
        		        		
        		while(!queue.isEmpty())
    	        {
        			int elem = queue.remove();
    	            nums[elem] = nr; 
    	                	            
    	            for(Integer next : graph.get(elem))
    	            {
    	            	if (nums[next] == 0) //not visited
    	            	{
    	            		queue.add(next);
    	            		nums[next] = nr;
    	            		cnt++;
    	            	}
    	            }
    	        }        		
        		map.put(nr, cnt);
        	}        	
        }
        
        for (int i = 0; i < m; i++)
        {
        	Pair pair = pairs.get(i);
        	int a = pair.a;
        	int b = pair.b;
        	int num = nums[a];
        	if (edgesAmountMap.containsKey(num))
        	{
        		edgesAmountMap.put(num, edgesAmountMap.get(num)+1);
        	}
        	else
        	{
        		edgesAmountMap.put(num,  1);
        	}
        }
        
        for (Map.Entry<Integer, Integer> entry : edgesAmountMap.entrySet()) 
        {
        	int key = entry.getKey();
        	int edgesAmount = entry.getValue();
        	int nodesAmount = map.get(key);   
        	over = over.add(BigInteger.valueOf(edgesAmount +1 - nodesAmount));
        }
        
        map = sortByValue( map );
        BigInteger total_current = BigInteger.ZERO;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	int nodesAmount = entry.getValue();
        	if (nodesAmount > 1)
        	{
        		BigInteger nodesAmount_1 = BigInteger.valueOf(nodesAmount-1);        		
        		BigInteger total2 = nodesAmount_1.multiply(total_current);
        		BigInteger maxim = Maxim(nodesAmount);
        		total_current = total_current.add(maxim);
        		BigInteger sum2 = Sum(nodesAmount);
        		total = total.add(total2).add(sum2);
        	}
        }
        
        long longOver = over.longValue();
        for (Long i = 0L; i < longOver; i++)
        {
        	total = total.add(total_current);
        }
        
     	System.out.println(total);
                
		return 0;
	}
		
	public BigInteger Sum(int k)
	{
		if (data.containsKey(k))
		{
			return data.get(k);
		}
		
		BigInteger maxim = BigInteger.ZERO;
		BigInteger sum = BigInteger.ZERO;
		if (k <= 1) return BigInteger.ZERO;
		for (int i = 2; i <= k; i++)
		{
			maxim = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i-1));
			sum = sum.add(maxim);
		}
		
		data.put(k, sum);
		
		return sum;
	}
	public BigInteger Maxim(int k)
	{
		if (k <= 1) return BigInteger.ZERO;
		return BigInteger.valueOf(k).multiply(BigInteger.valueOf(k-1));
	}
	
    public void Solve()
    {    	
        in = new Scanner(System.in);
        q = in.nextInt();
        for (int i = 0; i < q; i++)
        {
        	Calc();
        }                        
    }
     
    public static void main(String[] args) {
    	
    	TheValueOfFriendship sol = new TheValueOfFriendship();
    	sol.Solve();		
    	
    }    	                    
}