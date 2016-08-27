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

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	Strings *s = new Strings();
	int res = s->lengthOfLongestSubstring("abcabcbb");

	Lists *l = new Lists();
	ListNode*a = new ListNode(9);
	ListNode*b = new ListNode(9);
	l->addTwoNumbers(a, b);

	Numbers * n = new Numbers();
	//n->numDecodings("01");
	vector<int> v = { 1,2,-2,-1 };// = { -1,0,1,2,-1,-4 };
	n->threeSum(v);
	delete n;
	return 0;
}

