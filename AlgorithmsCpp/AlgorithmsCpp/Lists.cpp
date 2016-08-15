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

	//https://leetcode.com/problems/linked-list-cycle/
	bool hasCycle(ListNode *head) {
		if (head == NULL) return false;
		ListNode* p1 = head->next;
		ListNode* p2 = head->next != NULL ? head->next->next : NULL;

		while (p1 != NULL && p2 != NULL && p1 != p2)
		{
			p1 = p1->next;
			p2 = p2->next != NULL ? p2->next->next : NULL;
		}
		return (p1 != NULL && p2 != NULL && p1 == p2);
	}

    //https://leetcode.com/problems/delete-node-in-a-linked-list/
	void deleteNode(ListNode* node) {

		ListNode * nextNodeToDelete = node->next;

		node->val = node->next->val;
		node->next = node->next->next;

		delete nextNodeToDelete;// questionable...depends on how a test list has been created. If on the stack then this can cause crash.
	}
};