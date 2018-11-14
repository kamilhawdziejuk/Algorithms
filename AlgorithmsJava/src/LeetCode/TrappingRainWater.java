//https://leetcode.com/problems/trapping-rain-water (100%)

package LeetCode;

import java.util.*;

public class TrappingRainWater {
	
	 public static void main(String[] args) {
		 TrappingRainWater sol = new TrappingRainWater();
		 int[] tab = {0,1,0,2,1,0,1,3,2,1,2,1};//6
		 //int[] tab = {5,4,1,2}; //1
		 //int[] tab = {2,1,0,2};//3		 
		 //int[] tab = {4,2,0,3,2,5};
		 sol.trap(tab);
	 }
	
	
	class Node {
		public Node left = null;
		public Node right = null;
		public int width = 1;
		public int height = 0;
		
		public Node(int h) {
			height = h;
		}
	}
	
	 private void mergeLeftToRight(Node a, Node b) {
		 b.width += a.width;
		 b.height = a.height;
		 b.left = a.left;
		 if (b.left != null) {
			 b.left.right = b;			 
		 }
	 }
	 
	 private void mergeRightToLeft(Node a, Node b) {
		 a.width += b.width;
		 a.height = b.height;
		 a.right = b.right;
		 if (a.right != null) {
			 a.right.left = a;			 
		 }
	 }	 
	 
	 public int trap(int[] height) {
		 
		 int res = 0;
		 Node root = null;
		 Node last = null;
		 
		 for (int i = 0; i < height.length; i++) {
			 int elem = height[i];
			 if (root == null && elem > 0) {
				 root = new Node(elem);
				 last = root;
			 }
			 else if (root != null) {
				 Node next = new Node(elem);
				 last.right = next;
				 next.left = last;
				 last = next;
			 }          			 			
		 }
		 
		 if (root == null || root.right==null) {
			 return 0;
		 }
		 
		 Node curr = root;
		 while (curr != null) {

			 int val = curr.height;
			 if (curr.left == null) {
				 curr = curr.right;
			 }
			 else if (curr.left != null) {
				 
				 if (curr.left.height == curr.height) {
					 mergeLeftToRight(curr.left, curr);
				 }
				 
				 else if (curr.left.height > curr.height) {
					 if (curr.right != null && curr.right.height > curr.height) {

						 int h = Math.min(curr.left.height, curr.right.height);
						 h -= curr.height;
						 int w = curr.width;
						 res += (h * w);					 

						 if (curr.left.height <= curr.right.height) {
							 mergeLeftToRight(curr.left, curr);
						 }
						 else {
							 mergeRightToLeft(curr, curr.right);
						 }
						 
					 }
					 else {
						 curr = curr.right;
					 }
				 }				 
				 else {
					 curr = curr.right;
				 }
			 }
		 }
		 
		 return res;
	 }	 
}
