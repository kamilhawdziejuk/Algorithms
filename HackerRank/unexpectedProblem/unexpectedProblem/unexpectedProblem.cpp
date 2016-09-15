#include "stdafx.h"
//https://www.hackerrank.com/contests/w23/challenges/commuting-strings
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int n, m;
string s;

int findSuffix()
{
	for (int i = 1; i <= n / 2; i++)
	{
		string s1 = s.substr(0, i);
		string s2 = s.substr(n - i, i);
		if (s1 == s2) return i;
	}
	return n;
}

bool checkSuffix(int size)
{
	string s0 = s.substr(0, size);
	for (int i = 0; i <= n - size; i += size)
	{
		if (s.substr(i, size) != s0) return false;
	}
	return true;
}

int main() {
	cin >> m;
	cin >> s;
	n = s.size();
	int size = findSuffix();
	if (size != n)
	{
		if (!checkSuffix(size))
		{
			size = n;
		}
	}

	cout << m / size;
	return 0;
}


