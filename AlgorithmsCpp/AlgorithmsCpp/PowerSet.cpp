#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <cmath>
#include <map>
#include <cstdint>
#include <unordered_map>
#include <string>
#include <bitset>
#include <set>

using namespace std;


class PowerSet
{
public:
	PowerSet() {}
	~PowerSet() {}

	set<set<int>> powerSet(set<int> nums)
	{
		int n = nums.size();
		int N = pow(2, n);
		set<set<int>> res;
		for (int nr = 0; nr < N; ++nr)
		{
			set<int> nrSet;
			string data = DecToBin2(nr);
			int length = data.size();
			int i = 0;
			for (auto elem : nums)
			{
				if (i >= length) break;
				if (data.at(length - i - 1) == '1')
				{
					nrSet.insert(elem);
				}
				i++;
			}
			res.insert(nrSet);
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

};

