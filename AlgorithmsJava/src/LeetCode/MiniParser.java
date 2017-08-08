//https://leetcode.com/problems/mini-parser/description/
//not working
package LeetCode;

import java.util.*;

public class MiniParser {  
	
	 // This is the interface that allows for creating nested lists.
	 // You should not implement it, or speculate about its implementation
	 public class NestedInteger {
		 int _value = 0;
		 public int Depth = 0;
		 List<NestedInteger> _list = null;
	      // Constructor initializes an empty nested list.
	      public NestedInteger() {}
	 
	      // Constructor initializes a single integer.
	      public NestedInteger(int value) {
	    	  _value = value;
	      }
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger() {
	    	  return _value != 0;
	      }
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger() {
	    	  return _value;
	      }
	      
	      // Set this NestedInteger to hold a single integer.
	      public void setInteger(int value) {
	    	  _value = value;
	      };
	 
	      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	      public void add(NestedInteger ni) {
	    	  if (_list == null) {
	    		  _list = new ArrayList<NestedInteger>();
	    	  }
	    	  _list.add(ni);
	      }
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList() {
	    	  return _list;
	      }
	  }
	 
	 String _str;
	 public NestedInteger deserialize(String s) {
		 _str = s;
	 	//"[123,[456,[789]]]",
	 	if (s.charAt(0) == '[') {
		 	NestedInteger root = new NestedInteger();
	        deserialize(1, root);
	        return root;
	 	}
	 	else {
			 NestedInteger elem = new NestedInteger();
			 int i = 0;
			 while (_str.length() > (i+1) && Character.isDigit(_str.charAt(i+1))) {
				 i++;
			 }
			 String numStr = _str.substring(0, i+1);
			 int num = Integer.parseInt(numStr);
			 NestedInteger current = new NestedInteger(num);
			 return current;
	 	}
	 }
	 
	 public void deserialize(int index, NestedInteger parent) {
		 if (_str.length() <= index) {
			 return;
		 }
		 if (_str.charAt(index) == '[') {
			 NestedInteger listElem = new NestedInteger();
			 deserialize(index+1, listElem);
			 parent.add(listElem);
		 }
		 else if (_str.charAt(index) == ']') {
			 deserialize(index+1, parent);
		 }
		 else if (_str.charAt(index) == ',') {
			 deserialize(index+1, parent);
		 }
		 else { //its a digit
		 
			 int i = index;
			 if (_str.charAt(i) == '-') {
				 i++;
			 }
			 while (Character.isDigit(_str.charAt(i+1))) {
				 i++;
			 }
			 String numStr = _str.substring(index, i+1);
			 int num = Integer.parseInt(numStr);
			 NestedInteger current = new NestedInteger(num);
			 parent.add(current);
			 
			 deserialize(i+1, parent);
		 }
	 }
}
