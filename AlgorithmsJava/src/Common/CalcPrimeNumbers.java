package Common;

import java.util.*;

public class CalcPrimeNumbers {
	 private static ArrayList<Integer> primeNumbers = new ArrayList<>();
	 
	    private static void calcPrimeNumbers(int n) {
	        primeNumbers.add(2);
	        for (int i = 3; i < n; i+=2) { // skip over even numbers since they are not prime
	            boolean isPrime = true;
	            for (Integer prime : primeNumbers) { // check current prime numbers to see if it evenly divides into number
	                if (i % prime == 0) { // when number is not prime
	                    isPrime = false;
	                    break; // optimization: stop checking when number is already not prime
	                }
	            }
	            if (isPrime) {
	                primeNumbers.add(i);
	            }
	        }
	    }
	    
	    private static boolean IsPrime(int n) {
	    	return primeNumbers.contains(n);
	    }
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        List<Integer> list = new ArrayList<Integer>();
	        int m = 1;
	        int p = in.nextInt();
	        for(int a0 = 0; a0 < p; a0++){
	            int n = in.nextInt();
	            list.add(n);
	            m = Math.max(m, n);
	        }
	        calcPrimeNumbers(m+1);
	        for (Integer i : list)
	        {
	        	if (IsPrime(i))
	        	{
	        		System.out.println("Prime");
	        	}
	        	else
	        	{
	        		System.out.println("Not prime");
	        	}
	        }
	    }
}
