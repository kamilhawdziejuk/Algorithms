#include "stdafx.h"
#include <vector>
#include <algorithm>
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

	//https://leetcode.com/problems/contains-duplicate-ii/
	bool containsNearbyDuplicate(vector<int>& nums, int k) {
		unordered_map<int, vector<int>> map;

		for (int i = 0; i < nums.size(); i++)
		{
			map[nums[i]].push_back(i);
		}

		for (auto m : map)
		{
			if (m.second.size() > 1)
			{
				sort(m.second.begin(), m.second.end());
				for (int i = 0; i < m.second.size() - 1; i++)
				{
					if (abs(m.second[i] - m.second[i + 1]) <= k) return true;
				}
			}
		}
		return false;
	}

	//https://leetcode.com/problems/contains-duplicate-ii/
	bool containsNearbyDuplicateOptimal(vector<int>& nums, int k) {
		unordered_map<int, int> count;
		for (int i = 0; i<nums.size(); i++)
		{
			if (count[nums[i]] && i - count[nums[i]] < k) return true;
			count[nums[i]] = i + 1;
		}
		return false;
	}

	//https://leetcode.com/problems/maximum-subarray/
	int maxSubArray(vector<int>& nums) {
		int n = nums.size();
		if (n == 0) return 0;
		int prev = nums[0];
		int m = nums[0];
		for (int i = 1; i < n; i++)
		{
			int curr = max(nums[i], prev + nums[i]);
			m = max(m, curr);
			prev = curr;
		}
		return m;
	}
};