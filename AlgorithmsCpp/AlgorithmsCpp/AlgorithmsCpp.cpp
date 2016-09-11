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
	Trees *t = new Trees();
	TreeLinkNode *t1 = new TreeLinkNode(1);
	TreeLinkNode *t2 = new TreeLinkNode(2);
	TreeLinkNode *t3 = new TreeLinkNode(3);
	t1->left = t2;
	t1->right = t3;

	t->connect(t1);
	return 0;
}

