#include "stdafx.h"


#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;
vector<string> matrix;
int n;


bool isFree(int r, int c)
{
	return (matrix[r][c] == '.');
}

double dist(double a, double b, double x, double y)
{
	return sqrt(pow(a - x, 2) + pow(b - y, 2));
}

bool test(int r, int c, int K)
{
	double k = K;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (dist(r, c, i, j) <= k)
			{
				if (!(isFree(i, j))) return false;
			}
		}
	}
	return true;
}

bool test2(int r, int c, int k)
{
	int r0 = r - k;
	int rn = r + k;
	int c0 = c - k;
	int cn = c + k;

	if (!(r0 >= 0 && rn < n && c0 >= 0 && cn < n))
	{
		return false;
	}
	for (int j = c0; j <= cn; j++)
	{
		if (dist(r, c, r0, j) <= k)
		{
			if (!(isFree(r0, j))) return false;
		}
	}
	for (int j = c0; j <= cn; j++)
	{
		if (dist(r, c, rn, j) <= k)
		{
			if (!(isFree(rn, j))) return false;
		}
	}
	for (int i = r0; i <= rn; i++)
	{
		if (dist(r, c, i, c0) <= k)
		{
			if (!(isFree(i, c0))) return false;
		}
	}
	for (int i = r0; i <= rn; i++)
	{
		if (dist(r, c, i, cn) <= k)
		{
			if (!(isFree(i, cn))) return false;
		}
	}
	return true;
}


int calcR(int r, int c)
{
	int R = -1;
	for (int k = 0; k <= n / 2 + 1; k++)
	{
		if (test(r, c, k))
		{
			R++;
		}
		else break;
	}
	return R;
}


void read()
{
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		matrix.push_back(s);
	}
}

int calc(vector<string>& matrix)
{
	int maxR = -1;
	for (int r = 0; r < n; r++)
	{
		for (int c = 0; c < n; c++)
		{
			maxR = max(maxR, calcR(r, c));
		}
	}
	return maxR;
}


int main() {
	read();
	cout << calc(matrix);
	return 0;
}
