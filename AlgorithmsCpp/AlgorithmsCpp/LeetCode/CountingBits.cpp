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

class CountintBits {
public:
	//https://leetcode.com/problems/counting-bits/
	/*Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
	 *  the number of 1's in their binary representation and return them as an array.*/
	vector<int> countBits(int num) {
		vector<int> solutions;
		solutions.push_back(0);
		if (num == 0)
		{
		    return solutions;
		}

		solutions.push_back(1);
		for (int nr = 2; nr <= num; nr++)
		{
			int val = 0;
			if (nr % 2 == 0)
			{
			    val = solutions[nr/2];
			}
			else
			{
			    val = solutions[nr-1]+1;
			}
			solutions.push_back(val);
		}
		return solutions;
	}
};

int main()
{
	CountintBits *p = new CountintBits();
	p->countBits(4);
	delete p;
	return 0;
}
