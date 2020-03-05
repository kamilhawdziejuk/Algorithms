package alg.comb;
import java.util.*;
import java.util.stream.Collectors;
import javax.script.*;

public class Combinations {
	
	public static void main(String[] args) throws ScriptException
	{
		String toCalculate = "";
		toCalculate = "TAK*TAK=2*TTAAK";
		toCalculate = "DIX+NEUF=19*UN";
		//toCalculate = "6*aaa+7*a=2019";
		Combinations comb = new Combinations();
		int numbers[] = new int[] {0,1,2,3,4,5,7,8};
		//comb.CalculateExpression(toCalculate, numbers);
		//comb.Calculate3DigitsNumberCondition();
		//comb.CalculateFunctionNumbers();

		int numbs[] = new int[] {13,14,15,16,17,18};
		comb.FindNumbersSequenceThat(numbs);
	}

	//find numbers sequence that fulfills condition
	public void FindNumbersSequenceThat(int[] numbs) {
		List<List<Integer>> list = new Combinations().genAllCombinations(numbs, 6);
		for (int i = 0; i < list.size(); i++) {
			
			if (this.CheckCondition(list.get(i))) {
				this.PrintList(list.get(i));
			}
		}
	}
	
	private boolean CheckCondition(List<Integer> list) {
		int a = list.get(0);
		int b = list.get(1);
		int c = list.get(2);
		int d = list.get(3);
		int e = list.get(4);
		int f = list.get(5);
		
		int A = 20+a+b+12;
		int B = 12+c+19+d;
		int C = 20+f+e+d;
		
		if (A != B || B != C || A != C) {
			return false;
		}
		if (a < b) return false;
		if (f > e) return false;
		
		return true;
		
	}
	
	private void PrintList(List<Integer> list) {
		for (int j = 0; j < list.size(); j++) {
			System.out.print(" " + list.get(j));
		}
		System.out.println();
	}
	
	//eg. find abc such as..
	public void Calculate3DigitsNumberCondition() {
		for (int number = 100; number <= 999; number++) {
			
			int a = number/100;
			int b = (number - a*100) / 10;
			int c = number - 100*a - 10*b;
			
			if (a != c) {
				int kwadrat = number * number;
				String kwadratStr = Integer.toString(kwadrat);
				String kwadratStrRev = new StringBuilder(kwadratStr).reverse().toString();
				
				String numberRev = new StringBuilder(Integer.toString(number)).reverse().toString();
				int numberRevInt = Integer.parseInt(numberRev);
				int kwadrat2 = numberRevInt * numberRevInt;
				String kwadrat2Rev = Integer.toString(kwadrat2);
				
				if (kwadrat2Rev.contains(kwadratStrRev)) {
					System.out.println(number);
				}
			}
			
		}
	}
	
	//eg. find a,b,c such as ...(20/19 = (a^3+b^3/a^c + c^3)
	public void CalculateFunctionNumbers() {
		for (int a = 1; a < 50; a++) {
			for (int b = 1; b < 50; b++) {
				for (int c = 1; c < 50; c++) {
					
					//replace it!
					int left = 20 * (a*a*a + c*c*c);
					int right = 19 * (a*a*a + b*b*b);
					
					if (left == right) {
						System.out.println("(a, b, c)= (" + a + ", " + b + ", " + c +")");
					}
				}
			}
		}
	}
	
	//eg. find numbers that if we replace letters by them calculation makes happen
	//toCalculate = "TAK*TAK=2*TTAAK";
	//toCalculate = "DIX+NEUF=19*UN";
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
