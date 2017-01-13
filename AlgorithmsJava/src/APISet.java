import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class APISet {
	
	public Set<String> set = new HashSet<>();
	public int[] tab = new int[1000];
	
	public void setManipulate()
	{
		set.add("elem1");
		set.add("elem1");
		set.add("elem2");
		
		boolean isElem1 = set.contains("elem1");
		set.remove("elem2");
		for (String elem : set)
		{
		}
	}    
}