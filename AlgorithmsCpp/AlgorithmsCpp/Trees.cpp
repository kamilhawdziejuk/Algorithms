#include "stdafx.h"

 struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}	
};

class Trees
{
public:
	Trees() {};
	~Trees() {};

	//https://leetcode.com/problems/same-tree/
	bool isSameTree(TreeNode* p, TreeNode* q)
	{
		if (!p || !q) { if (!p && !q) return true; return false; }
		return (p->val == q->val) && isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
	}
};

