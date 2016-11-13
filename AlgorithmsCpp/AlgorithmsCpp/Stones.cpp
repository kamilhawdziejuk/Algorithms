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
#define ULL long long
//unsigned long long

ULL N, M;
vector<ULL> S;

class Game
{
public:
	unordered_map<ULL, ULL> podzialy;

	Game()
	{
		podzialy.insert(pair<ULL, ULL>(N, 1UL));
	}

	Game copy()
	{
		Game newBoard;
		newBoard.podzialy = podzialy;
		return newBoard;
	}

	void split(ULL key, ULL d)
	{
		auto it = podzialy.find(key);
		if (it != podzialy.end())
		{
			ULL value = it->second;
			podzialy[it->first]--;

			if (podzialy[it->first] == 0)
			{
				podzialy.erase(it->first);
			}

			ULL key2 = key / d;

			//add (key2, d)
			auto it2 = podzialy.find(key2);
			if (it2 != podzialy.end())
			{
				podzialy[key2] += d;
			}
			else
			{
				podzialy.insert(pair<ULL, ULL>(key2, d));
			}
		}
	}

	bool operator==(const Game& other) const
	{
		for (auto it = podzialy.begin(); it != podzialy.end(); ++it)
		{
			auto el = other.podzialy.find(it->first);
			if (el == other.podzialy.end())
			{
				return false;
			}
			else
			{
				if (el->second != it->second)
				{
					return false;
				}
			}
		}
		return true;
	}

	bool operator!=(const Game& other) const
	{
		return !(*this == other);
	}
};

class StonesProblem
{
public:

	vector<Game> getNextBoards(Game& board)
	{
		vector<Game> nextBoards;
		for (int i = 0; i < M; i++)
		{
			ULL d = S[i];

			for (auto it = board.podzialy.begin(); it != board.podzialy.end(); ++it)
			{
				ULL key = it->first;
				if (key % d == 0)
				{
					Game boardCopy = board.copy();
					boardCopy.split(key, d);
					nextBoards.push_back(boardCopy);
				}
			}
		}
		return nextBoards;
	}

	bool canWhiteMate(Game& board)
	{
		vector<Game> boardsAfterWhiteMove = getNextBoards(board);
		if (boardsAfterWhiteMove.size() == 0)
		{
			return false;
		}

		//if there exists at least one white move that leads for sure to mate..:
		for (int i = 0; i < boardsAfterWhiteMove.size(); i++)
		{
			Game b = boardsAfterWhiteMove[i]; //board after white move
			vector<Game> boardsAfterBlackMove = getNextBoards(b);
			//after each black move, we check if white have response that leads to mat
			bool whiteHasReponseForAllBlack = true;
			for (int j = 0; j < boardsAfterBlackMove.size(); j++)
			{
				Game boardNow = boardsAfterBlackMove[j];
				bool canMate = canWhiteMate(boardNow);
				if (!canMate)
				{
					whiteHasReponseForAllBlack = false;
					break;
				}
			}
			if (whiteHasReponseForAllBlack)
			{
				return true;
			}
		}
		return false;
	}

	ifstream fcin;
	ofstream fcout;
	void virtual Solve()
	{
		fcin.open("D:\\stones.txt", ios::in);
		//fcout.open("D:\\stones.out", ios::out | ios::app);
		fcin >> N;
		fcin >> M;
		for (int i = 0; i < M; i++)
		{
			ULL d;
			fcin >> d;
			S.push_back(d);
		}
		Game board;
		bool canMate = canWhiteMate(board);
		if (canMate)
		{
			cout << "First" << endl;
		}
		else
		{
			cout << "Second" << endl;
		}
	}
};

int mainStones()
{
	StonesProblem *p = new StonesProblem();
	p->Solve();
	delete p;
	return 0;
}