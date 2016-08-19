// AlgorithmsCpp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Strings.cpp"
#include "Numbers.cpp"
#include "Arrays.cpp"

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	Arrays *a = new Arrays();
	vector<int> nums;
	for (int i = 1; i <= 6; i++)
	nums.push_back(i);
	//nums.push_back(2);
	a->rotate(nums,2);
	delete a;
	Numbers *n = new Numbers();
	//n->titleToNumber("ABC");
	//n->romanToInt("MDCCCLXXXIV");
	//n->romanToInt("DCXXI");
	delete n;

	Strings *s = new Strings();
	/*vector<string> strs;
	strs.push_back("c");
	strs.push_back("c");
	s->longestCommonPrefix(strs);*/
	string str = "the sky is blue";//   a   ";
	//s->reverseWords(str);

	s->myAtoi("    10522545459");
	delete s;

	return 0;
}

