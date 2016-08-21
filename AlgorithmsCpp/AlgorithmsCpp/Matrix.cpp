#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <cmath>
#include <map>
#include <cstdint>
#include <unordered_map>
#include <string>
#include <bitset>

class Matrix
{
public:
	Matrix() {}
	~Matrix() {}

	int xMin;
	int xMax;
	int yMin;
	int yMax;
	int dirX = 1;
	int dirY = 0;
	int x = 0;
	int y = 0;

	//https://leetcode.com/problems/spiral-matrix/
	vector<int> spiralOrder(vector<vector<int>>& matrix) {
		vector<int> res;

		int m = matrix.size(); //rows
		if (m == 0) return res;
		int n = matrix[0].size(); //cols
		if (n == 0) return res;
		
		xMin = 0;
		xMax = n - 1;
		yMin = 0;
		yMax = m - 1;

		int cnt = 1;
		res.push_back(matrix[0][0]);
		while (cnt < m*n)
		{
			nextPos(x, y);
			res.push_back(matrix[y][x]);
			cnt++;
		}
		return res;
	}

	void nextPos(int& x, int& y)
	{
		if (dirX == 1)
		{
			if (x < xMax)
			{
				x++;
			}
			else
			{
				y++;
				dirX = 0;
				dirY = 1;
				yMin++;
			}
		}
		else if (dirX == -1)
		{
			if (x > xMin)
			{
				x--;
			}
			else
			{
				y--;
				dirX = 0;
				dirY = -1;
				yMax--;
			}
		}
		else
		{
			if (dirY == 1)
			{
				if (y < yMax)
				{
					y++;
				}
				else
				{
					x--;
					dirX = -1;
					xMax--;
					dirY = 0;
				}
			}
			else //dirY == -1
			{
				if (y > yMin)
				{
					y--;
				}
				else
				{
					x++;
					dirX = 1;
					dirY = 0;
					xMin++;
				}
			}
		}
	}
};

