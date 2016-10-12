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

enum FigType { Q, N, B, R, NoneType };
enum FigSide { White, Black, NoneSide };

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
};

class Board
{
public:
	FigureRep Fields[4][4];

	Board()
	{
		FigureRep figNoneRep;
		figNoneRep.Side = NoneSide;
		figNoneRep.Type = NoneType;
		for (int row = 0; row < 4; row++)
		{
			for (int col = 0; col < 4; col++)
			{
				Fields[row][col] = figNoneRep;
			}
		}
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
			Position p4(fig.Pos.x + 1, fig.Pos.y - 2);
			Position p5(fig.Pos.x - 1, fig.Pos.y - 2);
			Position p6(fig.Pos.x - 2, fig.Pos.y - 1);
			Position p7(fig.Pos.x - 2, fig.Pos.y - 1);
			Position p8(fig.Pos.x - 1, fig.Pos.y - 2);

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
	}


	int q, w, b, m;
	vector<FigureRep> whites;
	vector<FigureRep> blacks;

	Board nextBoard(Board board, int x, int y)
	{
		//take figure at (x,y)
		FigureRep fig = board.Fields[x][y];
		if (fig.Type != NoneType)
		{
			vector<Position> positions = getNextPossible(fig);
			for (int i = 0; i < positions.size(); i++)
			{
				Position pi = positions[i];
				FigureRep figureThere = board.Fields[pi.x][pi.y];
				if (figureThere.Type == NoneType)
				{
					//we can move here
				}
			}
		}
		else
		{
			return board;
		}
	}

	bool isMat(Board tmpBoard, int deep)
	{
		return false;
	}


	//ifstream fcin;
	void virtual Solve()
	{
		cin >> q;
		char figureChar, figurePosHorizontal;
		int figurePosVertical;
		for (int i = 0; i < q; i++)
		{
			cin >> w >> b >> m;

			Board initBoard; //empty board

			for (int  k = 0; k < w+b; k++)
			{
				cin >> figureChar >> figurePosHorizontal >> figurePosVertical;
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

				int x = figurePosVertical - 'A';
				int y = figurePosVertical - 1;
				figRep.Pos.x = x;
				figRep.Pos.y = y;

				if (k < w)
				{
					whites.push_back(figRep);
				}
				else
				{
					blacks.push_back(figRep);
				}

				initBoard.Fields[x][y] = figRep;
			}
		}
	}
};

int main()
{
	shared_ptr<ChessProblem> p;
	p->Solve();
	return 0;
}