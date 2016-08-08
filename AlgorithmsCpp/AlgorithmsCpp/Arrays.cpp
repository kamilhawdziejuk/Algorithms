#include "stdafx.h"
#include <vector>
#include <unordered_map>


class Arrays
{
public:
	Arrays() {};
	~Arrays() {};

	//https://leetcode.com/problems/intersection-of-two-arrays/
	vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
		unordered_map<int, int> hashmap;
		for (auto i : nums1) {
			hashmap[i] = 1;
		}
		for (auto i : nums2) {
			if (hashmap.find(i) != hashmap.end()) {
				hashmap[i] = 2;
			}
		}
		vector<int> r;
		for (auto i : hashmap) {
			if (i.second == 2) {
				r.push_back(i.first);
			}
		}
		return r;
	}
};