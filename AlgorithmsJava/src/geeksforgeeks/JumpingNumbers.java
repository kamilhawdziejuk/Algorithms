//https://practice.geeksforgeeks.org/problems/jumping-numbers/0
//100%

package geeksforgeeks;

import java.io.*;
import java.util.*;

public class JumpingNumbers {

	int T;
	int max;
	List<Integer> input = new ArrayList<>();
	List<Integer> output = new ArrayList<>();
	Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String [ ] args)
	{	
		JumpingNumbers program = new JumpingNumbers();
		program.Read();
		program.Calc();
	}
	
	public void Calc() {		
		for (int i = 0; i < input.size(); i++) {
			output.clear();
			max = input.get(i);
			Generate();		
			Write();
		}		
	}
	
	private void Write() {
		for (int i = 0; i < output.size(); i++) {
			System.out.print(output.get(i) + " ");
		}
		System.out.println();
	}
	
	public void Generate() {
		output.add(0);
		int maximumDigit = Math.min(9, max);
		for (int i = 1; i <= maximumDigit; i++) {
			if (i <= max) {				
				output.add(i);
				queue.add(i);			
				GenerateNext();
			}
		}				
	}
	
	private int GetLastDigit(int val) {
		return val - 10* (val/10);
	}
	
	private void GenerateNext() {
						
		while (queue.size() > 0) {
			
			Integer val = queue.poll();
			
			if (val <= max) {
				
				int lastDigit = GetLastDigit(val);
				if (lastDigit > 0) {
					int nextDigit = lastDigit-1;
					int nextNumber = val * 10 + nextDigit;
					if (nextNumber <= max) {
						output.add(nextNumber);
						queue.add(nextNumber);
					}
				}
				if (lastDigit < 9) {
					int nextDigit = lastDigit+1;
					int nextNumber = val * 10 + nextDigit;
					if (nextNumber <= max) {
						output.add(nextNumber);
						queue.add(nextNumber);
					}
				}
			}
		}
	}
	
	public void Read() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
			T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
	        	int data = Integer.parseInt(br.readLine());
	        	input.add(data);				
			}
        } 
        catch (Exception ex) {
        }
	}
	
}
