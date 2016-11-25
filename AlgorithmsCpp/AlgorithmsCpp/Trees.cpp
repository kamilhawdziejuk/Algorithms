#include "stdafx.h"
#include <algorithm>
#include <queue>
#include <stack>
#include <climits>
#include <cstdlib>

 struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}	
};
 
 struct TreeLinkNode {
	int val;
	TreeLinkNode *left, *right, *next;
	TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 };
 

class Trees
{

private:
	int depth = 0;

public:
	Trees() {};
	~Trees() {};

	//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
	void flatten(TreeNode* root) {
		flattenInternal(root);
	}

	TreeNode* flattenInternal(TreeNode* root) {
		TreeNode *last = NULL;
		if (root == NULL)
		{
			return NULL;
		}
		else if (root->left == NULL && root->right == NULL)
		{
			return root;
		}
		else if (root->left == NULL)
		{
			return flattenInternal(root->right);
		}
		else if (root->right == NULL)
		{
			last = flattenInternal(root->left);
			root->right = root->left;
			root->left = NULL;
			return last;
		}
		else
		{
			TreeNode *flatLeft = flattenInternal(root->left);
			TreeNode *rightBegin = root->right;
			TreeNode *flatRight = flattenInternal(root->right);

			last = flatLeft;
			root->right = root->left;
			root->left = NULL;
			
			last->right = rightBegin;
			last->left = NULL;

			return flatRight;
		}
	}



	//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
	void connect(TreeLinkNode *root) {
		if (!root) return;
		if (root->left)
		{
			root->left->next = root->right;
			if (root->next) root->right->next = root->next->left;
		}
		connect(root->left);
		connect(root->right);
	}

	
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

	//https://leetcode.com/problems/same-tree/
	bool isSameTree(TreeNode* p, TreeNode* q)
	{
		if (!p || !q) { if (!p && !q) return true; return false; }
		return (p->val == q->val) && isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
	}

	bool checkBST(TreeNode* root, int minValue, int maxValue) {
		if (root == NULL) {
			return true;
		}

		if (root->val < minValue || root->val > maxValue) {
			return false;
		}

		bool leftOK = true;
		if (root->left == NULL) leftOK = true;
		else
		{
			leftOK = (root->val != INT_MIN) && checkBST(root->left, minValue, root->val - 1);
		}
		if (!leftOK) return false;
		bool rightOK = true;
		if (root->right == NULL) rightOK = true;
		else
		{
			rightOK = (root->val != INT_MAX) && checkBST(root->right, root->val + 1, maxValue);
		}
		return leftOK && rightOK;
	}

	//https://leetcode.com/problems/validate-binary-search-tree/
	bool isValidBST2(TreeNode* root) {
		return checkBST(root, INT_MIN, INT_MAX);
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

	//https://leetcode.com/problems/path-sum/
	bool hasPathSum(TreeNode* root, int sum) {
		if (root == NULL) return false;
		if (root->left == NULL && root->right == NULL)
		{
			if (root->val == sum)
			{
				return true;
			}
		}

		if (hasPathSum(root->left, sum - (root->val)))
		{
			return true;
		}
		if (hasPathSum(root->right, sum - (root->val)))
		{
			return true;
		}
		return false;
	}

	//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
	TreeNode* lowestCommonAncestorBST(TreeNode* root, TreeNode* p, TreeNode* q)
	{
		if (!root)
		{
			return NULL;
		}
		if (p->val < root->val && q->val < root->val)
		{
			lowestCommonAncestorBST(root->left, p, q);
		}
		else if (p->val > root->val && q->val > root->val)
		{
			lowestCommonAncestorBST(root->right, p, q);
		}
		else
		{
			return root;
		}
	}

	//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
	TreeNode* lowestCommonAncestorOptimal(TreeNode* root, TreeNode* p, TreeNode* q) {
		if (!root || root == p || root == q) return root;
		TreeNode* l = lowestCommonAncestorOptimal(root->left, p, q);
		TreeNode* r = lowestCommonAncestorOptimal(root->right, p, q);
		return l && r ? root : l ? l : r;
	}

	//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
		stack<TreeNode*> stack1;
		stack<TreeNode*> stack2;
		order(root, p, stack1);
		order(root, q, stack2);

		TreeNode* r = stack1.top();
		while (!stack1.empty() && !stack2.empty() && stack1.top() == stack2.top())
		{
			r = stack1.top();
			stack1.pop();
			stack2.pop();
		}
		return r;
	}

	void order(TreeNode* root, TreeNode* p, stack<TreeNode*> &stack)
	{
		if (root != NULL)
		{
			if (root == p)
			{
				stack.push(root);
			}
			else
			{
				int size = stack.size();
				order(root->left, p, stack);
				order(root->right, p, stack);
				if (stack.size() > size)
				{
					stack.push(root);
				}
			}
		}
	}
	
	//https://leetcode.com/problems/invert-binary-tree/
	TreeNode* invertTree(TreeNode* root) {
		if (root == NULL) return NULL;
		
		TreeNode* left = invertTree(root->left);
		TreeNode* right = invertTree(root->right);
		
		root->right = left;
		root->left = right;
		
		return root;
	}
};

