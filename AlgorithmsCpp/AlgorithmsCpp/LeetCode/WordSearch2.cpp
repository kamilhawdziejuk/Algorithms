#include <cassert>
#include <iostream>
#include <istream>
#include <fstream>
#include <algorithm>
#include <cstdio>
#include <complex>
#include <vector>
#include <set>
#include <map>
#include <cmath>
#include <queue>
#include <string>
#include <cstdlib>
#include <memory>
#include <ctime>
#include <bitset>
#include <queue>
#include <stack>
#include <unordered_map>
#include <unordered_set>
#include <bitset>

using namespace std;

#define SZ(X) ((int)(X).size())
#define ALL(X) (X).begin(), (X).end()
#define REPP(I, A, B) for (int I = (A); I < (B); ++I)
#define REP(i,n) for(int i = 0; i < (n); ++i)
#define REPD(i, a, b) for(int i = (a); i > (b); i--)
#define RI(X) scanf("%d", &(X))
#define RII(X, Y) scanf("%d%d", &(X), &(Y))
#define RIII(X, Y, Z) scanf("%d%d%d", &(X), &(Y), &(Z))
#define DRI(X) int (X); scanf("%d", &X)
#define DRII(X, Y) int X, Y; scanf("%d%d", &X, &Y)
#define DRIII(X, Y, Z) int X, Y, Z; scanf("%d%d%d", &X, &Y, &Z)
#define RS(X) scanf("%s", (X))
#define CASET int ___T, case_n = 1; scanf("%d ", &___T); while (___T-- > 0)
#define MP make_pair
#define PB push_back
#define MS0(X) memset((X), 0, sizeof((X)))
#define MS1(X) memset((X), -1, sizeof((X)))
#define LEN(X) strlen(X)
#define LL long long
#define ULL unsigned long long
#define PII pair<int,int>
#define VI vector<int>
#define VLL vector<long long>
#define VULL vector<unsigned long long>
#define VPII vector<pair<int,int> >
#define PLL pair<long long,long long>
#define VPLL vector<pair<long long,long long> >
#define F first
#define S second
#define forIt(it, a) for(__typeof((a).begin()) it = (a).begin(); it != (a).end(); it++)
#define forRev(it, a) for(__typeof((a).rbegin()) it = (a).rbegin(); it != (a).rend(); it++)
#define tr(container, it) for (typeof(container.begin()) it = container.begin(); it != container.end(); it++)
#define present(container, element) (container.find(element) != container.end())
#define ft(a) __typeof((a).begin())
#define ld long double
#define fi first
#define se second
#define mk make_pair
#define pb push_back
#define all(a) (a).begin(), (a).end()
#define bitcount(n) __builtin_popcountll(n)
#define pii pair<int, int>

typedef complex<ld> cplex;
typedef vector<int> vi;
typedef pair<int, int> ii;
typedef pair<ii, int> iii;

#define SORT(v)			sort((v).begin(),(v).end())
#define UN(v)			SORT(v),(v).erase(unique((v).begin(),(v).end()),(v).end()) 

const int MOD = 1e9 + 7;
const int SIZE = 1e6 + 10;
const double EPS = 1e-12;
const double PI = acos(-1);

//https://leetcode.com/problems/word-search-ii/
//TO BE DONE (correction needed)
class Solution {
public:

	class Position
	{
	public:
		int x, y;

		Position() {}

		Position(int _x, int _y) { x = _x, y = _y; };

		bool operator==(const Position& other) const
		{
			return x == other.x && y == other.y;
		}
		bool operator!=(const Position& other) const
		{
			return !(*this == other);
		}
		Position& operator=(const Position& other)
		{
			// check for self-assignment
			if (&other == this)
				return *this;
			x = other.x;
			y = other.y;
			return *this;
		}
	};

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

	Trie trie;
	int n, m;

	bool isOnBoard(Position &pos)
	{
		return pos.x >= 0 && pos.y >= 0 && pos.x < n && pos.y < m;
	}

	vector<Position> getNexts(Position& pos)
	{
		Position p1(pos.x - 1, pos.y - 1);
		Position p2(pos.x - 1, pos.y);
		Position p3(pos.x - 1, pos.y + 1);
		Position p4(pos.x, pos.y - 1);
		Position p5(pos.x, pos.y);
		Position p6(pos.x, pos.y + 1);
		Position p7(pos.x + 1, pos.y - 1);
		Position p8(pos.x + 1, pos.y);
		Position p9(pos.x + 1, pos.y + 1);
		vector<Position> posNext = { p1, p2, p3, p4, p5, p6, p7, p8, p9 };

		vector<Position> positions;
		for (int j = 0; j < posNext.size(); j++)
		{
			Position pNext = posNext[j];
			if (isOnBoard(pNext) && pNext != pos)
			{
				positions.push_back(pNext);
			}
		}
		return positions;
	}

	string getWord(vector<vector<char>>& board, vector<Position>& way)
	{
		string res;
		for (int i = 0; i < way.size(); ++i)
		{
			Position pos = way[i];
			res += board[pos.x][pos.y];
		}
		return res;
	}

	vector<string> findWords(vector<vector<char>>& board, Position pos, vector<Position> way) {
		vector<string> res;
		bool exists = false;
		for (int i = 0; i < way.size(); i++)
		{
			if (way[i] == pos)
			{
				exists = true;
				break;
			}
		}

		if (!exists)
		{
			string word = getWord(board, way);
			word += board[pos.x][pos.y];
			if (trie.startsWith(word))
			{
				if (trie.search(word))
				{
					res.push_back(word);
				}
				way.push_back(pos);
				vector<Position> nextPositions = getNexts(pos);
				for (int i = 0; i < nextPositions.size(); i++)
				{
					vector<string> results = findWords(board, nextPositions[i], way);
					res.insert(res.end(), results.begin(), results.end());
				}
			}
		}
		return res;
	}

	vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
		for (int i = 0; i < words.size(); i++)
		{
			trie.insert(words[i]);
		}
		n = board.size();
		m = board[0].size();

		vector<string> res;

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				char c = board[i][j];
				Position pos(i, j);
				vector<Position> way;
				string str;
				str += c;
				if (trie.search(str))
				{
					res.push_back(str);
				}
				if (trie.startsWith(str))
				{
					vector<string> w = findWords(board, pos, way);
					res.insert(res.end(), w.begin(), w.end());
				}
			}
		}
		UN(res);
		return res;
	}

};

int main55()
{
	//shared_ptr<Problem> p;

	vector<vector<char>> board;
	vector<char> b1;
	b1.push_back('a');
	b1.push_back('a');
	board.push_back(b1);

	vector<string> words;
	words.push_back("aa");

	Solution *p = new Solution();
	p->findWords(board, words);
	delete p;
	return 0;
}