package alg.comb;
import java.util.*;
import java.util.stream.Collectors;
import javax.script.*;

public class Combinations {
	
	public static void main(String[] args) throws ScriptException
	{
		String toCalculate = "TAK*TAK=2*TTAAK";
		//String toCalculate = "DIX+NEUF=19*UN";
		int numbers[] = new int[] {0,1,2,3,4,5,7,8};
		new Combinations().CalculateExpression(toCalculate, numbers);
	}
	
	public void CalculateExpression(String toCalculate, int numbers[]) {
		Combinations prog = new Combinations();

		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");		
		List<String> expressions = prog.EnumeratePossibilities(toCalculate, numbers);
		//prog.Print(expressions);
		for (String exp : expressions) {
			String[] parts = exp.split("=");
			String leftValue = null, rightValue = null;
			try {
				leftValue = engine.eval(parts[0]).toString();
				rightValue = engine.eval(parts[1]).toString();

			} catch (ScriptException e) {
				e.printStackTrace();
			}			
			
			int left = Integer.parseInt(leftValue);
			int right = Integer.parseInt(rightValue);
			
			if (left == right) {
				System.out.println(parts[0] + " === " + parts[1]);				
			}
		}
		
		System.out.println("Finished!");
	}
	
	public List<String> EnumeratePossibilities(String value, int tab[]) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : value.toCharArray()) {
			if (!map.containsKey(c)) {
				if (Character.isLetter(c)) {
					map.put(c, 0);					
				}
			}
		}
		
		int size = map.size();		
		Combinations comb = new Combinations();
		List<List<Integer>> list = comb.genAllCombinations(tab, size);		
		List<String> res = new ArrayList<>();
		
		for (List<Integer> l : list) {
			int ind = 0;
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				map.put(entry.getKey(), l.get(ind++)); 
			}
			
			String val = "";
			for (Character c : value.toCharArray()) {
				if (map.containsKey(c)) {
					Integer num = map.get(c);
					val = val + num + "";					
				} else {
					val = val + c + "";
				}
			}
			//System.out.println(val);
			res.add(val);
		}
		return res;
	}
	
	List<List<Integer>> comb = new ArrayList<List<Integer>>();
	
	public void Print(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
		}
	}
	
	public List<List<Integer>> genAllCombinations(int tab[], int expectedSize) {
		comb.clear();
		this.genCombinations(tab, new ArrayList<Integer>(), 0, expectedSize);
		return comb;
	}
	
	private void genCombinations(int tab[], List<Integer> list, int startIndex, int expectedSize) {
		
		if (list.size() == expectedSize) {
			comb.add(list);
			return;
		}
		
		for (int i = 0; i<tab.length; i++) {
			if (!list.contains(tab[i])) {
				List<Integer> list2 = list.stream().collect(Collectors.toList());
				list2.add(tab[i]);
				
				genCombinations(tab, list2, i+1,expectedSize);				
			}
		}
	}
}
