#include <cassert>
#include <iostream>
#include <istream>
#include <fstream>
#include <algorithm>
#include <cstdio>
#include <complex>
#include <vector>
#include <set>
#include <map>
#include <cmath>
#include <queue>
#include <string>
#include <cstdlib>
#include <memory>
#include <ctime>
#include <bitset>
#include <queue>
#include <stack>
#include <unordered_map>
#include <unordered_set>
#include <bitset>

using namespace std;

class Combinatorics {
public:
	int combination(int N, int k)
	{
		double res = 1;
		// Combination(N, k) = n! / (k!(n - k)!)
		// reduce the numerator and denominator and get
		// C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
		for (int i = 1; i <= k; i++)
			res = res * (N - k + i) / i;
		return (int)res;
	}
};
