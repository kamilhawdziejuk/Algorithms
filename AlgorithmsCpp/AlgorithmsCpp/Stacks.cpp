#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <cmath>
#include <map>
#include <unordered_map>
#include <stack>

using namespace std;

class Stacks
{
public:
	Stacks() {}
	~Stacks() {}

	//https://leetcode.com/problems/valid-parentheses/
	bool isValid(string s) 
	{
		stack<char> stack;
		map < char, char > map;
		map[')'] = '(';
		map[']'] = '[';
		map['}'] = '{';
		
		for (auto c : s)
		{
			if (c == '(' || c == '{' || c == '[')
			{
				stack.push(c);
			}
			else if (c == ')' || c == '}' || c == ']')
			{
				if (stack.empty()) return false;
				char top = stack.top();
				if (top == map[c])
				{
					stack.pop();
				}
				else
				{
					return false;
				}
			}
		}
		return stack.empty();
	}
};
