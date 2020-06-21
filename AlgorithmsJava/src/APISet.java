import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.TreeSet;

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

		TreeSet<Integer> tree  = new TreeSet<>();
		tree.lower(3); //returns the closest lower thatn 3
		tree.higher(5);//returns the closest higher than 5

		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new HashSet<>();
		Set<Integer> s3 = new HashSet<>();

		Set<Integer> union = new HashSet<Integer>(s1);
		union.addAll(s2);

		Set<Integer> intersection = new HashSet<Integer>(s1);
		intersection.retainAll(s2);

		Set<Integer> difference = new HashSet<Integer>(s1);
		difference.removeAll(s2);
	}    
}