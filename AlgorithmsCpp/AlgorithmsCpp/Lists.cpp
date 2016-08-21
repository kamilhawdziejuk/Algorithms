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

struct RandomListNode {
	int label;
	RandomListNode *next, *random;
	RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
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

	//https://leetcode.com/problems/copy-list-with-random-pointer/
	unordered_map<RandomListNode*, RandomListNode*>mp;
	RandomListNode *copyRandomList(RandomListNode *head)
	{
		if (!head) return NULL;
		if (mp[head]) return mp[head];
		mp[head] = new RandomListNode(head->label);
		mp[head]->next = copyRandomList(head->next);
		mp[head]->random = copyRandomList(head->random);
		return mp[head];
	}

	ListNode* prev = NULL;
	//https://leetcode.com/problems/swap-nodes-in-pairs/
	ListNode* swapPairs(ListNode* head) {
		if (head == NULL) return head;
		if (head->next == NULL) return head;
		ListNode* a = head;
		ListNode* b = head->next;
		ListNode* c = head->next->next;
		if (prev != NULL)
		{
			prev->next = b;
		}
		b->next = a;
		prev = a;
		a->next = swapPairs(c);

		return b;
	}

	int size(ListNode *head)
	{
		if (head == NULL) return 0;
		return 1 + size(head->next);
	}

	ListNode* countDiff(ListNode *headA, ListNode* headB)
	{
		if (headA == NULL && headB == NULL) return NULL;
		if (headA->val == headB->val)
		{
			return headA;
		}
		else
		{
			return countDiff(headA->next, headB->next);
		}
	}

	//https://leetcode.com/problems/intersection-of-two-linked-lists/
	ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
		int a = size(headA);
		int b = size(headB);
		if (a == 0 || b == 0) return NULL;

		ListNode * tmp;
		if (a > b)
		{
			tmp = headA;
			while (a > b)
			{
				tmp = tmp->next;
				a--;
			}
			return countDiff(tmp, headB);
		}
		else if (a < b)
		{
			tmp = headB;
			while (b > a)
			{
				tmp = tmp->next;
				b--;
			}
			return countDiff(headA, tmp);
		}
		else
		{
			return countDiff(headA, headB);
		}
	}
};