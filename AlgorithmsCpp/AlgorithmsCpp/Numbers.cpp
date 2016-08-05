#include "stdafx.h"

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
};