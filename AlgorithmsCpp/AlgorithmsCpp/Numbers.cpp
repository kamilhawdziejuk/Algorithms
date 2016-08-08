#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <cmath>
#include <map>
#include <unordered_map>

class Numbers
{
public:
	Numbers() {};
	~Numbers() {};
		
	//https://leetcode.com/problems/add-digits/
	int addDigits(int num)
	{
		if (num % 9 == 0 && num != 0) return 9;
		else return num % 9;
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
};