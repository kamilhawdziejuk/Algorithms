#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;

int number_needed(string a, string b) {
	unordered_map<char, int> map;
	for (int i = 0; i < 26; i++)
	{
		map.insert(pair<char, int>('a' + i, 0));
	}

	for (int i = 0; i < a.size(); i++)
	{
		char c = a[i];
		map[c]++;
	}
	for (int i = 0; i < b.size(); i++)
	{
		map[b[i]]--;
	}

	int cnt = 0;
	for (int i = 0; i < 26; i++)
	{
		int d = map[i];
		if (d < 0) d *= -1;
		cnt += d;
	}
	return cnt;
}

int main() {
	string a;
	cin >> a;
	string b;
	cin >> b;
	cout << number_needed(a, b) << endl;
	return 0;
}
