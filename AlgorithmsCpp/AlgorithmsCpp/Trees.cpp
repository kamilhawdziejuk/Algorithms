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
	
	//https://leetcode.com/problems/symmetric-tree/
	bool isSymmetric(TreeNode* root)
	{
		if (!root) return true;
		return sym(root->left, root->right);
	}

	bool sym(TreeNode* n1, TreeNode* n2)
	{
		if (!n1 && !n2) return true;
		if (!n1 || !n2 || n1->val != n2->val) return false;
		return sym(n1->left, n2->right) && sym(n1->right, n2->left);
	}

	//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) 
	{
		if (!root)
		{
			return NULL;
		}
		if (p->val < root->val && q->val < root->val)
		{
			lowestCommonAncestor(root->left, p, q);
		}
		else if (p->val > root->val && q->val > root->val)
		{
			lowestCommonAncestor(root->right, p, q);
		}
		else
		{
			return root;
		}
	}

	//https://leetcode.com/problems/same-tree/
	bool isSameTree(TreeNode* p, TreeNode* q)
	{
		if (!p || !q) { if (!p && !q) return true; return false; }
		return (p->val == q->val) && isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
	}

	vector<int> values;
	
	 //https://leetcode.com/problems/validate-binary-search-tree/
	 bool isValidBST(TreeNode* root) 
	 {
		printBST(root);
		if (values.size() <= 1) return true;
		for (int i = 0; i < values.size()-1; i++)
		{
			if (values[i] >= values[i+1]) return false;
		}
		return true;
	}
	
	void printBST(TreeNode* root)
	{
		if (root != NULL)
		{
			if (root->left != NULL) printBST(root->left);
			values.push_back(root->val);
			if (root->right != NULL) printBST(root->right);
		}
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

	//https://leetcode.com/problems/binary-tree-level-order-traversal/
	vector<vector<int>> levelOrder(TreeNode* root) {
		vector<vector<int>> res;
		queue<TreeNode*> q;

		if (root == NULL) return res;
		q.push(root);

		order(res, q);
		return res;
	}

	void order(vector<vector<int>> &res, queue<TreeNode*>& q)
	{
		while (!q.empty())
		{
			int size = q.size();
			vector<int> vec;
			for (int i = 0; i < size; ++i)
			{
				TreeNode* node = q.front();
				vec.push_back(node->val);
				q.pop();
				if (node->left != NULL)
				{
					q.push(node->left);
				}
				if (node->right != NULL)
				{
					q.push(node->right);
				}
			}
			res.push_back(vec);
		}
	}
};

