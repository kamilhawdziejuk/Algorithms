package alg.Numbers;
import java.util.*;

public class Numbers {
	
	class NegativeNumberException extends Exception
	{
		public NegativeNumberException(){};
	}
	
	public long factorial(long n) throws NegativeNumberException
	{
		if (n < 0)
		{
			throw new NegativeNumberException();
		}
		if (n == 0)
		{
			return 1;
		}
		else
		{
			long result = 1;
			for (int i = 1; i <= n; ++i)
			{
				result *= i;
			}
			return result;
		}
	}
	
	public List<Integer> getDigits(int n)
    {
        List<Integer> results = new ArrayList<>();
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++)
        {
            results.add(Integer.parseInt(s.charAt(i) + ""));
        }
        return results;
    }	  

	public static void main(String[] args)
	{
		Numbers sol = new Numbers();
	}
}
