#include "stdafx.h"
#include <vector>

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
};