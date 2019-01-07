package Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		//List<Order> orders = problem.PrepareData();
		
		orders = problem.ReadAndBuildOrdersStructure("D:/ProblemSlawka/ProblemSlawka.csv");
		Map<String, Integer> result = problem.Calc(orders, 3);
		int test = 5;
	}
	
	private List<Order> PrepareData() {
		List<Order> orders = new ArrayList<>();
		Order order1 = new Order(1);
		order1.Add("10");
		order1.Add("15");
		order1.Add("10");
		
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
	
	private Map<String, Integer> Calc(List<Order> orders, int levelExpected) {
		Map<String, Integer> map = new HashMap<>();
		for (Order order : orders) {
			if (order.GetLevel() == levelExpected) {
				String key = order.GetRepresentation();
				if (map.containsKey(key)) {
					map.put(key, map.get(key)+1);
				}
				else {
					map.put(key, 1);
				}				
			}
			else if (order.GetLevel() > levelExpected) {
				System.out.println(order.GetLevel());
			}
		}
		map = sortByValue( map );
		return map;
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