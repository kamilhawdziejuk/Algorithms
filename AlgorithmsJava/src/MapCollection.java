import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class MapCollection {
	
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
		
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			String key = entry.getKey();
			Integer value = entry.getValue();
		}		
	}
		
}