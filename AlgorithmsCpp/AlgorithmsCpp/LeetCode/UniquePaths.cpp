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

#include "../Combinatorics.cpp"

using namespace std;

class UniquePaths {
public:
	//https://leetcode.com/problems/unique-paths/
	//How many possible unique paths are there moving from left to right, from top to down?
    int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        vector< int > tab;
        for (int i = 0; i < n; i++) tab.push_back(1);

        for (int j = 1; j < m; j++)
        {
            int val = 1;
            for (int i = n-2; i>=0; i--)
            {
                tab[i] = val + tab[i];
                val = tab[i];
            }
        }
        return tab[0];
    }

    int uniquePathsOptimal(int m, int n) {
    	shared_ptr<Combinatorics> c(new Combinatorics());
    	return c->combination(n+m-2, m-1);
    }
};

int mainUniquePaths()
{
	UniquePaths *p = new UniquePaths();
	int m = 3;
	int n = 3;
	int res = p->uniquePaths(m,n);
	delete p;
	return 0;
}
