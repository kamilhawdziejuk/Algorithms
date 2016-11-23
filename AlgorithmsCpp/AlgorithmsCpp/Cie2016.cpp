//#include "cielib.h"
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


int d, k, r;
int *t;

int podajD()
{
	return rand() % 1000 + 1;
}

int podajK()
{
	return 100 * d;
}

int podajR()
{
	return 2;
}

int czyCieplo(int pozycja[])
{
	return rand() % 2;
}

void znalazlem(int pozycja[])
{
}

class Cie2016Problem
{
public:

	int czyCieplo(int pos)
	{
		int res = rand() % 2;
		return res;
	}

	int get13(int lowest, int highest)
	{
		int diff = highest - lowest;
		int next = lowest + diff / 3;
		if (next == lowest)
		{
			next++;
		}
		if (next > highest)
		{
			next = highest;
		}
		return next;
	}

	int get23(int lowest, int highest)
	{
		int diff = highest - lowest;
		int next = lowest + 2 * diff / 3;
		if (next == lowest)
		{
			next++;
		}
		if (next > highest)
		{
			next = highest;
		}
		return next;
	}

	int get12(int lowest, int highest)
	{
		int diff = highest + lowest;
		int next = diff / 2;
		if (next == lowest)
		{
			next++;
		}
		if (next > highest)
		{
			next = highest;
		}
		return next;
	}

	int find(int lowest, int highest, int closest)
	{
		if (lowest == highest)
		{
			return lowest;
		}

		int next;
		int res;
		if (closest == lowest)
		{
			next = get23(lowest, highest);
			if (czyCieplo(next))
			{
				lowest = get12(lowest, next);
				res = find(lowest, highest, next);
				return res;
			}
			else
			{
				highest = get13(lowest, highest);
				res = find(lowest, highest, lowest);
				return res;
			}
		}
		else
		{
			next = get23(closest, highest);
			if (czyCieplo(next))
			{
				lowest = get12(closest, next);
				res = find(lowest, highest, next);
				return res;
			}
			else
			{
				highest = get12(closest, next);
				res = find(lowest, highest, next);
				return res;
			}
		}
	}

	int find(int dim, int size)
	{
		int res = find(0, size, 0);
		return res;
	}

	int find(int tab[])
	{

	}

	void virtual Solve()
	{
	}
};

int main()
{
	Cie2016Problem *p = new Cie2016Problem();

	d = podajD();
	k = podajK();
	r = podajR();

	t = new int[d];
	p->find(t);

	p->Solve();
	delete p;
	return 0;
}