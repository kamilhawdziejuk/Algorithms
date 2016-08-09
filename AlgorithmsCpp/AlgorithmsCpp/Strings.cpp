#include "stdafx.h"
#include <string>
#include <algorithm>
#include <vector>

class Strings
{
	public:
		Strings() {}
		~Strings() {}

		//https://leetcode.com/problems/longest-common-prefix/
		string longestCommonPrefix(vector<string>& strs) {
			if (strs.size() == 0 || strs.at(0).size() == 0)
			{
				return string("");
			}

			string f = strs.at(0);
			bool t = true;
			int n = 0;
			while (t)
			{
				if (f.size() < n + 1) break;
				for (int i = 1; i < strs.size(); i++)
				{
					string s2 = strs.at(i);
					if (s2.size() < n + 1 || s2.at(n) != f.at(n))
					{
						t = false;
						break;
					}
				}
				if (t) n++;
			}
			if (n == 0)
			{
				return string("");
			}
			return strs.at(0).substr(0, n);
		}


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
