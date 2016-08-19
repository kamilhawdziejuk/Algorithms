#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <unordered_map>


class Arrays
{
public:
	Arrays() {};
	~Arrays() {};
	
	//https://leetcode.com/problems/find-the-duplicate-number/
	//O(n)
	int findDuplicate(vector<int>& nums) 
	{
		int slow = 0;
		int fast = 0;
		int finder = 0;

		while (true)
		{
			slow = nums[slow];
			fast = nums[nums[fast]];

			if (slow == fast)
				break;
		}
		while (true)
		{
			slow = nums[slow];
			finder = nums[finder];
			if (slow == finder)
				return slow;
		}
	}
	
	//https://leetcode.com/problems/find-the-duplicate-number/
	//O(nlogn)
	int findDuplicateBinarySearch(vector<int>& nums) {
		int n = nums.size(), i = 0, counter = 0;
		int left = 1, right = n - 1, mid = 0;
		
		while (left < right)
		{
			mid = left + (right - left) / 2;
			
			counter = 0;
			for (i = 0; i < n; ++i)
			{
				if (nums[i] <= mid)
					++counter;
			}
			
			if (counter > mid)
				right = mid;
			else 
				left = mid + 1;
		}
		
		return left;
	}
	
	//https://leetcode.com/problems/find-the-duplicate-number/
	//O(32n)
	int findDuplicateUsingBits(vector<int>& nums)
	{
		int n = nums.size()-1, res = 0;
		for (int p = 0; p < 32; ++ p) {
			int bit = (1 << p), a = 0, b = 0;
			for (int i = 0; i <= n; ++ i) {
				if (i > 0 && (i & bit) > 0) ++a;
				if ((nums[i] & bit) > 0) ++b;
			}
			if (b > a) res += bit;
		}
		return res;
	}

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

	//https://leetcode.com/problems/rotate-array/
	void rotate(vector<int>& nums, int k) 
	{
		int n = nums.size();
		if (n <= 1 || k == 0) return;

		vector<bool> moved(n);
		for (int i = 0; i < n; ++i) moved[i] = false;

		int ind = k % n;
		int tmp = nums[ind];
		int last = nums[0];
		for (int i = 0; i < n; ++i)
		{
			if (!moved[i])
			{
				ind = (i + k) % n;
				tmp = nums[ind];
				last = nums[i];

				while (!moved[ind])
				{
					nums[ind] = last;
					moved[ind] = true;
					last = tmp;
					ind = (ind + k) % n;
					tmp = nums[ind];
				}
				nums[ind] = last;
			}
		}
	}

	//https://leetcode.com/problems/rotate-array/
	void rotateOptimal(int nums[], int n, int k) {
		reverse(nums, nums + n);
		reverse(nums, nums + k%n);
		reverse(nums + k%n, nums + n);
	}

	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	int maxProfit(vector<int>& prices) {
		int n = prices.size();
		if (n <= 1) return 0;
		int minim = prices[0];
		int maxim = 0;
		for (int i = 1; i < n; ++i)
		{
			if (prices[i] < minim) minim = prices[i];
			if (prices[i] - minim > maxim) maxim = prices[i] - minim;
		}
		return maxim;
	}
};