package LeetCode;

//https://leetcode.com/problems/count-and-say/
public class CountAndSay {
	
	public static void main(String[] args) {
		CountAndSay pro = new CountAndSay();
		pro.countAndSay(10);
	}
	
    public String countAndSay(int n) {
    	String prev = "1";
    	for (int i = 2; i <= n; i++) {
    		prev = next(prev);
    	}
        return prev;
    }
    
    private String next(String str) {
    	Character prev = null;
    	int cnt = 0;
    	StringBuilder res = new StringBuilder();
    	for (int i = 0; i < str.length(); i++) {
    		char c = str.charAt(i);
    		if (prev != null) {
    			if (c != prev.charValue()) {
    				String next = ""+cnt+prev;
    				res.append(next);
    				prev = c;
    				cnt = 1;
    			} else {
    				cnt++;
    			}
    		} else {
    			cnt++;
    			prev = c;
    		}
    	}
		String next = ""+cnt+prev;
		res.append(next);

    	return res.toString();
    }
}
