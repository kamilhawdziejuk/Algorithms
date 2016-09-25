//#include "stdafx.h"
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
#include <set>
#include <unordered_map>

typedef long long uint64;
const uint64 D = 1000000000 + 7;
using namespace std;

unordered_map<uint64, uint64> map;
uint64 N;
vector<uint64> vec;

void genPowers()
{
	map.insert(pair<uint64, uint64>(-1, 1));
	uint64 num = 1;
	for (uint64 i = 0; i <= N + 1; i++)
	{
		map.insert(pair<uint64, uint64>(i, num));
		num = (num * 2) % D;
	}
}

uint64 mulmod(uint64 a, uint64 b) {
	uint64 rv = 0;
	while (b) {
		if (b & 1)
			if ((rv += a) >= D) rv -= D;
		if ((a += a) >= D) a -= D;
		b >>= 1;
	}
	return rv;
}

uint64 sum(uint64 a, uint64 b)
{
	return (a + b) % D;
}

uint64 calc(uint64 k, uint64 n, uint64 m)
{
	uint64 res = 0;
	int i = 1;
	int j = k;
	uint64 cnt = 0;
	if (m - k - 1 >= 0 && n - k - 1 >= 0)
	{
		cnt = k;
	}
	else
	{
		while (i <= k)
		{
			if (n - i < -1)
			{
				break;
			}
			else
			{
				int j = k - i + 1;
				if (m - j >= 0 && n - i >= 0)
				{
					cnt++;
				}
				else if (m - j >= -1)
				{
					res = sum(res, (mulmod(map[n - i], map[m - j])));
				}
				i++;
			}
		}
	}
	res = sum(res, (mulmod(map[n + m - k - 1], cnt)));
	return res;
}

int main() {

	uint64 result = 0;
	cin >> N;
	uint64 d;
	for (uint64 i = 0; i < N; i++)
	{
		cin >> d;
		vec.push_back(d);
	}

	genPowers();

	for (uint64 i = 0; i < N; i++)
	{
		uint64 n = i;
		uint64 m = N - i - 1;
		uint64 res = 0;
		for (int k = 1; k <= N; k++)
		{
			uint64 tmp = calc(k, n, m);
			res = sum(res, mulmod(k, tmp));
		}
		result = sum(result, mulmod(vec[i], res));
	}
	cout << result;
	return 0;
}

