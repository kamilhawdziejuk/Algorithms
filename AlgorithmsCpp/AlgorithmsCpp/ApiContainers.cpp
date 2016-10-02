#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <queue>
#include <map>
#include <functional>
#include <set>

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

	//https://leetcode.com/problems/clone-graph/
	unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> map;
	UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
		if (!node) return NULL;
		if (map.find(node) == map.end()) {
			map[node] = new UndirectedGraphNode(node->label);
			for (UndirectedGraphNode* neigh : node->neighbors)
				map[node]->neighbors.push_back(cloneGraph(neigh));
		}
		return map[node];
	}

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
	
	}

	void strings()
	{
		string str;
		str.substr(1, str.size());
	}

};

