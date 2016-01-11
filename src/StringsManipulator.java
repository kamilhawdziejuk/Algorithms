import java.util.ArrayList;
import java.util.List;

public class StringsManipulator {
	
	private String str = new String();
	
	public static void main(String [ ] args)
	{
		StringsManipulator sol = new StringsManipulator();
		List<String> list = new ArrayList<>();
		list.add("jeden");
		list.add("dwa");
		String res = sol.encode(list);
		List<String> list2 = sol.decode(res);
	}
	
	public void methodsOnString()
	{
		char c = str.charAt(0);
		int i = str.indexOf('a'); //first occurance of 'a'
		
		int fromIndex = 2;
		int i2 = str.indexOf('a', fromIndex);
		
		String str10 = String.valueOf(10);
		int k = Integer.valueOf("10");

		String strFirst2Chars = str.substring(0,2);;
	}
	
   public String encode(List<String> strs) {
        String res = new String();
        int n = strs.size();
        res = n + "_";
        for (String str : strs)
        {
            res = res + str.length() + "_";
        }
        for (String str : strs)
        {
            res = res + str;
        }
        return res;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> results = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        int k = s.indexOf('_');
        int amount = Integer.valueOf(s.substring(0,k));
        for (int i = 0; i < amount; ++i)
        {
            int p = s.indexOf('_', k+1);
            String sNum = s.substring(k+1,p);
            int num = Integer.valueOf(sNum);
            nums.add(num);
            k = p;
        }
        k++;
        for (int i = 0; i < amount; ++i)
        {
        	int k2 = k+nums.get(i);
        	String res = s.substring(k, k2);
        	results.add(res);
        	k = k2;
        }
        return results;
    }
}

