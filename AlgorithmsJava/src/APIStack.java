import java.util.*;

public class APIStack {

	public void Test() {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.add(5);
		int topWithDeleting = stack.pop();
		int getTopWithoutDeleting = stack.peek();
	}
}
