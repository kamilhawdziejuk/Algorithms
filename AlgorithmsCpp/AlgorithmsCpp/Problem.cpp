//#include "stdafx.h"

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
#include <memory.h>
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
#define PII pair<int,int>
#define VI vector<int>
#define VLL vector<long long>
#define VULL vector<unsigned long long>
#define VPII vector<pair<int,int> >
#define PLL pair<long long,long long>
#define VPLL vector<pair<long long,long long> >
#define F first
#define S second
#define rep(i, a, b) for(int i = (a); i < (b); i++)
#define repd(i, a, b) for(int i = (a); i > (b); i--)
#define forIt(it, a) for(__typeof((a).begin()) it = (a).begin(); it != (a).end(); it++)
#define forRev(it, a) for(__typeof((a).rbegin()) it = (a).rbegin(); it != (a).rend(); it++)
#define ft(a) __typeof((a).begin())
#define LL long long
#define ld long double
#define fi first
#define se second
#define mk make_pair
#define pb push_back
#define sz(a) (int)(a).size()
#define all(a) (a).begin(), (a).end()
#define Rep(i,n) for(int i = 0; i < (n); ++i)
#define bitcount(n) __builtin_popcountll(n)
#define pii pair<int, int>

typedef complex<ld> cplex;
typedef vector<int> vi;
typedef pair<int, int> ii;
typedef pair<ii, int> iii;
typedef vector<ii> vii;
typedef vector<iii> viii;

const int MOD = 1e9 + 7;
const int SIZE = 1e6 + 10;
const double EPS = 1e-12;
const double PI = acos(-1);

class Problem
{
public:

	LL n;
	int d;
	VLL vec;
	LL res = 0;
	ifstream fcin;

	Problem(string name="")
	{
	}

	~Problem()
	{

	}

	void virtual Read()
	{
		cin >> n;
		REP(i, n)
		{
			cin >> d;
			vec.push_back(d);
		}
	}

	void virtual Solve()
	{
		REP(i, n)
		{
			res += vec[i];
		}
	}

	void virtual Print()
	{
		cout << res;
	}
};

int main()
{
	Problem *p = new Problem();
	p->Read();
	p->Solve();
	p->Print();
	delete p;
	return 0;
}