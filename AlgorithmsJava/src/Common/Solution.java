package Common;

import java.util.*;

public class Solution {
	
	public int checkWinner(List<List<String>> codeList, List<String> shoppingCart)
	{
		int startPos = 0;
		for (int i = 0; i < codeList.size(); i++) {
			List<String> code = codeList.get(i);
			int pos = check(code, shoppingCart, startPos);
			if (pos == -1)
			{
				return 0;
			}
			startPos = pos+code.size();
			
		}
		return 1;
	}
	
	public int check(List<String> code, List<String> shoppingCart, int startPos) {
		//find code in sh
		int n = code.size();
		int m = shoppingCart.size();
		for (int i = startPos; i <= m-n; i++) {
			
			int pos = i;
			boolean found = true;
			for (int j = 0; j < n; j++) {
				String s1 = code.get(j);
				String s2 = shoppingCart.get(i+j);
				if (s1 != s2 && s1 != "anything") {
					found = false;
					break;
				}										 
			}
			
			if (found) {
				return pos;
			}
		}
		return -1;
	}
}
