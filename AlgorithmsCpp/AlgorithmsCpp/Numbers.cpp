#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <cmath>
#include <map>
#include <cstdint>
#include <unordered_map>
#include <string>

using namespace std;

class Numbers
{
public:
	Numbers() {};
	~Numbers() {};

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
	int hammingWeight(uint32_t number)
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
	int hammingWeightRecursive(uint32_t n) {
		if (n>0)
			return n % 2 == 1 ? 1 + hammingWeightRecursive(n / 2) : hammingWeightRecursive(n / 2);
		else
			return 0;
	}

	/*string DecToBin2(int number)
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

		reverse(result.begin(), result.end());
		return result;
	}*/
};