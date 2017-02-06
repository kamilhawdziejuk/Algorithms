package Common;

import java.util.*;

public class SemiPrimes {

	private static List<Integer> getPrimes(int n)
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
	
	
	public static boolean run(int number) {
		int m = (int) Math.sqrt(number)+1;
		List<Integer> primes = getPrimes(number);
		
		for (Integer p : primes)
		{
			if (number % p == 0)
			{
				int res = number / p;
				if (primes.contains(res))
				{
					return true;
				}
			}
		}
		return false;
	}
	
}
