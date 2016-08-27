// AlgorithmsCpp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Strings.cpp"
#include "Numbers.cpp"
#include "Arrays.cpp"
#include "PowerSet.cpp"
#include "Matrix.cpp"
#include "Lists.cpp"
#include "Trees.cpp"
#include "ArraysSort.cpp";
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	ArraysSort *arr = new ArraysSort();
	arr->test();

	Numbers * n = new Numbers();
	//n->numDecodings("01");
	vector<int> v = { 1,2,-2,-1 };// = { -1,0,1,2,-1,-4 };
	n->threeSum(v);
	delete n;
	return 0;
}

