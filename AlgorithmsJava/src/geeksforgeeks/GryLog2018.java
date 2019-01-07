//https://leetcode.com/problems/array-of-doubled-pairs/
package geeksforgeeks;

import alg.Numbers.Primes;
import java.util.*;

public class GryLog2018 {

	private void add(Map<Integer, Integer> map, int val) {
		if (map.containsKey(val)) {
            map.put(val, map.get(val)+1);
        }
        else {
            map.put(val, 1);
        }
	}
	
	private boolean check(Map<Integer, Integer> map, boolean desc) {
		
		
		TreeSet<Integer> keys = new TreeSet<>(map.keySet());
		
		if (desc) {
			keys = (TreeSet)keys.descendingSet();
		}
        
        for (Integer nr : keys) {
            
            if (map.containsKey(nr)) {
                               
                while (map.get(nr) > 0) {
                
                    int val = map.get(nr);
                    
                    if (!map.containsKey(nr*2) || map.get(nr*2) <= 0) {
                        return false;
                    }
                    
                    map.put(nr, map.get(nr)-1);
                    map.put(nr*2, map.get(nr*2)-1);
                    
                }
            }
        }
        
        for (Integer nr : map.keySet()) {
            if (map.get(nr) > 0) {
                return false;
            }
        }
        return true;		
	}
	
	public boolean canReorderDoubled(int[] A) {
	     
        int n = A.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapPositive = new HashMap<>();

        for (int i = 0; i < n; i++) {
        	if (A[i] >= 0) {
        		add(mapPositive, A[i]);
        	}  	else {
        		add(map, A[i]);	
        	}        	           
        }
        
        if (!check(map, true)) {
        	return false;
        }
        
        if (!check(mapPositive, false)) {
        	return false;
        }
        
        return true;
    }	
	
	public int zad16() {
		
		int smallest = 2000000000;
		List<Integer> primes = Primes.getPrimes(1000);
		int cnt = primes.size();
		for (int i1 = 0; i1 < cnt; i1++) {
			for (int i2 = 0; i2 < cnt; i2++) {				
				for (int i3 = 0; i3 < cnt; i3++) {
					int a = primes.get(i1);
					int b = primes.get(i2);
					int c = primes.get(i3);
					int mult = a * b * c;
					
					int x1 = build(a,b,c);
					int x2 = build(a,c,b);
					int x3 = build(b,a,c);
					int x4 = build(b,c,a);
					int x5 = build(c,a,b);
					int x6 = build(c,b,a);
					
					if (Primes.isPrime(x1) && Primes.isPrime(x2) &&Primes.isPrime(x3) &&
							Primes.isPrime(x4) &&Primes.isPrime(x5) &&Primes.isPrime(x6)) {
						
						if (mult < smallest) {
							smallest = mult;
							System.out.println(a + " * " + b + " * " + c + " = " + smallest);							
						}
					}
				}
			}			
		}				
		
		return 0;
	}
	
	private int build(int a, int b, int c) {
		String strA = Integer.toString(a);
		String strB = Integer.toString(b);
		String strC = Integer.toString(c);
		
		String str = strA + strB + strC;
		return Integer.valueOf(str);
	}
	
	public int zad15() {
		int tab[] = {1,2,2,3,3,3};

		int cnt = 0;
		int all = 0;
		for (int i1 = 0; i1 < 6; i1++) {
			for (int i2 = 0; i2 < 6; i2++) {
				for (int i3 = 0; i3 < 6; i3++) {
					for (int i4 = 0; i4 < 6; i4++) {
						for (int i5 = 0; i5 < 6; i5++) {
							for (int i6 = 0; i6 < 6; i6++) {
								int sum = tab[i1]+tab[i2]+tab[i3]+tab[i4]+tab[i5]+tab[i6];
								all++;
								if (sum == 12) {
									cnt++;
								}
							}							
						}						
					}					
				}				
			}			
		}
		System.out.println(cnt + " / " + all);
		return cnt;
	}
	public int integerReplacement(int n) {
		int res = integerReplacementLong((long)n);
		return res;
	}
	
	public int integerReplacementLong(long n) {
		if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacementLong(n/2);
        }
        else {
            return 1 + Math.min( integerReplacementLong(n+1), integerReplacementLong(n-1));
        }    
	}    
	
	public static void main(String[] args) {
		GryLog2018 sol = new GryLog2018();
		//int amount = sol.zad16();
		//sol.integerReplacement(7);//2147483647);
		int[] tab = {-4,-6,-1,-2,-1,-1,-3,-8};//{4,-2,2,-4};
		int[] pushed = {1,2,3,4,5};
		int[] poped = {4,5,3,2,1};
		sol.validateStackSequences(pushed, poped);
		//sol.canReorderDoubled(tab);
		//System.out.println(amount);
	}
	
	public boolean validateStackSequences(int[] pushed, int[] popped) {
	     
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        
        for (int i = 0; i < pushed.length; i++) {
            stack.add(pushed[i]);
        
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        
        boolean isPopped = false;
        if (popped.length -1 == j) {
            isPopped = true;
        }
        
        return isPopped;
    }
	
}
