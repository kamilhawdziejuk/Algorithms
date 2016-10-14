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

enum FigType { Q = 1, N = 2, B = 3, R = 4, NoneType = -1 };
enum FigSide { White = 1, Black = 2, NoneSide = -1 };

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

class FigureRep
{
public:
	FigType Type;
	Position Pos;
	FigSide Side;

	bool operator==(const FigureRep& other) const
	{
		return Type == other.Type && Side == other.Side && Pos == other.Pos;
	}

	bool operator!=(const FigureRep& other) const
	{
		return !(*this == other);
	}

	FigureRep& operator=(const FigureRep& other)
	{
		// check for self-assignment
		if (&other == this)
			return *this;
		Type = other.Type;
		Pos = other.Pos;
		Side = other.Side;
		return *this;
	}

	FigureRep copy()
	{
		FigureRep clone;
		clone.Pos = Pos;
		clone.Side = Side;
		clone.Type = Type;
		return clone;
	}

	static FigureRep Empty;

	static FigureRep GetEmpty()
	{
		FigureRep fig;
		fig.Type = NoneType;
		fig.Side = NoneSide;
		return fig;
	}
};

class Board
{
public:
	FigureRep Fields[4][4];// = { FigureRep::GetEmpty() };
	vector<FigureRep> moves; //extra information (only for debugging, can be removed)

	Board()
	{
		FigureRep figNoneRep = FigureRep::GetEmpty();
		for (int row = 0; row < 4; row++)
		{
			for (int col = 0; col < 4; col++)
			{
				Fields[row][col] = figNoneRep;
			}
		}
	}

	Board copy()
	{
		Board newBoard;
		for (int row = 0; row < 4; row++)
		{
			for (int col = 0; col < 4; col++)
			{
				newBoard.Fields[row][col] = Fields[row][col];
			}
		}

		//extra information (only for debugging, can be removed)
		for (int i = 0; i < moves.size(); i++)
		{
			FigureRep f = moves[i].copy();
			newBoard.moves.push_back(f);
		}
		return newBoard;
	}

	void addMove(FigureRep newFig)
	{
		moves.push_back(newFig);
	}

	vector<FigureRep> getFigures(FigSide side)
	{
		vector<FigureRep> figures;
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				FigureRep fig = Fields[i][j];
				if (fig.Side == side)
				{
					figures.push_back(fig);
				}
			}
		}
		return figures;
	}

	vector<FigureRep> getWhiteFigures()
	{
		return getFigures(White);
	}

	vector<FigureRep> getBlackFigures()
	{
		return getFigures(Black);
	}


	bool operator==(const Board& other) const
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (Fields[i][j] != other.Fields[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}

	bool operator!=(const Board& other) const
	{
		return !(*this == other);
	}
};

class ChessProblem
{
public:
	bool isOnBoard(Position &pos)
	{
		return pos.x >= 0 && pos.y >= 0 && pos.x < 4 && pos.y < 4;
	}

	vector<Position> getNextPossible(FigureRep& fig)
	{
		vector<Position> positions;
		if (fig.Type == Q)
		{
			//rock
			for (int i = 0; i < 4; i++)
			{
				Position p(i, fig.Pos.y);
				if (p != fig.Pos)
				{
					positions.push_back(p);
				}
			}
			for (int i = 0; i < 4; i++)
			{
				Position p(fig.Pos.x, i);
				if (p != fig.Pos)
				{
					positions.push_back(p);
				}
			}
			//Bishop
			for (int i = 1; i < 4; i++)
			{
				Position p1(fig.Pos.x + i, fig.Pos.y + i);
				Position p2(fig.Pos.x - i, fig.Pos.y + i);
				Position p3(fig.Pos.x + i, fig.Pos.y - i);
				Position p4(fig.Pos.x - i, fig.Pos.y - i);

				if (isOnBoard(p1) && p1 != fig.Pos) positions.push_back(p1);
				if (isOnBoard(p2) && p2 != fig.Pos) positions.push_back(p2);
				if (isOnBoard(p3) && p3 != fig.Pos) positions.push_back(p3);
				if (isOnBoard(p4) && p4 != fig.Pos) positions.push_back(p4);
			}
		}
		else if (fig.Type == R)
		{
			for (int i = 0; i < 4; i++)
			{
				Position p(i, fig.Pos.y);
				if (p != fig.Pos)
				{
					positions.push_back(p);
				}
			}
			for (int i = 0; i < 4; i++)
			{
				Position p(fig.Pos.x, i);
				if (p != fig.Pos)
				{
					positions.push_back(p);
				}
			}
		}
		else if (fig.Type == B)
		{
			for (int i = 1; i < 4; i++)
			{
				Position p1(fig.Pos.x + i, fig.Pos.y + i);
				Position p2(fig.Pos.x - i, fig.Pos.y + i);
				Position p3(fig.Pos.x + i, fig.Pos.y - i);
				Position p4(fig.Pos.x - i, fig.Pos.y - i);

				vector<Position> posNext = { p1, p2, p3, p4 };
				for (int j = 0; j < posNext.size(); j++)
				{
					Position pNext = posNext[j];
					if (isOnBoard(pNext) && pNext != fig.Pos)
					{
						positions.push_back(pNext);
					}
				}
			}
		}
		else if (fig.Type == N)
		{
			Position p1(fig.Pos.x + 1, fig.Pos.y - 2);
			Position p2(fig.Pos.x + 2, fig.Pos.y - 1);
			Position p3(fig.Pos.x + 2, fig.Pos.y + 1);
			Position p4(fig.Pos.x + 1, fig.Pos.y + 2);
			Position p5(fig.Pos.x - 1, fig.Pos.y - 2);
			Position p6(fig.Pos.x - 2, fig.Pos.y - 1);
			Position p7(fig.Pos.x - 2, fig.Pos.y + 1);
			Position p8(fig.Pos.x - 1, fig.Pos.y + 2);

			vector<Position> posNext = { p1, p2, p3, p4, p5, p6, p7, p8 };

			for (int j = 0; j < posNext.size(); j++)
			{
				Position pNext = posNext[j];
				if (isOnBoard(pNext) && pNext != fig.Pos)
				{
					positions.push_back(pNext);
				}
			}
		}
		return positions;
	}


	int q, w, b, m;

	vector<Board> getNextBoards(Board& board, int x, int y)
	{
		vector<Board> nextBoards;

		FigureRep empty = FigureRep::GetEmpty();
		//take figure at (x,y)
		FigureRep fig = board.Fields[x][y];
		if (fig.Type != NoneType)
		{
			vector<Position> positions = getNextPossible(fig);
			for (int i = 0; i < positions.size(); i++)
			{
				//here is the place to copy all the board
				Position pi = positions[i];
				FigureRep figureThere = board.Fields[pi.x][pi.y];
				if (figureThere.Type == NoneType)
				{
					Board copy = board.copy();
					FigureRep figCopy = fig.copy();
					figCopy.Pos.x = pi.x;
					figCopy.Pos.y = pi.y;
					//we can move here
					copy.Fields[pi.x][pi.y] = figCopy;
					copy.Fields[x][y] = empty.copy();

					copy.addMove(figCopy);
					nextBoards.push_back(copy);
				}
				else
				{
					//we can take the oponnent figure
					if (figureThere.Side != fig.Side)
					{
						Board copy = board.copy();

						FigureRep figCopy = fig.copy();
						figCopy.Pos.x = pi.x;
						figCopy.Pos.y = pi.y;

						copy.Fields[pi.x][pi.y] = figCopy;
						copy.Fields[x][y] = empty.copy();

						
						copy.addMove(figCopy);
						nextBoards.push_back(copy);
					}
				}
			}
		}
		return nextBoards;
	}

	vector<Board> getNextBoards(Board& board, bool whiteMove)
	{
		//we can optimize here scanning only places with figures
		vector<Board> results;
		vector<FigureRep> figures;
		if (whiteMove)
		{
			figures = board.getWhiteFigures();
		}
		else
		{
			figures = board.getBlackFigures();
		}
		for (int i = 0; i < figures.size(); i++)
		{
			FigureRep fig = figures[i];
			vector<Board> nextsBoards = getNextBoards(board, fig.Pos.x, fig.Pos.y);
			results.insert(results.end(), nextsBoards.begin(), nextsBoards.end());
		}
		return results;
	}

	bool isDone(Board &board)
	{
		vector<FigureRep> blackFigures = board.getBlackFigures();
		for (int i = 0; i < blackFigures.size(); i++)
		{
			if (blackFigures[i].Type == Q)
			{
				return false;
			}
		}
		//but does the white still have?
		vector<FigureRep> whiteFigures = board.getWhiteFigures();
		for (int i = 0; i < whiteFigures.size(); i++)
		{
			if (whiteFigures[i].Type == Q)
			{
				return true;
			}
		}
		return false;
	}

	bool canWhiteMate(Board& board, int moveNr)
	{
		if (moveNr > m)
		{
			return false;
		}
		else
		{
			vector<Board> boardsAfterWhiteMove = getNextBoards(board, true);
			for (int i = 0; i < boardsAfterWhiteMove.size(); i++)
			{
				if (isDone(boardsAfterWhiteMove[i]))
				{
					return true;
				}
			}
			//if there exists at least one white move that leads for sure to mate..:
			for (int i = 0; i < boardsAfterWhiteMove.size(); i++)
			{
				Board b = boardsAfterWhiteMove[i]; //board after white move
				vector<Board> boardsAfterBlackMove = getNextBoards(b, false);
				//after each black move, we check if white have response that leads to mat
				bool whiteHasReponseForAllBlack = true;
				for (int j = 0; j < boardsAfterBlackMove.size(); j++)
				{
					Board boardNow = boardsAfterBlackMove[j];
					bool canMate = canWhiteMate(boardNow, moveNr + 2);
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
	}


	ifstream fcin;
	void virtual Solve()
	{
		fcin.open("D:\\chess3.in", ios::in);
		fcin >> q;
		char figureChar, figurePosHorizontal;
		int figurePosVertical;
		for (int i = 0; i < q; i++)
		{
			fcin >> w >> b >> m;

			Board initBoard; //empty board

			for (int k = 0; k < w + b; k++)
			{
				fcin >> figureChar >> figurePosHorizontal >> figurePosVertical;
				FigureRep figRep;
				if (figureChar == 'Q')
				{
					figRep.Type = Q;
				}
				else if (figureChar == 'N')
				{
					figRep.Type = N;
				}
				else if (figureChar == 'R')
				{
					figRep.Type = R;
				}
				else if (figureChar == 'B')
				{
					figRep.Type = B;
				}

				int x = figurePosHorizontal - 'A';
				int y = figurePosVertical - 1;
				figRep.Pos.x = x;
				figRep.Pos.y = y;

				if (k < w)
				{
					figRep.Side = White;
				}
				else
				{
					figRep.Side = Black;
				}

				initBoard.Fields[x][y] = figRep;
			}

			if (canWhiteMate(initBoard, 1))
			{
				cout << "YES" << endl;
			}
			else
			{
				cout << "NO" << endl;
			}
		}
	}
};

int mainChessProblem()
{
	//shared_ptr<ChessProblem> p;
	ChessProblem *p = new ChessProblem();
	p->Solve();
	delete p;
	return 0;
}