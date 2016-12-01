#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <cmath>
#include <map>
#include <unordered_map>
#include <stack>

using namespace std;

class Graphs
{
public:
	Graphs() {}
	~Graphs() {}
	
	//https://leetcode.com/problems/clone-graph/
/*	unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> map;
	UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
		if (!node) return NULL;
		if (map.find(node) == map.end()) {
			map[node] = new UndirectedGraphNode(node->label);
			for (UndirectedGraphNode* neigh : node->neighbors)
				map[node]->neighbors.push_back(cloneGraph(neigh));
		}
		return map[node];
	}*/
	
};
