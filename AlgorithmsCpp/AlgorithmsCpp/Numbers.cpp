#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <cmath>
#include <map>
#include <cstdint>
#include <cstdlib>
#include <unordered_map>
#include <string>
#include <bitset>
#include <climits>
#include <string>

using namespace std;

class Numbers
{
public:
	Numbers() {};
	~Numbers() {};


	//https://leetcode.com/problems/count-primes/
	int countPrimes(int n) {
		vector<bool> sieve(n + 2);
		sieve[0] = true;
		sieve[1] = true;
		int i = 2;
		while (i*i <= n)
		{
			if (!sieve[i])
			{
				int k = i*i;
				while (k <= n)
				{
					sieve[k] = true;
					k += i;
				}
			}
			i += 1;
		}
		int cnt = 0;
		for (int j = 1; j < n; ++j)
		{
			if (!sieve[j]) cnt++;
		}
		return cnt;
	}

	//https://leetcode.com/problems/merge-sorted-array/
	void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int nr = n + m - 1;
		while (i >= 0 && j >= 0)
		{
			if (nums1[i] > nums2[j]) 
			{
				nums1[nr--] = nums1[i--];
			}
			else
			{
				nums1[nr--] = nums2[j--];
			}
		}
		while (i >= 0)
		{
			nums1[nr--] = nums1[i--];
		}

		while (j >= 0)
		{
			nums1[nr--] = nums2[j--];
		}
	}

	//https://en.wikipedia.org/wiki/Dutch_national_flag_problem
	////https://leetcode.com/problems/sort-colors/
	void sortColors2(vector<int>& nums) {
		int i = 0, j = i, k = nums.size() - 1;

		while (j <= k){
			if (nums[j] == 0) swap(nums[i++], nums[j++]);
			else if (nums[j] == 1) j++;
			else swap(nums[k--], nums[j]);
		}
	}

	//https://leetcode.com/problems/sort-colors/
	void sortColors(vector<int>& nums) {
		int reds = 0;
		int whites = 0;
		int blues = 0;
		for (int i = 0; i < nums.size(); ++i)
		{
			int color = nums.at(i);
			if (color == 0) reds++;
			if (color == 1) whites++;
			if (color == 2) blues++;
		}
		nums.clear();
		for (int i = 0; i < reds; i++) nums.push_back(0);
		for (int i = 0; i < whites; i++) nums.push_back(1);
		for (int i = 0; i < blues; i++) nums.push_back(2);
	}
		
	//https://leetcode.com/problems/add-digits/
	int addDigits(int num)
	{
		if (num % 9 == 0 && num != 0) return 9;
		else return num % 9;
	}

	//https://leetcode.com/problems/ugly-number/
	bool isUgly(int num) {
		if (num == 0) return false;
		while (num % 2 == 0) num /= 2;
		while (num % 3 == 0) num /= 3;
		while (num % 5 == 0) num /= 5;
		return num == 1;
	}

	//https://leetcode.com/problems/majority-element/
	int majorityElement(vector<int>& nums) {
		int major = nums.at(0), count = 1;
		for (int i = 1; i<nums.size(); i++){
			if (count == 0){
				count++;
				major = nums.at(i);
			}
			else if (major == nums.at(i)){
				count++;
			}
			else count--;
		}
		return major;
	}
	
	//https://leetcode.com/problems/majority-element/
	int majorityElementNlogN(vector<int>& nums) {

		sort(nums.begin(),nums.end());
		return nums[nums.size() / 2];
	}

	//https://leetcode.com/problems/excel-sheet-column-number/
	int titleToNumber(string s) {
		int size = s.length();
		int p = size - 1;
		int res = 0;
		for (int i = 0; i < size; i++)
		{
			int num = s.at(i) - 'A' + 1;
			int d = pow(26, p--);
			res += (num * d);
		}
		return res;
	}

	//https://leetcode.com/problems/reverse-integer/
	int reverse(int x) {
		if (x == 0) return 0;
		int sign = x > 0 ? 1 : -1;
		x *= sign;
		string s = std::to_string(x);
		std::reverse(s.begin(), s.end());
		int res = 0;
		try
		{
			res = sign * std::stoi(s);
		}
		catch (const std::exception&)
		{
			res = 0;
		}
		return res;
	}

	//https://leetcode.com/problems/reverse-integer/
	int reverseIntAlg(int x) {
		long returnInt = 0;
		while (x)
		{
			returnInt = returnInt * 10 + x % 10;
			x /= 10;
		}
		if (returnInt>0)
			return returnInt > INT_MAX ? 0 : returnInt;
		else return returnInt < INT_MIN ? 0 : returnInt;
	}

	//https://leetcode.com/problems/contains-duplicate/
	bool containsDuplicate(vector<int>& nums) {
		unordered_map<int, int> dict;

		for (int i = 0; i < nums.size(); i++)
		{
			int x = nums.at(i);
			dict[x]++;
			if (dict[x] >= 2)
			{
				return true;
			}
		}
		return false;
	}

	//https://leetcode.com/problems/roman-to-integer/
	int romanToInt(string s) {
		int n = s.length();

		map<char, int> roman;
		roman['I'] = 1;
		roman['V'] = 5;
		roman['X'] = 10;
		roman['L'] = 50;
		roman['C'] = 100;
		roman['D'] = 500;
		roman['M'] = 1000;

		int res = 0;
		for (int i = 0; i < n; i++)
		{
			char c = s.at(i);
			if (i < n - 1)
			{
				char d = s.at(i + 1);
				if (roman[c] < roman[d])
				{
					res += (roman[d] - roman[c]);
					i++;
				}
				else
				{
					res += roman[c];
				}
			}
			else
			{
				res += roman[c];
			}
		}
		return res;
	}

	//https://leetcode.com/problems/number-of-1-bits/
	int hammingWeight(int number)
	{
		int result;
		do
		{
			if ((number & 1) != 0)
				result++;

			number >>= 1;
		} while (number);

		return result;
	}

	//https://leetcode.com/problems/number-of-1-bits/
	int hammingWeightRecursive(int n) {
		if (n>0)
			return n % 2 == 1 ? 1 + hammingWeightRecursive(n / 2) : hammingWeightRecursive(n / 2);
		else
			return 0;
	}

	bool is_power_of_2(int x)
	{
		return !(x == 0) && !(x & (x - 1));
	}

	string DecToBin2(int number)
	{
		string result = "";

		do
		{
			if ((number & 1) == 0)
				result += "0";
			else
				result += "1";

			number >>= 1;
		} while (number);

		std::reverse(result.begin(), result.end());
		return result;
	}
	
	
	string Dec2ToBin2BitSet(int number)
	{
		string binary = std::bitset<32>(number).to_string();
		int posNot0 = binary.find_first_not_of('0');
		return binary.substr(posNot0, binary.size() - posNot0);
	}

	unsigned long Bin2DecBitset(string binary)
	{
		unsigned long decimal = std::bitset<32>(binary).to_ulong();
		return decimal;
	}

	//https://leetcode.com/problems/decode-ways/
	int numDecodings(string s) {
		int n = s.size();
		if (n == 0) return 0;
		vector<int> v(n);
		int i = n - 1;
		while (i >= 0)
		{
			int sum1 = 0;
			int d0 = s[i] - '0';
			int d1 = (i + 1 < s.size()) ? s[i + 1] - '0' : -10;
			if (d0 > 0 && d1 > 0) sum1 = v[i + 1];
			
			int sum2 = 0;
			int l = d0 * 10 + d1;
			if (l > 9 && l < 27)
			{
				if (i + 2 < s.size()) sum2 = v[i + 2];
				else sum2 = 1;
			}
			int m = d0 > 0 ? 1 : 0;
			v[i] = max(sum1 + sum2, m);

			if (i + 1 < s.size())
			{
				if (s[i + 1] == '0' && (s[i] != '1' && s[i] != '2')) return 0;
			}
			i--;
		}
		return v[0];
	}

	vector<vector<int>> res2;
	void twoSum(vector<int>& nums, int begin, int end, int sum)
	{
		if (begin >= end) return;

		int tmp = nums[begin] + nums[end];
		int e = end - 1;
		int b = begin + 1;
		if (tmp > sum)
		{
			while (e > begin && nums[e] == nums[e + 1]) e--;
			twoSum(nums, begin, e, sum);
		}
		else if (tmp < sum)
		{
			while (b < end && nums[b] == nums[b - 1]) b++;
			twoSum(nums, b, end, sum);
		}
		else
		{
			vector<int> r2 = { nums[begin], nums[end] };
			res2.push_back(r2);

			while (e > begin && nums[e] == nums[e + 1]) e--;
			while (b < end && nums[b] == nums[b - 1]) b++;

			twoSum(nums, b, e, sum);
		}
	}

	//https://leetcode.com/problems/3sum/
	vector<vector<int>> threeSum(vector<int>& nums) 
	{
		sort(nums.begin(), nums.end());
		vector<vector<int>> res;
		if (nums.size() < 3) return res;
		for (int i = 0; i < nums.size() - 1; ++i)
		{
			res2.clear();
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			twoSum(nums, i+1, nums.size() - 1, -nums[i]);
			for (int j = 0; j < res2.size(); ++j)
			{
				vector<int> r1 = { nums[i], res2[j][0], res2[j][1] };
				res.push_back(r1);
			}
		}
		return res;
	}

	//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
	int findMin(vector<int>& nums) {
		minim = nums[0];
		return findMin(nums, 0, nums.size() - 1);
	}

	int minim;
	int findMin(vector<int>& nums, int b, int e)
	{
		if (b == e) return nums[b];
		if (e - b == 1) return min(nums[b], nums[e]);
		int m = b + (e - b) / 2;
		if (nums[b] <= nums[m])
		{
			return min(minim, findMin(nums, m, e));
		}
		else
		{
			return min(minim, findMin(nums, b, m));
		}
	}

	//https://leetcode.com/problems/single-number/	
	int singleNumber(vector<int>& nums) 
	{
		int res = 0;
		for (auto i : nums) res ^= i;
		return res;
	}
	
	//https://leetcode.com/problems/find-the-difference/
	char findTheDifference(string s, string t) 
	{
		char diff = 0;
		int cnt[256] = {0};
		for (char c : s) cnt[c]++;
		for (char c : t) if (--cnt[c] < 0) return c;
		return diff;
	}
	
	//https://leetcode.com/problems/find-the-difference/
	char findTheDifference2(string s, string t) {
		char r=0;
		for(char c:s) r ^=c;
		for(char c:t) r ^=c;
		return r;
	}

	//https://leetcode.com/problems/product-of-array-except-self/
	vector<int> productExceptSelf(vector<int>& nums) {
		// use two rounds to get the result: the 1st round for multiplying every element on the left side of current position, the 2nd round for multiplying every element on the right side of current position
		int length = nums.size();
		vector<int> ans(length, 1);
		int leftSideProduct = 1;
		for (int i = 0; i<length; i++) {
			ans[i] = leftSideProduct; // leftSideProduct is the product of all the elements on the left side of position i
			leftSideProduct = leftSideProduct * nums[i]; // update leftSideProduct and keep going right
		}
		int rightSideProduct = 1;
		for (int j = length - 1; j >= 0; j--) {
			ans[j] = ans[j] * rightSideProduct; // rightSideProduct is the product of all the elements on the right side of position j
			rightSideProduct = rightSideProduct * nums[j]; // update rightSideProduct and keep going left
		}
		return ans;
	}

	//https://leetcode.com/problems/search-in-rotated-sorted-array/
	int search(vector<int>& nums, int target) {
		if (nums.size() == 0) return -1;
		return search(nums, 0, nums.size() - 1, target);
	}

	int search(vector<int>& nums, int b, int e, int target) {

		if (nums[b] == target) return b;
		if (nums[e] == target) return e;

		if (e - b <= 1) return -1;
		if (nums[b] < nums[e])
		{
			if (nums[b] <= target && target <= nums[e])
			{
				int s = b + (e - b) / 2;
				int res = search(nums, b, s, target);
				if (res == -1)
				{
					res = search(nums, s + 1, e, target);
				}
				return res;
			}
			return -1;
		}
		else
		{
			int s = b + (e - b) / 2;
			int res = search(nums, b, s, target);
			if (res == -1)
			{
				res = search(nums, s + 1, e, target);
			}
			return res;
		}
		return -1;
	}

	//https://leetcode.com/problems/container-with-most-water/
	int maxArea(vector<int>& height) {
		int m = 0;
		int l = 0;
		int r = height.size() - 1;
		while (l < r)
		{
			m = max(m, min(height[l], height[r]) * (r - l));
			if (height[l]< height[r]) l++;
			else r--;
		}
		return m;
	}

	//https://leetcode.com/problems/nested-list-weight-sum/
	/*works
	int depthSum(vector<NestedInteger>& nestedList) {
		int sum = 0;
		for (int i = 0; i < nestedList.size(); i++)
		{
			sum += depthSum(nestedList[i], 1);
		}
		return sum;
	}

	int depthSum(NestedInteger& d, int rank) {
		int sum = 0;
		if (d.isInteger()) return rank * d.getInteger();
		else
		{
			for (int i = 0; i < d.getList().size(); i++)
			{
				sum += depthSum(d.getList()[i], rank + 1);
			}
		}
		return sum;
	}*/
};
