package LeetCode;

public class PalnidromNumber {

	public static void main(String[] args) {
		PalnidromNumber p = new PalnidromNumber();
		boolean res1 = p.isPalindrome(-2147483648);
		boolean res2 = p.isPalindrome(1000021);
	}
	
	public boolean isPalindrome(int x) {
        int palindromeX = 0;
        int inputX = x;
        while(x>0){
            palindromeX = palindromeX*10 + (x % 10);
            x = x/10;
        }
        return palindromeX==inputX;	
    }
	
	public boolean isPalindrome2(int x) {
		String s = Integer.toString(x);
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
}
