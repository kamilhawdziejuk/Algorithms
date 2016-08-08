#include "stdafx.h"
#include <string>
#include <algorithm>
#include <vector>

class Strings
{
	public:
		Strings() {}
		~Strings() {}

		string reverseString_std(string str) {
			reverse(str.begin(), str.end());
			return str;
		}

		//https://leetcode.com/problems/reverse-string/
		string reverseString(string str) {
			int length = str.length();
			int c, i, j;

			for (i = 0, j = length - 1; i < j; i++, j--)
			{
				c = str[i];
				str[i] = str[j];
				str[j] = c;
			}
			return str;
		}

		vector<string> split(string str, string delimiter)
		{
			vector<string> splits;
			size_t pos = 0;
			std::string token;

			while ((pos = str.find(delimiter)) != std::string::npos) {
				token = str.substr(0, pos);
				splits.push_back(token);
				str.erase(0, pos + delimiter.length());
			}
			splits.push_back(str);
			return splits;
		}

		//https://leetcode.com/problems/compare-version-numbers/
		int compareVersion(string version1, string version2) {
			vector<string> v1 = split(version1, ".");
			vector<string> v2 = split(version2, ".");

			int s1 = v1.size();
			int s2 = v2.size();

			int i = 0;
			while (i < s1 && i < s2)
			{
				int l1 = stoi(v1.at(i));
				int l2 = stoi(v2.at(i));
				if (l1 < l2)
				{
					return -1;
				}
				else if (l1 > l2)
				{
					return 1;
				}
				i++;
			}
			if (s1 == s2)
			{
				return 0;
			}
			else
			{
				if (s1 < s2)
				{
					while (i < s2)
					{
						int l2 = stoi(v2.at(i));
						if (l2 != 0)
						{
							return -1;
						}
						i++;
					}
					return 0;
				}
				while (i < s1)
				{
					int l1 = stoi(v1.at(i));
					if (l1 != 0)
					{
						return 1;
					}
					i++;
				}
				return 0;
			}
		}
};
