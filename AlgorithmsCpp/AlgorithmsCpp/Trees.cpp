#include "stdafx.h"
#include <algorithm>
#include <queue>

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

	//https://leetcode.com/problems/maximum-depth-of-binary-tree/
	int maxDepthIterative(TreeNode *root)
	{
		if (root == NULL)
			return 0;

		int res = 0;
		queue<TreeNode *> q;
		q.push(root);
		while (!q.empty())
		{
			++res;
			for (int i = 0, n = q.size(); i < n; ++i)
			{
				TreeNode *p = q.front();
				q.pop();

				if (p->left != NULL)
					q.push(p->left);
				if (p->right != NULL)
					q.push(p->right);
			}
		}

		return res;
	}
};

