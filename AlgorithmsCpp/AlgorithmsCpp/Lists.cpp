#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <cmath>
#include <map>
#include <unordered_map>

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
	
};

class Lists
{
	public:
	Lists() {};
	~Lists() {};

	void deleteNode(ListNode* node) {

		ListNode * nextNodeToDelete = node->next;

		node->val = node->next->val;
		node->next = node->next->next;

		delete nextNodeToDelete;// questionable...depends on how a test list has been created. If on the stack then this can cause crash.
	}
};