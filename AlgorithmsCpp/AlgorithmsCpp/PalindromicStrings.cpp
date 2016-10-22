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

class PalindromicStrings
{
public:
	vector<string> strings;
	vector<string> results;
	vector< vector<string> > subsets;
	vector< set<char> > chars;

	int q;
	int n;
	int amount;

	vector<string> powerSet(string& nums)
	{
		int n = nums.size();
		int N = pow(2, n);
		vector<string> res;
		for (int nr = 0; nr < N; ++nr)
		{
			string nrSet;
			string data = DecToBin2(nr);
			int length = data.size();
			int i = 0;
			for (auto elem : nums)
			{
				if (i >= length) break;
				if (data.at(length - i - 1) == '1')
				{
					nrSet += elem;
				}
				i++;
			}
			if (nrSet != "")
			{
				res.push_back(nrSet);
			}
		}
		return res;
	}

	string DecToBin2(int number)
	{
		string result = "";

		do
		{
			if ((number & 1) == 0)
				result += "0";
			else
				result += "1";

			number >>= 1;
		} while (number);

		std::reverse(result.begin(), result.end());
		return result;
	}

	void generateSubsets()
	{
		for (int i = 0; i < n; i++)
		{
			vector<string> si = powerSet(strings[i]);
			subsets.push_back(si);
		}
	}

	void generetePossibleStrings(vector<int> indexes)
	{
		int k = indexes.size();
		if (k == n)
		{
			string str;
			for (int i = 0; i < n; i++)
			{
				int ind = indexes[i];
				str += subsets[i][ind];
			}
			results.push_back(str);
		}
		else
		{ 
			for (int i = 0; i < subsets[k].size(); i++)
			{
				vector<int> vec;
				vec.insert(vec.begin(), indexes.begin(), indexes.end());
				vec.push_back(i);
				generetePossibleStrings(vec);
			}
		}
	}

	bool isPalindrom(string& str)
	{
		int m = str.size();
		for (int i = 0; i <= m / 2; i++)
		{
			if (str[i] != str[m - 1 - i])
			{
				return false;
			}
		}
		return true;
	}

	int createAndCalcPalindroms()
	{
		int cnt = 0;
		for (int i = 0; i < results.size(); i++)
		{
			bool isPalin = isPalindrom(results[i]);
			if (isPalin)
			{
				cnt++;
			}
		}
		return cnt;
	}

	bool haveSthCommon(set<char> &s1, set<char> &s2)
	{
		vector<char> common_data;
		set_intersection(s1.begin(), s1.end(), s2.begin(), s2.end(), back_inserter(common_data));
		return (common_data.size() > 0);
	}

	bool setChars()
	{
		for (int i = 0; i < n; i++)
		{
			set<char> empty;
			chars.push_back(empty);
			string str = strings[i];
			for (int j = 0; j < str.size(); j++)
			{
				chars[i].insert(str[j]);
			}
		}

		for (int i = 0; i < n; i++)
		{
			set<char> si = chars[i];

			bool atLeastOneCommon = false;
			for (int j = 0; j < n; j++)
			{
				if (i != j)
				{
					set<char> sj = chars[j];
					if (haveSthCommon(si, sj))
					{
						atLeastOneCommon = true;
						break;
					}
				}
			}
			if (!atLeastOneCommon)
			{
				return false;
			}
		}
		return true;
	}

	//ifstream fcin;
	void virtual Solve()
	{
		cin >> q;
		for (int i = 0; i < q; i++)
		{
			cin >> n;
			strings.clear();
			subsets.clear();
			results.clear();
			chars.clear();

			string str;
			for (int j = 0; j < n; j++)
			{
				cin >> str;
				strings.push_back(str);
			}

			bool res = setChars();
			if (!res)
			{
				cout << "0" << endl;
			}
			else
			{
				generateSubsets();
				vector<int> inds;

				generetePossibleStrings(inds);

				int palins = createAndCalcPalindroms();
				cout << palins << endl;
			}
		}
	}
};

int mainPalindorm()
{
	PalindromicStrings *p = new PalindromicStrings();
	p->Solve();
	return 0;
}