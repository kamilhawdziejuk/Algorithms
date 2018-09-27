package LeetCode;
//https://leetcode.com/problems/hamming-distance/description/

public class HammingDistance {
		
	public static void main(String [ ] args)
	{
		HammingDistance sol = new HammingDistance();
		sol.hammingDistance(1, 4);
	}
	
	public int hammingDistanceFast(int x, int y) {
		int a=x^y;
		int count=0;
		while (a>0) {
			count+=a&1;
			a>>=1;
		}
		return count;
	}
	
	public int hammingDistance1(int x, int y) {
	    int xor = x ^ y, count = 0; //x^y leaves all the bits that are different.
	    for (int i=0;i<32;i++) count += (xor >> i) & 1;
	    return count;
	}
	
    public int hammingDistance0(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
	
    public int hammingDistance(int x, int y) {
    	
    	String xs = Integer.toBinaryString(x);
    	String ys = Integer.toBinaryString(y);
    	
    	int xl = xs.length();
    	int yl = ys.length();
    	int size = Math.min(xl, yl);
    	int cnt = 0;
    	for (int i = 0; i < size; i++) {
    		char xc = xs.charAt(xl-i-1);
    		char yc = ys.charAt(yl-i-1);
    		if (xc != yc) {
    			cnt++;
    		}
    	}
    	
    	int sizeMax = Math.max(xl, yl);
    	String s = xl > yl ? xs : ys;
    	for (int i = size; i < sizeMax; i++) {
    		if (s.charAt(sizeMax-i-1) == '1') {
    			cnt++;
    		}
    	}
    	
    	return cnt;
    }
}
