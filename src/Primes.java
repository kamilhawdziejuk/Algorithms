import java.util.*;

public class Primes {

	public static void main(String [ ] args)
	{	
		Primes primes = new Primes();
		List<Integer> primeNumbers = primes.getPrimes(11);
	}
	int nums[];
	
 
	
	boolean[] sieve;
    public List<Integer> getPrimes(int n)
    {
         sieve = new boolean[n+2];
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
	
}
