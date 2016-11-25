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
#include "Trees.cpp"
using namespace std;

//int _tmain(int argc, _TCHAR* argv[])
int main()
{
	Trees * trees = new Trees();
	TreeNode *t1 = new TreeNode(1);
	TreeNode *t2 = new TreeNode(2);
	TreeNode *t3 = new TreeNode(3);
	t1->left = t2;
	t1->right = t3;
	trees->flattenInternal(t1);
	return 0;
}

