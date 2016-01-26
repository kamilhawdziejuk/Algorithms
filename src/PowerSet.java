import java.util.HashSet;
import java.util.Set;

public class PowerSet {

	public static void main(String[] args)
	{
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		GenerateSubsets(set);
	}
	
	public static void Print(Set<Integer> set)
	{
		for (Integer elem : set)
		{
			System.out.print(elem);
		}
		System.out.println();
	}
	
	public static Set<Set<Integer>> GenerateSubsets(Set<Integer> set)
	{
		Set<Set<Integer>> results = new HashSet<Set<Integer>>();
		int n = set.size();
		int amount = (int) Math.pow(2, n);
		for (int nr = 0; nr < amount; nr++)
		{
			String data = Integer.toBinaryString(nr);
			int length = data.length();
			Set<Integer> result = new HashSet<Integer>();
			int i = 0;
			for (Integer elem : set)
			{
				if (i >= length) break;
				if (data.charAt(length-i-1) == '1')
				{
					result.add(elem);
				}
				i++;
			}
			//Print(result);
			results.add(result);
		}
		return results;
	}
}
