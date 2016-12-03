// AlgorithmsCpp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
/*#include "Strings.cpp"
#include "Numbers.cpp"
#include "Arrays.cpp"
#include "PowerSet.cpp"
#include "Matrix.cpp"
#include "Lists.cpp"
#include "Trees.cpp"
*/
#include "Pointers/PointersCheck.cpp"
#include "Trees.cpp"
using namespace std;

//int _tmain(int argc, _TCHAR* argv[])
int mainT()
{
	shared_ptr<PointersCheck> pointer(new PointersCheck);
	pointer->Method();
	return 0;
}

