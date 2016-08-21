// AlgorithmsCpp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Strings.cpp"
#include "Numbers.cpp"
#include "Arrays.cpp"
#include "PowerSet.cpp"
#include "Matrix.cpp"

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	Matrix *matrix = new Matrix();
	vector<vector<int>> v;
	vector<int> v1;
	v1.push_back(1);
	v1.push_back(2);
	v1.push_back(3);

	vector<int> v2;
	v2.push_back(4);
	v2.push_back(5);
	v2.push_back(6);

	vector<int> v3;
	v3.push_back(7);
	v3.push_back(8);
	v3.push_back(9);

	v.push_back(v1);
	v.push_back(v2);
	v.push_back(v3);

	matrix->spiralOrder(v);
	delete matrix;


	PowerSet *ps = new PowerSet();

	set<int> set;
		for (int i = 1; i <= 4; i++) set.insert(i);

	ps->powerSet(set);
	delete ps;

	Arrays *a = new Arrays();
	vector<int> nums;
	//for (int i = 1; i <= 4; i++)
	nums.push_back(1);
	nums.push_back(1);
	nums.push_back(2);
	nums.push_back(2);

	a->permuteUnique(nums);
	//nums.push_back(2);
	//a->rotate(nums,2);
	delete a;
	Numbers *n = new Numbers();
	string s1 = n->Dec2ToBin2BitSet(7);
	//string s2 = n->DecToBin2(18);
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

