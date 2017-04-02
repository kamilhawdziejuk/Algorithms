//https://www.hackerrank.com/challenges/pairs

package HackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Pairs {

	int n, k;	
	int[] tab;
	private void Read() {
    	
		Scanner in = new Scanner(System.in);

    	n = in.nextInt();
    	k = in.nextInt();
    	tab = new int[n];
    	for (int i = 0; i < n; i++) {
    		tab[i] = in.nextInt();
    	}
    	
	}
	
	private void Calc() {
		int cnt = 0;
		Arrays.sort(tab);
		int i = 0;
		int j = 1;
		while (j < n) {
			if (tab[j] - tab[i] == k) {
				cnt++;
				i++;
				j++;
			}
			else if (tab[j] - tab[i] > k) {
				i++;
			}
			else {
				j++;
			}
		}		
		System.out.println(cnt);
	}
	
    public static void main(String[] args) {
    	Pairs sol = new Pairs();
    	sol.Read();
    	sol.Calc();
    }
}
