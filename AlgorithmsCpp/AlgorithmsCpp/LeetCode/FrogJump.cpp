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

class FrogJump {
public:

	int position(vector<int>& vec, int item)
	{
		auto f = find(vec.begin(), vec.end(), item);
		if (f != vec.end())
		{
			return f-vec.begin();
		}
		return -1;
	}

    vector< vector<int> > state;

    void init(int n)
    {
    	for (int i = 0; i < n; i++)
    	{
    		vector<int> empty;
    		state.push_back(empty);
    	}
    	state[0].push_back(1);
    }

    void tryAdd(vector<int>& vec, int item)
    {
    	if (position(vec, item) == -1) {
    		vec.push_back(item);
    	}
    }

    //https://leetcode.com/problems/frog-jump/
    bool canCross(vector<int>& stones) {
    	int n = stones.size();
    	init(n);

    	int lastStone = stones[n-1];
    	for (int i = 0; i < n; i++)
    	{
    		//for (auto step : state[i])
    		for (int j = 0; j < state[i].size(); j++)
    		{
    			int current = stones[i];
    			int step = state[i][j];
    			int next = current + step;
    			if (next == lastStone) return true;
    			int posOfNext = position(stones, next);
    			if (posOfNext > 0)
    			{
    				if (step-1 > 0)
    				{
    					tryAdd(state[posOfNext], step-1);
    				}
    				tryAdd(state[posOfNext], step);
    				tryAdd(state[posOfNext], step+1);
    			}
    		}
    	}

    	return false;
    }

};

int main()
{
	FrogJump *p = new FrogJump();
	vector<int> stones = {0,1,3,5,6,8,12,17};
	bool result = p->canCross(stones);
	delete p;
	return 0;
}
