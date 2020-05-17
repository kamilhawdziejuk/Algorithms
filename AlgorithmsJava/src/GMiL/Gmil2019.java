package GMiL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import alg.Numbers.Numbers;

/*
 * 1: 4
 * 2: 2
 * 3: 2
 * 4: 1
 * 5: 2
 * 6: 2023
 * 7: 3
 * 8: 29.12.2192
 * 9: 2rozw. (1960, 2010)
 * 10: 1rozw. (3976)
 * 11: 3rozw. (0,2,152)
 * 12: 1rozw. (12)
 * 13: 1rozw. (20)
 * 14: 1rozw. (25cm)
 * 15: 2rozw. (17cm^2, 22.5cm^2)
 * 16: 1rozw. (1993)
 * 17: 1rozw. (50961)
 * 18: 1rozw. (3240)
 */

public class Gmil2019 {

	int cnt = 0;
	public static void main(String[] args) {
		Gmil2019 pro = new Gmil2019();
		pro.getNumbers(0, 0, 0);
		if (pro.cnt > 0) {
			System.out.println(pro.cnt);
		}
	}
	
	class Maze2 {
		int t[][] = new int[4][7];
		
		public Maze2(String s) {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '1') {
					t[i/7][i % 7] = 1;
				}
			}
		}
		
		public boolean check() {
			for (int r = 0; r < 4; r++) {
				if (t[r][0]+t[r][1]+t[r][2] == 3) return false;
				if (t[r][1]+t[r][2]+t[r][3] == 3) return false;
				if (t[r][2]+t[r][3]+t[r][4] == 3) return false;
				if (t[r][3]+t[r][4]+t[r][5] == 3) return false;
				if (t[r][4]+t[r][5]+t[r][6] == 3) return false;
			}
			for (int c = 0; c < 7; c++) {
				if (t[0][c]+t[1][c]+t[2][c] == 3) return false;
				if (t[1][c]+t[2][c]+t[3][c] == 3) return false;
			}
			for (int c = 0; c < 5; c++) {
				if (t[0][c]+t[1][c+1]+t[2][c+2]==3) return false;
				if (t[1][c]+t[2][c+1]+t[3][c+2]==3) return false;				
			}			
			for (int c = 0; c < 5; c++) {
				if (t[2][c]+t[1][c+1]+t[0][c+2]==3) return false;
				if (t[3][c]+t[2][c+1]+t[1][c+2]==3) return false;				
			}			

			
			return true;
		}
	}
	
	private void getNumbers(int num, int start, int already) {
		int needed = 16;
		int size = 28;		
		if (already == needed) {
			String str = Integer.toBinaryString(num);
			Maze2 maze = new Maze2(str);
			if (maze.check()) {
				cnt++;	
				System.out.println(cnt + " : " + str);
			}
			
		} else {
			if (start >= size) return;
			int left = size - start;
			if (left + already < needed) return;
			int pow = 1 << start;
			int numNext = num + pow;
			getNumbers(numNext, start+1, already+1);
			getNumbers(num, start+1, already);
		}
	}
	
	 //taka sama ilosc drzew w kazdym wierszu (po n)
    private void Zad17_A() {
        double minField = Integer.MAX_VALUE;
        for (int n = 2; n<=2020; n++) { //n to ilosc drzew w jednym rzedzie
            double y; //wysokosc prostokata obliczana na biezaco
            double x = 5*(n-1)+20+2.5; //szerokosc prostokata - tutaj jest przesuniecie o 2.5
            int amount = 0;
            
            for (int row = 1; row <= 2020; row++) { //ilosc rzedow drzew
    
                y = 20 + (row-1) * 5*Math.sqrt(3)/2;                
                amount = amount + n; //z kazdym wierszem dodajemy n drzew
                
                if (amount >= 2020) {
                    double field = x*y;
                    if (field < minField) {
                        minField = field;
                    }
                }
            }
        }
    }
    
    //zmienna ilosc drzew w kazdym wierszu
    private void Zad17_B() {
        double min = Integer.MAX_VALUE;
        
        for (int n = 1; n<=2020; n++) {
            double y;
            double x = 5*(n-1)+20;
            int amount = 0;
            
            for (int row = 1; row <= 2020; row++) {
    
                y = 20 + (row-1) * 5*Math.sqrt(3)/2;
                
                if (row % 2 == 1) {
                    amount = amount + n;
                } else {
                    amount = amount + n-1;
                }
                
                if (amount >= 2020) {
                    double field = x*y;
                    if (field < min) {
                        min = field;
                    }
                }
            }
        }
    }
	
	private void Zad18B() {
		List<Integer> c1 = new ArrayList<>(Arrays.asList(3,13,16,4,5,15));
		List<Integer> c2 = new ArrayList<>(Arrays.asList(3,13,16,5,6,10));
		List<Integer> c3 = new ArrayList<>(Arrays.asList(4,6,13,3,5,10));
		List<Integer> c4 = new ArrayList<>(Arrays.asList(4,9,13,3,5,15));
		List<Integer> c5 = new ArrayList<>(Arrays.asList(4,12,13,5,6,10));
		List<Integer> c6 = new ArrayList<>(Arrays.asList(4,13,14,5,7,10));
		List<Integer> c7 = new ArrayList<>(Arrays.asList(4,13,16,5,8,10));
		
		List<Integer> c8 = new ArrayList<>(Arrays.asList(6,8,13,4,5,15));
		List<Integer> c9 = new ArrayList<>(Arrays.asList(6,12,13,3,10,15));
		List<Integer> c10 = new ArrayList<>(Arrays.asList(6,12,13,5,9,10));
		List<Integer> c11 = new ArrayList<>(Arrays.asList(6,13,14,5,7,15));
		List<Integer> c12 = new ArrayList<>(Arrays.asList(6,13,16,4,10,15));
		List<Integer> c13 = new ArrayList<>(Arrays.asList(6,13,16,5,8,15));
		List<Integer> c14 = new ArrayList<>(Arrays.asList(6,13,16,5,10,12));

		List<Integer> c15 = new ArrayList<>(Arrays.asList(7,13,16,5,10,14));
		List<Integer> c16 = new ArrayList<>(Arrays.asList(8,9,13,3,10,15));
		List<Integer> c17 = new ArrayList<>(Arrays.asList(8,9,13,5,6,15));
		List<Integer> c18 = new ArrayList<>(Arrays.asList(8,12,13,4,10,15));
		List<Integer> c19 = new ArrayList<>(Arrays.asList(9,13,16,5,12,15));
		List<Integer> c20 = new ArrayList<>(Arrays.asList(9,13,16,6,10,15));
		List<Integer> c21 = new ArrayList<>(Arrays.asList(12,13,14,7,10,15));
		List<Integer> c22 = new ArrayList<>(Arrays.asList(12,13,16,8,10,15));
		

		calc(c1);
		calc(c2);
		calc(c3);
		calc(c4);
		calc(c5);
		calc(c6);
		calc(c7);
		calc(c8);
		calc(c9);
		
		calc(c10);
		calc(c11);
		calc(c12);
		calc(c13);
		calc(c14);
		calc(c15);
		calc(c16);
		calc(c17);
		calc(c18);
		
		calc(c19);
		calc(c20);
		calc(c21);
		calc(c22);
	}
	

	private void calc(List<Integer> c) {
		
		List<Integer> list = new ArrayList<>();
		for (int i = 3; i <= 16; i++) list.add(i);
		
		int max = c.get(0) * c.get(1) * c.get(2) * 1;
		int min = c.get(5) * c.get(4) * c.get(3) * 2;
		
		list.removeAll(c);	
		
		for (int i1 = 0; i1 < 8; i1++) {
			for (int i2 = i1+1; i2 < 8; i2++) {
				for (int i3 = i2+1; i3 < 8; i3++) {
					for (int i4 = i3+1; i4 < 8; i4++) {
						
						if (!(i1 < 8 && i2 < 8 && i3 < 8 && i4 < 8)) {
							continue;
						}
						List<Integer> list2 = new ArrayList<>(list);
						int a1 = list2.get(i1);
						int a2 = list2.get(i2);
						int a3 = list2.get(i3);
						int a4 = list2.get(i4);
						
						List<Integer> list1 = Arrays.asList(a1, a2, a3, a4);
						
						int mul1 = a1 * a2 * a3 * a4;
						
						list2.removeAll(list1);
						
						int mul2 = 1;
						for (int i = 0; i < 4; i++) {
							mul2 *= list2.get(i);
						}
						
						if (mul1 <= max && mul1 >= min && mul2 <= max && mul2 >= min) {
							
							System.out.println("min=" + c.get(5) + "*" + c.get(4) + "*" + c.get(3) + "*2 = " + min);
							System.out.println("mul1=" + list1.get(0) + "*" + list1.get(1) + "*" + list1.get(2) + "*" + list1.get(3) + "="+mul1);
							System.out.println("mul2=" + list2.get(0) + "*" + list2.get(1) + ",*" + list2.get(2) + "*" + list2.get(3) + "="+mul2);;
							System.out.println("max=" + c.get(0) + "*" + c.get(1) + "*" + c.get(2) + "*1 = " + max);
							
							System.out.println();
						}
						
					}
				}
			}
		}
	}
	
	private void Zad18() {
		Set<Integer> set = new HashSet<>();

		List<String> sol = new ArrayList<>();
		
		for (int a = 3; a <= 16; a++) {
			set.add(a);
			for (int b = 3; b <= 16; b++) {
				if (set.contains(b)) continue;
				set.add(b);
				for (int c = 3; c <= 16; c++) {
					if (set.contains(c)) continue;
					set.add(c);
					for (int x = 3; x <= 16; x++) {
						if (set.contains(x)) continue;
						set.add(x);
						for (int y = 3; y <= 16; y++) {
							if (set.contains(y)) continue;
							set.add(y);
							for (int z = 3; z <= 16; z++) {
								if (set.contains(z)) continue;
								set.add(z);
								
								if (100 * a * b * c == 208 * x * y * z) {
									
									List<Integer> left = new ArrayList<>(Arrays.asList(a,b,c));
									Collections.sort(left);

									List<Integer> right = new ArrayList<>(Arrays.asList(x,y,z));
									Collections.sort(right);

									String str = "" + left.get(0) + left.get(1) + left.get(2) +
											right.get(0) + right.get(1) + right.get(2);
								
									if (!sol.contains(str))
									{
										sol.add(str);
										System.out.println("a="+a + " b="+b+" c="+c + " x="+x+" y="+y+" z="+z);

									}
								}
								
								set.remove(z);
							}
							set.remove(y);
						}
						set.remove(x);
					}
					set.remove(c);
				}
				set.remove(b);
			}
			set.remove(a);
		}
	}
	
	private void Zad12() {
		for (int x = 1; x <= 100; x++) {
			for (int y = 1; y <= 100; y++) {
				if ((y+x+1) % (x*y) == 0 ) {
					System.out.println("x=" + x + "  y="+y);
				}
			}
		}
	}
	
	private void Zad11() {
		for (int T = 0; T < 10; T++) {
			for (int A = 0; A < 10; A++) {
				for (int K = 0; K < 10; K++) {
					int a = 100*T + 10*A + K;
					int b = K + 10*A + 100*A + 1000*T + 10000*T;
					if (a * a == 2 * b ) {
						System.out.println(100 * T + 10 * A + K);
					}
				}
			}
		}
	}
	
	private void Zad7() {
		for (int i = 2020; i < 2030; i++ ) {
			
			if (i % 7 == 0 ) {
				Numbers num = new Numbers();
				List<Integer> digits = num.getDigits(i);
				int sum = 0;
				for (int d : digits) {
					sum += d;
				}
				
				if (sum % 7 == 0) {
					System.out.println(i);
				}
				
			}
		}
	}
	
	private void Zad16() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i<=2020; i++) {
			q.add(i);
		}
		
		int res = -1;
		
		while (!q.isEmpty()) {
			int val = q.poll();
			if (q.isEmpty()) {
				res = val;
				break;
			} else {
				q.poll();
			}
			
			if (q.isEmpty()) {
				res = val;
				break;
			}
			else {
				q.offer(val);
			}
		}
		
		System.out.println(res);
		
	}

	
}
