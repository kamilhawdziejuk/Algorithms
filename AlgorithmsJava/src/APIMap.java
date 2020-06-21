import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class APIMap {
	
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
	
	public static void main(String[] args) {
		
		TreeMap<String, Integer> map = new TreeMap<>();
	}
		
	public void SortByKey(Map<Integer,Integer> map, boolean desc) {
		
		TreeSet<Integer> keys = new TreeSet<>(map.keySet());		
		if (desc) {
			keys = (TreeSet)keys.descendingSet();
		}       
        //for (Integer nr : keys) {}
	}
	
	
	private static Comparator<Map.Entry<Integer, String>> ValueComparator  = new Comparator<Map.Entry<Integer, String>>() {
        @Override
        public int compare(
          Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
	};
	
	private static Comparator<Map.Entry<Integer, String>> KeyComparator  = new Comparator<Map.Entry<Integer, String>>() {
        @Override
        public int compare(
          Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
            return o1.getKey().compareTo(o2.getKey());
        }
	};
	
	public void SortByKey(Map<Integer, String> map) {
		 
	    List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());    
	    Collections.sort(entries, KeyComparator);	    
	    Map<Integer, String> sortedMap = new LinkedHashMap<>();
	    for (Map.Entry<Integer, String> entry : entries) {
	        sortedMap.put(entry.getKey(), entry.getValue());
	    }
	}
	
	public void SortByValue(Map<Integer, String> map) {
	 
	    List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());    
	    Collections.sort(entries, ValueComparator);	    
	    Map<Integer, String> sortedMap = new LinkedHashMap<>();
	    for (Map.Entry<Integer, String> entry : entries) {
	        sortedMap.put(entry.getKey(), entry.getValue());
	    }
	}
	
	public Map<String, Integer> map = new HashMap<>();
	
	public void mapManipulate()
	{
		map.put("klucz", 2);
		if (map.containsKey("klucz"))
		{
			map.put("klucz", 22);			
		}
		
		map.remove("klucz2");
		map.remove("klucz", 3);
		
		boolean contains22 = map.containsValue(22);
		
		boolean isEmpty = map.isEmpty();
		
		int size = map.size();
		
		for (String entry : map.keySet())
		{
			Integer value = map.get(entry);
		}

		map.values();
		
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			String key = entry.getKey();
			Integer value = entry.getValue();
		}		
		
		
		//sort by value:
		map = sortByValue( map );
	}
		
}