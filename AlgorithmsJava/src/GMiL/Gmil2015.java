package GMiL;

import java.util.*;
import java.util.stream.Collectors;

import alg.comb.*;

public class Gmil2015 {

	public static void main(String[] args) {
		Gmil2015 pro = new Gmil2015();
		// pro.Zad15();
		//pro.Zad14();
		//pro.Zad10();
		//pro.Zad13();
		pro.Zad11();
	}

	public void Zad14() {

		int liczba = 100000;
		for (int i = 175; i <= 999; i++) {

			int wyn = liczba / i;

			List<Integer> dzielnik = this.getDigits(i);
			List<Integer> iloraz = this.getDigits(wyn);

			if (dzielnik.size() != iloraz.size())
				continue;

			int n = dzielnik.size();

			boolean found = true;
			for (int j = 0; j < n; j++) {
				if (dzielnik.get(j) != iloraz.get(n - j - 1)) {
					found = false;
				}
			}
			if (found)
				System.out.println(i);

		}
	}

	public void Zad13() {
		for (int n = 2015; n <= 99999; n++) {

			int wn = Weight(n);

			int k = n - wn;

			int wk = Weight(k);

			if (k - wk == 2015) {
				System.out.println(n);
			}
		}
	}

	public List<Integer> getDigits(int n) {
		List<Integer> results = new ArrayList<>();
		String s = Integer.toString(n);
		for (int i = 0; i < s.length(); i++) {
			results.add(Integer.parseInt(s.charAt(i) + ""));
		}
		return results;
	}

	public int Weight(int liczba) {
		int sum = 0;
		List<Integer> list = getDigits(liczba);
		for (Integer i : getDigits(liczba)) {
			sum += this.Weight0(i);
		}
		return sum;
	}

	public int Weight0(int cyfra) {
		if (cyfra == 0)
			return 6;
		if (cyfra == 1)
			return 2;
		if (cyfra == 2)
			return 5;
		if (cyfra == 3)
			return 5;
		if (cyfra == 4)
			return 4;
		if (cyfra == 5)
			return 5;
		if (cyfra == 6)
			return 6;
		if (cyfra == 7)
			return 3;
		if (cyfra == 8)
			return 7;
		if (cyfra == 9)
			return 6;
		return 0;
	}

	public void Zad10() {
		int m = 0;
		for (int a = 1; a <= 9; a++) {
			for (int b = 0; b <= 9; b++) {

				int liczba = 10 * a + b;
				int suma = a + b;

				int wynik = liczba / suma;
				int reszta = liczba - wynik * suma;
				m = Math.max(m, reszta);
				System.out.println(reszta);
			}
		}
		System.out.println(m);
	}

	public void Zad11() {
		int numbs[] = new int[] { 5, 7, 8, 9, 10, 11, 12, 13, 15, 16, 18 };
		List<List<Integer>> ya = new ArrayList<List<Integer>>();
		List<List<Integer>> de = new ArrayList<List<Integer>>();
		List<List<Integer>> gh = new ArrayList<List<Integer>>();
		List<List<Integer>> cxf = this.FindNumbersSequenceThat(numbs, 3, 43 - 3 - 6);
		

		for (List<Integer> list :  this.FindNumbersSequenceThat(numbs, 2, 43 - 21)) {
			ya.addAll(new Permutations().generatePerm(list));
		}
		
		for (List<Integer> list :  this.FindNumbersSequenceThat(numbs, 2, 43 - 20)) {
			de.addAll(new Permutations().generatePerm(list));
		}
		
		for (List<Integer> list :  this.FindNumbersSequenceThat(numbs, 2, 43 - 2 - 14)) {
			gh.addAll(new Permutations().generatePerm(list));
		}
		
		
		// b = 43-a-d;
		// z = 24-h

		for (List<Integer> ya1 : ya) {

			Set<Integer> set = new HashSet<>();
			set.addAll(List.of(0,1,2,3,4,6,17,19));		
			set.addAll(ya1);//15,7

			for (List<Integer> de1 : de) {

				if (Has(set, de1))
					continue;
				set.addAll(de1);//18,5

				for (List<Integer> gh1 : gh) {

					if (Has(set, gh1))
						continue;
					set.addAll(gh1);//11,16

					for (List<Integer> cxf1 : cxf) 
					{
						
							int b = 43 - ya1.get(0) - de1.get(0);
							int z = 24 - gh1.get(1);
							int h = gh1.get(1);
							int y = ya1.get(0);
							int d = de1.get(0);
							
							
							if (y+b+d != 43) continue;
							if (z+h+19 != 43) continue;
							
							if (b <= 4 || b >= 19 || z <= 4 || z >= 19 || b == z)
								continue;

							if (Has(set, cxf1))
								continue;
							
							if (cxf1.get(0) > 6 && cxf1.get(0) < cxf1.get(1) && cxf1.get(1) < cxf1.get(2))
							{
								int c = cxf1.get(0);
								int x = cxf1.get(1);
								int f = cxf1.get(2);
								int a = ya1.get(1);
								int e = de1.get(1);
								int g = gh1.get(0);
								
								if (c+x+f+9 != 43) continue;
								if (y+4+a+17 != 43) continue;
								if (y+b+d != 43) continue;
								if (d+e+20 != 43) continue;
								if (19+z+h!=43) continue;
								if (2+g+14+h != 43) continue;
								
								set.addAll(cxf1);
	
								
								List<Integer> bz1 = List.of(b, z);
								
								if (Has(set, bz1))
								{
									set.removeAll(cxf1);
									continue;
								}
	
								//System.out.println("ya:");
								Print(ya1);
								//System.out.println("de:");
								Print(de1);
								//System.out.println("gh:");
								Print(gh1);
								//System.out.println("cxf:");
								Print(cxf1);
								//System.out.println("bz:");
								Print(bz1);
	
								System.out.println("---------------");
								set.removeAll(cxf1);

							}

					}

					set.removeAll(gh1);
				}

				set.removeAll(de1);
			}

			set.removeAll(ya1);

		}
	}

	public boolean Has(Set<Integer> set, List<Integer> list) {
		for (Integer i : list) {
			if (set.contains(i))
				return true;
		}
		return false;
	}

	// find numbers sequence that fulfills condition
	public List<List<Integer>> FindNumbersSequenceThat(int[] numbs, int amount, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<List<Integer>> list = new Combinations().genAllCombinations(numbs, amount);
		for (int i = 0; i < list.size(); i++) {

			if (this.CheckCondition(sum, list.get(i))) {
				result.add(list.get(i));
				// this.PrintList(list.get(i));
			}
		}
		return result;
	}
	
	public List<List<Integer>> FindNumbersPermutationThat(int[] numbs, int amount, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	
		List<Integer> input = Arrays.stream(numbs)
	      .boxed()
	      .collect(Collectors.toList());
		
		List<List<Integer>> list = new Permutations().generatePerm(input);
		for (int i = 0; i < list.size(); i++) {

			if (this.CheckCondition(sum, list.get(i))) {
				result.add(list.get(i));
			}
		}
		return result;
	}

	private void Print(List<Integer> list) {
		for (int j = 0; j < list.size(); j++) {
			System.out.print(" " + list.get(j));
		}
		System.out.println();
	}

	private boolean CheckCondition(int sum, List<Integer> list) {

		int s = 0;
		for (Integer i : list) {
			s += i;
		}
		return (s == sum);
	}

	public void Zad15() {

		for (int a = 1; a <= 9; a++) {
			for (int b = 0; b <= 9; b++) {
				for (int c = 0; c <= 9; c++) {
					int liczba = 100 * a + 10 * b + c;
					int A = this.Silnia(a);
					int B = this.Silnia(b);
					int C = this.Silnia(c);

					if (A + B + C == liczba) {
						System.out.println(liczba);
					}

				}
			}
		}
	}

	public int Silnia(int n) {
		if (n == 0)
			return 1;
		else
			return n * Silnia(n - 1);
	}

	int amount = 0;

	public class Maze {
		public List<List<Integer>> Lab;

		public Maze() {
			Lab = new ArrayList<List<Integer>>();
			for (int i = 0; i < 4; i++) {
				List<Integer> row = new ArrayList<>();
				for (int j = 0; j < 4; j++) {
					row.add(0);
				}
				Lab.add(row);
			}
		}

		public Integer GetPos(int x, int y) {
			return this.Lab.get(x).get(y);
		}

		public void SetPos(int x, int y, int nr) {
			this.Lab.get(x).set(y, nr);
		}

		public boolean IsInside(int x, int y) {
			return (x >= 0 && y >= 0 && x < 4 && y < 4);
		}

		public Maze(Maze maze) {
			Lab = new ArrayList<List<Integer>>();
			for (int i = 0; i < 4; i++) {
				List<Integer> row = new ArrayList<>();
				for (int j = 0; j < 4; j++) {
					row.add(maze.GetPos(i, j));
				}
				Lab.add(row);
			}
		}

		public void Print() {
			System.out.println();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					System.out.print(GetPos(i, j) + " ");
				}
				System.out.println();
			}
		}
	}

	public void Zad9(Maze maze) {

		dfs(maze, 0, 0, 1);
	}

	public void dfs(Maze maze, int x, int y, int nr) {
		// maze.Print();
		if (x == 3 && y == 2) {
			if (nr == 16) {
				amount++;
				maze.Print();
			} else {
				return;
			}
		}
		if (nr == 16 && (x != 3 || y != 2)) {
			return;
		}

		maze.SetPos(x, y, nr);

		if (maze.IsInside(x, y + 1) && maze.GetPos(x, y + 1) == 0) {
			Maze mazeCopy = new Maze(maze);
			dfs(mazeCopy, x, y + 1, nr + 1);
		}

		if (maze.IsInside(x + 1, y) && maze.GetPos(x + 1, y) == 0) {
			Maze mazeCopy = new Maze(maze);
			dfs(mazeCopy, x + 1, y, nr + 1);
		}

		if (maze.IsInside(x - 1, y) && maze.GetPos(x - 1, y) == 0) {
			Maze mazeCopy = new Maze(maze);
			dfs(mazeCopy, x - 1, y, nr + 1);
		}

		if (maze.IsInside(x, y - 1) && maze.GetPos(x, y - 1) == 0) {
			Maze mazeCopy = new Maze(maze);
			dfs(mazeCopy, x, y - 1, nr + 1);
		}

	}

}
