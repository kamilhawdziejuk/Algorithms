package HackerRank;

import java.util.Scanner;


public class MeolodiousPassword {
	
	int n;
    char[] vowels = {'a', 'e', 'i', 'o', 'u'}; //5
    char[] consonants  = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'}; //20

    private String s = new String();
    private void Generate(int nr, boolean beVowel)
    {
    	if (nr == n) {
    		System.out.println(s);
    	}
    	else {
    		char[] current = beVowel ? vowels : consonants;
    		for (int i = 0; i < current.length; i++) {
    			String t = s;
            	s += current[i];
    			Generate(nr+1, !beVowel);
    			s = t;
    		}  		
    	}
    	
    }
	
    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
             
        MeolodiousPassword passwd = new MeolodiousPassword();
        passwd.n = in.nextInt();

        passwd.Generate(0, true);
        passwd.Generate(0, false); 
    }
}
