import java.util.*;

public class Numbers {
	
	public List<Integer> getNumbers(int n)
    {
        List<Integer> results = new ArrayList<>();
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++)
        {
            results.add(Integer.parseInt(s.charAt(i) + ""));
        }
        return results;
    }
	
    
    public boolean isHappy(int n) {
        Set<Integer> map = new HashSet<>();
        while (!map.contains(1))
        {
            int nr = 0;
            for (int i : getNumbers(n))
            {
                nr += (i*i);
            }
            if (map.contains(nr))
            {
                return false;
            }
            map.add(nr);
            n = nr;
        }
        return true;
    }
	public static void main(String[] args)
	{
		Numbers sol = new Numbers();
		boolean res = sol.isHappy(7);
	}
}
