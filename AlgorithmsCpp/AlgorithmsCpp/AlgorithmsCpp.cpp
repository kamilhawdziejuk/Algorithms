// AlgorithmsCpp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Strings.cpp"
#include "Numbers.cpp"

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	Numbers *n = new Numbers();
	n->titleToNumber("ABC");
	delete n;
	return 0;
}

