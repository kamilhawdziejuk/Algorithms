package LeetCode;

public class SpiralMatrix2 {
    
	int dir = 2;
	int minX, maxX, minY, maxY;
	
	public int[][] generateMatrix(int n) {
		//if (n < 1) return null;
		int[][] tab = new int[n][n];
			
		minX = 0;
		minY = 0;
		maxX = n-1;
		maxY = n-1;
		int x = 0;
		int y = 0;
		for (int i = 1; i <= n*n; i++)
		{
			tab[y][x] = i;
			if (i < n*n)
			{
				int[] next = getNext(x,y);
				x = next[0];
				y = next[1];
			}
		}
		return tab;
    }
	
	//-1 down, +1 up, -2 left, +2 right
	int[] getNext(int x, int y)
	{
		int[] next = new int[2];
		if (dir == 2)
		{
			if (x < maxX)
			{
				next[0] = x+1;
				next[1] = y;
			}
			else
			{
				minY++;
				dir = -1;
				next = getNext(x,y);
			}
		}
		else if (dir == -2)
		{
			if (x > minX)
			{
				next[0] = x-1;
				next[1] = y;
			}
			else
			{
				maxY--;
				dir = 1;
				next = getNext(x,y);
			}
		}
		else if (dir == -1)
		{
			if (y < maxY)
			{
				next[0] = x;
				next[1] = y+1;
			}
			else
			{
				dir = -2;
				maxX--;
				next = getNext(x,y);
			}
		}
		else if (dir == 1)
		{
			if (y > minY)
			{
				next[0] = x;
				next[1] = y-1;
			}
			else
			{
				dir = 2;
				minX++;
				next = getNext(x,y);
			}
		}
				
		return next;
	}
}
