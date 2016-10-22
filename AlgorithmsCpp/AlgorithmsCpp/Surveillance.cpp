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

class Board2
{
public:
	int m, n;
	vector< vector<int> > Fields;

	Board2(int _n, int _m)
	{
		n = _n;
		m = _m;
		for (int row = 0; row < n; row++)
		{
			vector<int> nextCol(m, -1);
			Fields.push_back(nextCol);
		}
	}

	Board2 copy()
	{
		Board2 newBoard(n, m);
		for (int row = 0; row < n; row++)
		{
			for (int col = 0; col < m; col++)
			{
				newBoard.Fields[row][col] = Fields[row][col];
			}
		}
		return newBoard;
	}

	bool operator==(const Board2& other) const
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (Fields[i][j] != other.Fields[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}

	bool operator!=(const Board2& other) const
	{
		return !(*this == other);
	}
};


class SurveillanceProblem
{
public:
	int C;
	int M, N;
	int res = 0;
	//multiplication of two large numbers modulo MOD
	ULL mulmod(ULL a, ULL b) {
		ULL rv = 0;
		while (b) {
			if (b & 1)
				if ((rv += a) >= MOD) rv -= MOD;
			if ((a += a) >= MOD) a -= MOD;
			b >>= 1;
		}
		return rv;
	}

	bool check(Board2& board, int row, int col)
	{
		return true;
	}

	Position getNext(int rows, int cols, int r, int c)
	{
		Position pos;
		if (rows < N)
		{
			if (r <= rows + 1)
			{
				pos.y = c;
				pos.x = r+1;
			}
			else if (c > 1)
			{
				pos.x = r;
				pos.y = c - 1;
			}
		}
		else
		{
			//if (r <= rows)
		}
		return pos;
	}

	void calc(Board2& board, int rows, int cols, int r, int c)
	{
		vector<Board2> nextBoards;

		//take figure at (x,y)
		int fig = board.Fields[r][c];
		if (fig == -1)
		{
			Board2 copy = board.copy();
			copy.Fields[r][c] = 1;
			if (check(copy, r, c))
			{
				if (r <= rows+1 && r + 1 < N)
				{
					calc(copy, rows, cols, r + 1, c);
				}
				else if ((r + 1 == rows) && c > 1)
				{
					calc(copy, rows, cols, r, c - 1);
				}
			}
			copy.Fields[r][c] = 0;
			if (check(copy, r, c))
			{
				if (r <= rows + 1)
				{
					calc(copy, rows, cols, r + 1, c);
				}
				else if (r > 1)
				{
					calc(copy, rows, cols, r, c - 1);
				}
			}
		}
	}

	//ifstream fcin;
	void virtual Solve()
	{
		cin >> C;
		for (int i = 0; i < C; i++)
		{
			cin >> N >> M;

			Board2 inital(N, M);
			inital.Fields[0][0] = 1;
			inital.Fields[1][1] = 1;
			calc(inital, 2, 3, 0, 3);
		}
	}
};

int main222()
{
	SurveillanceProblem *p = new SurveillanceProblem();
	p->Solve();
	return 0;
}