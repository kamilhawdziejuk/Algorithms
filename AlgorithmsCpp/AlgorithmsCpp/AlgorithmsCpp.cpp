// AlgorithmsCpp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Strings.cpp"
#include "Numbers.cpp"

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	Numbers *n = new Numbers();
	n->reverse(1534236469);
	delete n;

	Strings *s = new Strings();
	delete s;

	return 0;
}

