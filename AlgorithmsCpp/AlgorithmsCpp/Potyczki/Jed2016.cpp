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

class Jed2016
{
public:

	vector<int> primes;
	int t;
	vector<int> inputs;

	void calcPrimes(int n)
	{
		primes.push_back(2);
		for (int i = 3; i <= n; i++)
		{
			bool prime = true;
			for (int j = 0; j<primes.size() && primes[j] * primes[j] <= i; j++)
			{
				if (i % primes[j] == 0)
				{
					prime = false;
					break;
				}
			}
			if (prime)
			{
				primes.push_back(i);
			}
		}
	}

	int firstFactor(int n)
	{
		int sn = sqrt(n);
		for (int i = 0; i < primes.size(); i++)
		{
			if (i > 0 && primes[i] >= sn) break;
			if (n % primes[i] == 0)
			{
				return primes[i];
			}
		}
		return n;
	}

	int ile(string& str)
	{
		int cnt = 0;
		for (int i = 0; i < str.size(); i++)
		{
			if (str[i] == '1')
			{
				cnt++;
			}
		}
		return cnt;
	}

	string calc(int n)
	{
		string res;
		int cnt = 0;

		if (n == 1)
		{
			return "1";
		}
		while (n >= 2)
		{
			int f1 = firstFactor(n);

			if (f1 == n)
			{
				if (n == 2)
				{
					res = res + "1+1";
					n -= 2;
				}
				else
				{
					res = res + "1+(";
					n--;
					cnt++;
				}
			}
			else
			{
				string fstr;
				if (f1 == 2)
				{
					fstr = "(1+1)";
				}
				else
				{
					fstr = calc(f1);
				}
				res = res + fstr + "*(";
				n /= f1;
				cnt++;
			}
		}
		for (int i = 0; i < cnt; i++)
		{
			res += ")";
		}
		return res;
	}

	int virtual Solve(int k)
	{
		return 0;
	}

};

int mainJed2016()
{
	//Jed2016 *p = new Jed2016();
	shared_ptr<Jed2016> p(new Jed2016);

	//cin >> p->t;
	p->t = 100;
	int m = 1;
	for (int i = 0; i < p->t; i++)
	{
		int d = i + 1;
		//cin >> d;
		p->inputs.push_back(d);
		m = max(d, m);
	}

	int sN = sqrt(m);
	p->calcPrimes(sN);

	for (int i = 0; i < p->t; i++)
	{
		string res_i = p->calc(p->inputs[i]);
		cout << res_i << endl;
	}

	//delete p;
	return 0;
}
