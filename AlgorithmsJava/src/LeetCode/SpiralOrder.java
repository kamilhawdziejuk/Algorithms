//https://leetcode.com/problems/spiral-matrix/

package LeetCode;

import java.util.*;

public class SpiralOrder {

	public static void main(String [ ] args)
	{
		int[][] tab = new int[5][5];
		tab[0] = new int[] {1,2,3,4,5};
		tab[1] = new int[] {6,7,8,9,10};
		tab[2] = new int[] {11,12,13,14,15};
		tab[3] = new int[] {16,17,18,19,20};
		tab[4] = new int[] {21,22,23,24,25};
		
		
		SpiralOrder sol = new SpiralOrder();
		sol.spiralOrder(tab);		
	}
	
	class Boundary {
		public int Left;
		public int Right;
		public int Top;
		public int Bottom;
	}

	class Position {
		public int X;
		public int Y;
	}

	enum Dir {
		Right, Down, Left, Up
	}

	private Position nextPos(Position pos) {
		Position res = new Position();
		res.X = pos.X;
		res.Y = pos.Y;
		if (dir == Dir.Right) {
			if (res.X < bound.Right) {
				res.X++;				
			}
			else {
				bound.Top++;
				dir = Dir.Down;
				res.Y++;
			}
		}
		else if (dir == Dir.Down) {
			if (res.Y < bound.Bottom) {
				res.Y++;				
			}
			else {
				bound.Right--;
				dir = Dir.Left;
				res.X--;
			}
		}
		else if (dir == Dir.Left) {
			if (res.X > bound.Left) {
				res.X--;				
			}
			else {
				bound.Bottom--;
				dir = Dir.Up;
				res.Y--;
			}
		}
		else if (dir == Dir.Up) {
			if (res.Y > bound.Top) {
				res.Y--;				
			}
			else {
				bound.Left++;
				dir = Dir.Right;
				res.X++;
			}
		}
		return res;
	}


	private Boundary bound = new Boundary();
	private Dir dir = Dir.Right;

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0) {
			return res;
		}	
		
		int rows = matrix.length;
		int cols = matrix[0].length;

		bound.Left = 0;
		bound.Right = cols - 1;
		bound.Top = 0;
		bound.Bottom = rows - 1;

		Position pos = new Position();
		pos.X = 0;
		pos.Y = 0;

		for (int i = 0; i < rows * cols; i++) {
			int val = matrix[pos.Y][pos.X];
			res.add(val);
			pos = nextPos(pos);
		}
		return res;
	}
}
