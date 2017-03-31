package alg.Numbers;
import java.util.*;

public class Primes {

	public static void main(String [ ] args)
	{	
		Primes primes = new Primes();
		List<Integer> primeNumbers = primes.getPrimes(11);
	}
	
    public List<Integer> getPrimes(int n)
    {
    	 boolean[] sieve = new boolean[n+2];
         sieve[0] = true;
         sieve[1] = true;
         int i = 2;
         while (i*i <= n)
         {
             if (!sieve[i])
             {
                 int k = i*i;
                 while (k <= n)
                 {
                     sieve[k] = true;
                     k+=i;
                 }
             }
             i+=1;
         }
         List<Integer> res = new LinkedList<>();
         for (int j = 1; j <= n; ++j)
         {
             if (!sieve[j])
             {
                 res.add(j);
             }
         }
         return res;
    }
    
    public static final Map<Long, Long> getPrimeFactorization(long number) {
        Map<Long, Long> map = new HashMap<Long, Long>();
        long n = number;
        int c = 0;
        // for each potential factor i
        for (long i = 2; i * i <= n; i++) {
            c = 0;
            // if i is a factor of N, repeatedly divide it out
            while (n % i == 0) {
                n = n / i;
                c++;
            }
            Long p = map.get(i);
            if (p == null)
                p = new Long(0);
            p += c;
            map.put(i, p);
        }
        if (n > 1) {
            Long p = map.get(n);
            if (p == null)
                p = new Long(0);
            p += 1;
            map.put(n, p);
        }
        return map;
    }

    /*
     * isPrime() using the square root properties
     * 
     * 1 is not a prime. All primes except 2 are odd. All primes greater than 3
     * can be written in the form 6k+/-1. Any number n can have only one
     * primefactor greater than n . The consequence for primality testing of a
     * number n is: if we cannot find a number f less than or equal n that
     * divides n then n is prime: the only primefactor of n is n itself
     */
    public static final boolean isPrime(long number) {
        if (number == 1)
            return false;
        if (number < 4)
            return true; // 2 and 3 are prime
        if (number % 2 == 0)
            return false; // short circuit
        if (number < 9)
            return true; // we have already excluded 4, 6 and 8.
                         // (testing for 5 & 7)
        if (number % 3 == 0)
            return false; // short circuit
        long r = (long) (Math.sqrt(number)); // n rounded to the greatest integer
                                            // r so that r*r<=n
        int f = 5;
        while (f <= r) {
            if (number % f == 0)
                return false;
            if (number % (f + 2) == 0)
                return false;
            f += 6;
        }
        return true;
    }

	
}
