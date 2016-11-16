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

class SloProblem
{
private:
	int n;
	ULL k;

	string result;
	char curr = '0';
public:

	unordered_map<int, ULL> powers;
	unordered_map<char, vector<char>> nexts;

	void setupPowers()
	{
		for (int i = 0; i < 64; i++)
		{
			powers.insert(pair<int, ULL>(i, pow(2, i)));
		}
	}

	void setupNexts()
	{
		vector<char> a = { 'a'};
		vector<char> ab = { 'a', 'b' };
		vector<char> bc = { 'b', 'c' };
		vector<char> ac = { 'a', 'c' };

		nexts.insert(pair<char, vector<char>>('a', bc));
		nexts.insert(pair<char, vector<char>>('b', ac));
		nexts.insert(pair<char, vector<char>>('c', ab));

		nexts.insert(pair<char, vector<char>>('0', a));
	}

	void calc()
	{
		int j = n;
		ULL left = k;
		while (left > 0)
		{			
			ULL sum = left + 1;
			if (j < 64) 
			{
				sum = powers[j] - 1;
			}
			if (sum >= left)
			{
				curr = nexts[curr][0];
				result += curr;
				left--;
			}
			else if (j != n)
			{
				curr = nexts[curr][1];
				left = left - sum - 1;
				result += curr;
			}
			else
			{
				if (3 * sum < left)
				{
					break;
				}
				else if (2 * sum < left)
				{
					left = left - 2 * sum - 1;
					curr = 'c';
					result += curr;
				}
				else if (sum < left)
				{
					left = left - sum - 1;
					curr = 'b';
					result += curr;
				}
				else
				{
					break;
				}
			}
			j--;
		}
		if (j == n)
		{
			result = "NIE";
		}
	}

	//ifstream fcin;
	void virtual Solve()
	{
		cin >> n;
		cin >> k;
		setupPowers();
		setupNexts();
		calc();
		cout << result;
	}
};

int main()
{
	SloProblem *p = new SloProblem();
	p->Solve();
	delete p;
	return 0;
}