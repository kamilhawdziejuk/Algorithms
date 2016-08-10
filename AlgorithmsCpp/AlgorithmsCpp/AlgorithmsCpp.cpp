// AlgorithmsCpp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Strings.cpp"
#include "Numbers.cpp"

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
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

