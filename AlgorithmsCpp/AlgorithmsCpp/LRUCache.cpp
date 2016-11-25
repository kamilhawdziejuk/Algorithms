#include "stdafx.h"

#include <cstdlib>
#include <vector>
#include <algorithm>
#include <cmath>
#include <map>
#include <tr1/unordered_map>
#include <list>

using namespace std;

//https://leetcode.com/problems/lru-cache/
class LRUCache
{
private:
	int capacity;
	list<int> recent;
	tr1::unordered_map<int, int> cache;
	tr1::unordered_map<int, list<int>::iterator> pos;

	void use(int key)
	{
		if (pos.find(key) != pos.end())
		{
			recent.erase(pos[key]);
		}
		else if (recent.size() >= capacity)
		{
			int old = recent.back();
			recent.pop_back();
			cache.erase(old);
			pos.erase(old);
		}
		recent.push_front(key);
		pos[key] = recent.begin();
	}

public:
	LRUCache(int capacity): capacity(capacity) {}
	~LRUCache() {}

	int get(int key)
	{
		if (cache.find(key) != cache.end())
		{
			use(key);
			return cache[key];
		}
		return -1;
	}

	void set(int key, int value)
	{
		use(key);
		cache[key] = value;
	}

};

