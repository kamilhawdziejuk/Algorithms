#include "stdafx.h"
#include <algorithm>

 struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}	
};

class Trees
{

private:
	int depth = 0;

public:
	Trees() {};
	~Trees() {};

	//https://leetcode.com/problems/same-tree/
	bool isSameTree(TreeNode* p, TreeNode* q)
	{
		if (!p || !q) { if (!p && !q) return true; return false; }
		return (p->val == q->val) && isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
	}

	//https://leetcode.com/problems/maximum-depth-of-binary-tree/
	int maxDepth(TreeNode* root) {
		if (root == NULL)
		{
			return 0;
		}
		else
		{
			int dLeft = 1 + maxDepth(root->left);
			int dRight = 1 + maxDepth(root->right);
			return std::max(dLeft, dRight);
		}
	}
};

