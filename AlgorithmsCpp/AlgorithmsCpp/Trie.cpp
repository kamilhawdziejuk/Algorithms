#include "stdafx.h"
#include <algorithm>
#include <queue>
#include <stack>
#include <unordered_map>

class TrieNode {
public:
	char value;
	unordered_map<char, TrieNode*> child;
	bool isEnd;
	// Initialize your data structure here.
	TrieNode() {
		isEnd = false;
	}
};

//https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie {
public:
	Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	void insert(string word) {
		TrieNode *ptr = root;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			if (ptr->child.find(word[i]) != ptr->child.end())
			{
				if (i == len - 1)
					(ptr->child[word[i]])->isEnd = true;
				else
					ptr = ptr->child[word[i]];
			}
			else
			{
				TrieNode *node = new TrieNode();
				node->value = word[i];
				if (i + 1 == len)
					node->isEnd = true;
				ptr->child[word[i]] = node;
				ptr = node;
			}
		}
	}
	// Returns if the word is in the trie.
	bool search(string word) {
		int len = word.size();
		TrieNode *ptr = root;
		for (int i = 0; i < len; i++) {
			if (ptr->child.find(word[i]) == ptr->child.end())
				return false;
			else
			{
				if (i + 1 == len)
				{
					if ((ptr->child[word[i]])->isEnd == true)
						return true;
					return false;
				}
				ptr = ptr->child[word[i]];
			}
		}
		return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	bool startsWith(string prefix) {
		TrieNode *ptr = root;
		int len = prefix.size();
		for (int i = 0; i < len; i++)
		{
			if (ptr->child.find(prefix[i]) == ptr->child.end())
				return false;
			ptr = ptr->child[prefix[i]];
		}
		return true;
	}

private:
	TrieNode* root;
};

// Your Trie object will be instantiated and called as such:
// Trie trie;
// trie.insert("somestring");
// trie.search("key");