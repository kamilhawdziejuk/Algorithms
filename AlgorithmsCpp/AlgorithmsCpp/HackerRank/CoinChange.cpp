//https://www.hackerrank.com/challenges/coin-change
//How many different ways can you make change for an amount, given a list of coins?

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

class CoinChange
{
public:

	int countWays(vector<int>& coins, int m, int n)
	{
		vector<int> table;
        for (int i = 0; i <= n; i++)
        {
        	table.push_back(0);
        }

        table[0]=1;
		for (int i = 0; i < m; i++)
		{
			for (int j = coins[i]; j<=n; j++)
			{
				table[j] += table[j - coins[i]];
			}
		}
		return table[n];
	}

	int Solve()
	{
    	int N, m;
    	vector<int> coins;

        cin >> N >> m;
        int d;
        for (int i = 0; i < m; i++){
            cin >> d;
            coins.push_back(d);
        }

        int result = countWays(coins, m, N);

        return 0;
	}
};



int main() {
	CoinChange *p = new CoinChange();
	p->Solve();
	delete p;
    return 0;
}
