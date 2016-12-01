#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <queue>
#include <map>
#include <functional>
#include <set>
#include <stack>
#include <cstddef>

using namespace std;

 struct UndirectedGraphNode {
	 int label;
	 vector<UndirectedGraphNode *> neighbors;
	 UndirectedGraphNode(int x) : label(x) {};
 };


#pragma once
class ApiContainers
{
public:
	ApiContainers() {}
	~ApiContainers() {}

	void sets()
	{
		set<int> set1;
		set1.insert(2);
		set1.find(2);
	}

	void maps()
	{
		unordered_map<int, int> map;
		map.insert(pair<int, int> (1, 2));
		map.find(2);
		if (map.find(3) == map.end())
		{
			
		}
	}

	void strings()
	{
		string str;
		str.substr(1, str.size());
		str.clear();
		str.find_first_not_of("ab");
		str.find_first_of("ab");
		str.insert(0, 1, 'a');
		str.append("a");
		str += 'b';
	}

	void stacks()
	{
		stack<int> st;
		st.push(2);
		int res = st.top();
		st.pop();
	}

	void vectors()
	{
		vector<int> vec;
		vec.push_back(2);
		vec.push_back(3);
		
		//count values == 2
		count(vec.begin(), vec.end(), 2);

		//count divisable by 3
		int num_items3 = count_if(vec.begin(), vec.end(), [](int i) {return i % 3 == 0; });
	}

};

