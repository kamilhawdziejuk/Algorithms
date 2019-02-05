package LeetCode;
import java.util.*;

class MinStack {

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-3);
		int res = stack.getMin();
		
	}
	
    class Elem {
        public int val;
        public int min;
        
        public Elem(int _val, int _min) {
            val = _val;
            min = _min;
        }
    }
    int currentMin;
    
    Stack<Elem> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Elem>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            Elem elem = new Elem(x, x);
        }
        else {
            int min = getMin();
            min = Math.min(min, x);
            stack.push(new Elem(x, min));
        }
    }
    
    public void pop() {
        stack.pop();        
    }
    
    public int top() {
        Elem top = stack.peek();
        return top.val;
    }
    
    public int getMin() {
        Elem top = stack.peek();
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */