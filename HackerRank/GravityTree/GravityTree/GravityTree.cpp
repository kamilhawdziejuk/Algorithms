//#include "stdafx.h"

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;

int n, q;
long sum;
unordered_map<int, int> parents;
unordered_map<int, vector<int>> graph;
unordered_map<int, int> heigh;
unordered_map<int, bool> visited;
bool uvisited = false;

void readGraph()
{
	int d;
	parents.emplace(1, 0);
	cin >> n;
	vector<int> data;
	for (int i = 2; i <= n; i++)
	{
		cin >> d;//i has parent d
		data.push_back(d);
	}

	for (int i = 2; i <= data.size() + 1; i++)
	{
		d = data[i - 2];
		parents.emplace(i, d);
		if (graph.find(d) != graph.end())
		{
			graph[d].push_back(i);
		}
		else
		{
			vector<int> v;
			v.push_back(i);
			graph.emplace(d, v);
		}
	}
}


void calcHeigh(int p, int h)
{
	heigh.emplace(p, h);
	for (auto next : graph[p])
	{
		calcHeigh(next, h + 1);
	}
}

void visit(int v)
{
	visited.emplace(v, true);
	for (auto next : graph[v])
	{
		visit(next);
	}

}

bool checkUinV(int u, int v)
{
	while (heigh[v] < heigh[u])
	{
		u = parents[u];
	}
	return u == v;
}

int calcDist(int u, int v)
{
	int res = 0;
	if (u == v) return res;
	while (heigh[u] < heigh[v])
	{
		res++;
		v = parents[v];
	}
	while (heigh[v] < heigh[u])
	{
		res++;
		u = parents[u];
	}
	while (u != v)
	{
		res += 2;
		v = parents[v];
		u = parents[u];
	}
	return res;
}

void bfs(int u, int v)
{
	int d = calcDist(v, u);
	sum += (d * d);
	for (auto next : graph[v])
	{
		bfs(u, next);
	}
}

void bfsCalculated(int u, int v)
{
	int d;
	/*if (heigh[u] < heigh[v])
	{
	d = heigh[u] - heigh[v];
	}
	else*/
	{
		d = calcDist(v, u);
	}
	sum += (d * d);
	for (auto next : graph[v])
	{
		bfsCalculated(u, next);
	}
}


void calcQueries()
{
	cin >> q;
	int u, v;
	for (int i = 0; i < q; i++)
	{
		cin >> u;
		cin >> v;
		sum = 0;
		if (!checkUinV(u, v))
		{
			bfs(u, v);
		}
		else
		{
			bfsCalculated(u, v);
		}
		cout << sum << endl;
	}
}

int main()
{
	readGraph();
	calcHeigh(1, 0);
	calcQueries();
	return 0;
}