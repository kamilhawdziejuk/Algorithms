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

    vector< set<int> > state;
    unordered_map<int, int> positions;

	int getPosition(vector<int>& stones, int stone)
	{
		auto f = positions.find(stone);
		if (f != positions.end())
		{
			return f->second;
		}
		return -1;
	}

    void init(vector<int>& stones)
    {
    	int n = stones.size();
    	for (int i = 0; i < n; i++)
    	{
    		set<int> empty;
    		state.push_back(empty);
    	}
    	state[0].insert(1);

    	for (int i = 0; i < n; i++)
    	{
    		positions.insert(pair<int, int>(stones[i], i));
    	}
    }

    //https://leetcode.com/problems/frog-jump/
    bool canCross(vector<int>& stones) {
    	int n = stones.size();
    	init(stones);

    	int lastStone = stones[n-1];
    	for (int i = 0; i < n; i++)
    	{
    		for (auto step : state[i])
    		{
    			int current = stones[i];
    			int next = current + step;
    			if (next == lastStone) return true;
    			int posOfNext = getPosition(stones, next);
    			if (posOfNext > 0)
    			{
    				if (step-1 > 0)
    				{
    					state[posOfNext].insert(step-1);
    				}
    				state[posOfNext].insert(step);
    				state[posOfNext].insert(step+1);
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
