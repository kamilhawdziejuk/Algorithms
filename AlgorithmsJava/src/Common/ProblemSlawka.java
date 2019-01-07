package Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

public class ProblemSlawka {

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
	
	private class Order {
		
		private int _position;
		private List<String> entries = new ArrayList<>();
		
		public Order(int position) {
			_position = position;
		}
		
		public Order(int position, List<String> entriesParam) {
			_position = position;
			entries = new ArrayList<>(entriesParam);
		}
		
		public List<String> GetEntries() {
			return entries;
		}
				
		public void Add(String entry) {
			entries.add(entry);
		}
		
		public int GetPosition() {
			return _position;
		}
		
		public int GetLevel() {
			return entries.size();
		}
		
		public String GetRepresentation() {
			Sort();
			int n = GetLevel();
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < n; i++) {
				buffer.append(entries.get(i));
				if (i < n-1) {
					buffer.append(",");
				}
			}
			return buffer.toString();
		}
		
		public void Sort() {
			Collections.sort(entries);
		}
	}
	
	
	public static void main(String[] args) {
		
		List<Order> orders;
		ProblemSlawka problem = new ProblemSlawka();
		//problem.PrepareData();
		//List<Order> orders = problem.PrepareData();
		
		orders = problem.ReadAndBuildOrdersStructure("D:/ProblemSlawka/ProblemSlawka.csv");		
		List<Order> ordersToAnalyze = problem.Prepare(orders, 4, 156);		
		Map<String, Integer> result = problem.Calc(ordersToAnalyze, 4);
		problem.SaveToFile(result, "D:/ProblemSlawka/Output4.txt");
		
		int test = 5;
	}
	
	private void SaveToFile(Map<String, Integer> result, String fileName) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(fileName, "UTF-8");			
			
			for (Map.Entry<String, Integer> entry : result.entrySet())
			{
				String key = entry.getKey();
				Integer value = entry.getValue();
				
				if (value > 1) {
					writer.println(key + "  " + value + " times");
				}			
			}				
						
			writer.close();	
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}
	
	private List<Order> PrepareData() {
		List<Order> orders = new ArrayList<>();
		Order order1 = new Order(1);
		order1.Add("1");
		order1.Add("2");
		order1.Add("3");
		order1.Add("4");
		order1.Add("5");

		this.GetSubsets(order1.GetEntries(),3);

		
		Order order2 = new Order(2);
		order2.Add("3");
		order2.Add("10");
	
		Order order3 = new Order(3);
		order3.Add("10");
		order3.Add("10");
		order3.Add("15");
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		return orders;
	}
	
	private List<Order> Prepare(List<Order> orders, int levelExpected, int maxLevel) {
		List<Order> results = new ArrayList<>();
		for (Order order : orders) {
			order.Sort();
			int level = order.GetLevel();
			if (level == levelExpected) {
				results.add(order);
			}
			else if (level > levelExpected && level <= maxLevel) {
				
				List<List<String>> entriesSplit = GetSubsets(order.GetEntries(), levelExpected);
				for (List<String> entryList : entriesSplit) {
					Order nextOrder = new Order(order.GetPosition(), entryList);
					results.add(nextOrder);
				}
			}
			else if (level > maxLevel) {
				System.out.println(level);
			}
		}
		return results;
	}
	
	private Map<String, Integer> Calc(List<Order> orders, int levelExpected) {
		Map<String, Integer> map = new HashMap<>();
		System.out.println("Orders:" + orders.size());
		for (Order order : orders) {
			int level = order.GetLevel();
			if (level == levelExpected) {
				String key = order.GetRepresentation();
				if (map.containsKey(key)) {
					map.put(key, map.get(key)+1);
				}
				else {
					map.put(key, 1);
				}				
			}
		}
		map = sortByValue( map );
		return map;
	}
	
	private List<List<String>> GetSubsets(List<String> entries, int sizeExpected) {
		List<List<String>> results = new ArrayList<>();
		List<String> current = new ArrayList<>();
		GenerateSubsets(entries, current, sizeExpected, 0, results);
		return results;
	}
	
	private void GenerateSubsets(List<String> entries, List<String> current, int sizeExpected, int pos, List<List<String>> results) {
		if (current.size() == sizeExpected) {
			results.add(current);
		}
		else {
			for (int i = pos; i < entries.size(); i++) {
				List<String> next = new ArrayList<>(current);
				String elem = entries.get(i);
				next.add(elem);
				GenerateSubsets(entries, next, sizeExpected, i+1, results);
			}
		}
	}
	
	
	private int Find(List<Order> orders, int position) {
		if (orders.isEmpty()) {
			return -1;
		}
		else {
			for (int i = 0; i < orders.size(); i++) {
				Order order = orders.get(i);
				if (order.GetPosition() == position) {
					return i;
				}
			}
			return -1;
		}
	}
	
	private List<Order> ReadAndBuildOrdersStructure(String filePath) {
    			
		List<Order> orders = new ArrayList<>();
		
		try {
			FileInputStream fileStream = new FileInputStream(filePath);
			Scanner in = new Scanner(fileStream);
			in.nextLine();//header
			String line;
		
			while (in.hasNextLine()) {
				line = in.nextLine();
				String[] data = line.split(",");
				int position = Integer.parseInt(data[1]);
				String val = data[0];//Integer.parseInt(data[0]);
				
				int orderPosition = this.Find(orders, position);
				Order order;
				if (orderPosition == -1) {
					order = new Order(position);
					order.Add(val);
					orders.add(order);
				}
				else {
					orders.get(orderPosition).Add(val);
				}
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
	
}