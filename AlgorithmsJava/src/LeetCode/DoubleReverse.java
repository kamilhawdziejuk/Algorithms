package LeetCode;

public class DoubleReverse {

	public static void main(String[] args) {
		DoubleReverse sol = new DoubleReverse();
		sol.reverse("Leaving in LasVegas film");
	}
	
	public String reverse(String text) {
		//checks on null;	
		char[] tab = text.toCharArray();
		reverse(tab, 0, tab.length-1);
		int first = -1;
		int last = -1;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != ' ') {
				if (first == -1) {
					first = i;
				} else {
					last = i;
				}
			} else {
				if (first != -1 && last != -1 && first < last) {
					reverse(tab, first, last);
					first = last = -1;
				}
			}
		}
		return new String(tab);
	}
	
	private void reverse(char[] text, int begin, int end) {
		int n = end-begin+1;
		for (int i = 0; i < (n/2); i++) {
			char tmp = text[begin+i];
			text[begin+i] = text[end-i];
			text[end-i] = tmp;
		}
	}
	
}
