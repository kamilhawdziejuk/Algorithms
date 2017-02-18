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
class LargestRectangle {
public:

	//https://leetcode.com/problems/largest-rectangle-in-histogram
	//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram
	int largestRectangleArea(vector<int>& height) {
		height.insert(height.begin(), 0); // dummy "0" added to make sure stack s will never be empty
		height.push_back(0); // dummy "0" added to clear the stack at the end
		int len = height.size();
		int i, res = 0, idx;
		stack<int> s; // stack to save "height" index
		s.push(0); // index to the first dummy "0"
		for (i = 1; i<len; i++)
		{
			while (height[i]<height[idx = s.top()]) // if the current entry is out of order
			{
				s.pop();
				res = max(res, height[idx] * (i - s.top() - 1)); // note how the width is calculated, use the previous index entry
			}
			s.push(i);
		}
		height.erase(height.begin()); // remove two dummy "0"
		height.pop_back();
		return res;
	}
};
int mainLargest()
{
	shared_ptr<LargestRectangle> p = make_shared<LargestRectangle>();
	vector<int> height = { 1, 2, 3, 4, 5, 4, 3 };
	p->largestRectangleArea(height);
	return 0;
}
