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

class Problem
{
public:

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

	ULL n;
	ULL m;//rows
	vector<ULL> vec;
	//ifstream fcin;
	ULL num;

	ULL calc(ULL start, ULL amount)
	{
		ULL res = 0;
		for (ULL i = 0; i < amount; i++)
		{
			ULL index = ((start % n) + (i % n)) % n;
			res ^= vec[index];
		}
		return res;
	}

	std::vector<int> pascal_row(int n){
		std::vector<int> row(n + 1);
		row[0] = 1; //First element is always 1
		for (int i = 1; i<n / 2 + 1; i++){ //Progress up, until reaching the middle value
			row[i] = row[i - 1] * (n - i + 1) / i;
		}
		for (int i = n / 2 + 1; i <= n; i++){ //Copy the inverse of the first part
			row[i] = row[n - i];
		}
		return row;
	}

	void virtual Solve()
	{
		cin >> n >> m;
		for (int i = 0; i < n; i++)
		{
			cin >> num;
			vec.push_back(num);
		}
		
		for (int i = 0; i < n; i++)
		{
			ULL res = calc(i, m);
			cout << res << " ";
		}
	}
};

int main()
{
	//shared_ptr<Problem> p;
	Problem *p = new Problem();
	p->Solve();
	delete p;
	return 0;
}