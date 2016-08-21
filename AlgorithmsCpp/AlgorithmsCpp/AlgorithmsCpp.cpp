// AlgorithmsCpp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Strings.cpp"
#include "Numbers.cpp"
#include "Arrays.cpp"
#include "PowerSet.cpp"
#include "Matrix.cpp"
#include "Lists.cpp"

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	
	ListNode * node1 = new ListNode(1);
	ListNode *prev = node1;
	for (int i = 3; i < 22; i += 2)
	{
		ListNode *n = new ListNode(i);
		prev->next = n;
		prev = n;
	}

	ListNode * node2 = new ListNode(2);

	Lists *lists = new Lists();
	lists->getIntersectionNode(node1, node2);
	
	delete lists;
	return 0;
}

