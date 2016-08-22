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
	Numbers * n = new Numbers();
	n->numDecodings("01");
	delete n;
	return 0;
}

