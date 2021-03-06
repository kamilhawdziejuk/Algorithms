#include "stdafx.h"
#include <string>
#include <algorithm>
#include <vector>
#include <sstream>
#include <set>
#include <unordered_map>
#include <climits>

using namespace std;

class Strings
{
public:
	Strings() {}
	~Strings() {}

	//https://leetcode.com/problems/string-to-integer-atoi/
	int myAtoiUsingStream(string str)
	{
		istringstream sin(str);
		int ans = 0;
		sin >> ans;
		return ans;
	}

	//https://leetcode.com/problems/string-to-integer-atoi/
	int myAtoi(string str) {
		long long res = 0;
		long long d = 1;

		if (str.size() == 0)
		{
			return 0;
		}

		while (isspace(*str.begin())) str.erase(str.begin());
		while (isspace(*str.rbegin())) str.erase(str.length() - 1);

		int sign = 1;
		if (str.at(0) == '+')
		{
			str = str.substr(1, str.size() - 1);
		}
		else if (str.at(0) == '-')
		{
			sign *= -1;
			str = str.substr(1, str.size() - 1);
		}

		int last = str.find_first_not_of("0123456789", 0);
		if (last == -1) last = str.size();

		for (int i = last - 1; i >= 0; i--)
		{
			char c = str.at(i);
			int num = c - '0';
			res += d*num;

			if (res*sign > INT_MAX)
				return INT_MAX;
			if (res*sign < INT_MIN)
				return INT_MIN;

			d *= 10;
		}

		return sign * res;
	}

	//https://leetcode.com/problems/reverse-words-in-a-string
	void reverseWords(string &s) {
		int l = s.size();
		reverseWord(s, 0, l - 1);
		string s2;
		int j = 0;

		int p = s.find_first_not_of(" ");
		while (p != string::npos)
		{
			int q = s.find_first_of(" ", p + 1);
			if (q == string::npos)
			{
				q = l;
			}
			reverseWord(s, p, q - 1);

			for (int i = p; i < q; i++) s2.push_back(s[i]);
			p = s.find_first_not_of(" ", q + 1);
			if (p != -1)
			{
				s2.push_back(' ');
			}
		}
		s = s2;
	}

	void reverseWord(string &s, int start, int end) {
		while (start < end) {
			swap(s[start], s[end]);
			++start;
			--end;
		}
	}

	//https://leetcode.com/problems/implement-strstr/
	int strStr(string haystack, string needle) {
		int h = haystack.size(), n = needle.size();
		if (n == 0) return 0;
		for (int i = 0; i <= h - n; i++) {
			for (int j = 0; j < needle.size(); j++) {
				if (haystack[i + j] != needle[j]) break;
				if (j == needle.size() - 1) return i;
			}
		}
		
		return -1;
	}

	//https://leetcode.com/problems/reverse-words-in-a-string
	void reverseWordsStream(string& s) {
		reverse(s.begin(), s.end());
		stringstream ss(s);
		s.clear();
		string tmp;
		while (ss >> tmp) {
			reverse(tmp.begin(), tmp.end());
			s += tmp + " ";
		}
		if (!s.empty()) s.erase(s.size() - 1);
	}

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

	vector<string> splitOptimal(string str, char delimiter) {
		vector<string> splits;
		string temp;
		stringstream ss(str);
		while (getline(ss, temp, delimiter)) {
			splits.push_back(temp);
		}

		return splits;
	}

	//https://leetcode.com/problems/simplify-path/
	string simplifyPath(string path) {
		vector<string> st;
		vector<string> nodes;
		string result;
		nodes = splitOptimal(path, '/');
		for (auto node : nodes) {
			//empty or only '.' path no change
			if (node == "" || node == ".")  continue;
			//go back to the upper directory
			if (node == ".." && !st.empty())  st.pop_back();
			//push back the current directory
			else if (node != "..")  st.push_back(node);
		}
		for (auto it : st) result += "/" + it;
		return result.empty() ? "/" : result;
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

	//https://leetcode.com/problems/longest-substring-without-repeating-characters/
	int lengthOfLongestSubstring(string s) {
		set<char> set;

		int maxL = 1;
		int i = 0;
		int j = 0;

		if (s.size() <= 1) return s.size();

		while (i <= j && j < s.size())
		{
			if (set.find(s[j]) == set.end())
			{
				set.insert(s[j]);
				maxL = max(maxL, j - i + 1);
				j++;
				
			}
			else
			{
				set.erase(s[i]);
				i++;
			}
		}
		return maxL;
	}

	// Utility function to find minimum of three numbers
    int min(int x,int y,int z)
    {
        if (x<y && x<z) return x;
        if (y<x && y<z) return y;
        else return z;
    }

	//http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
	/*Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number
	 * of edits (operations) required to convert ‘str1’ into ‘str2’.
		Insert
		Remove
		Replace
	All of the above operations are of equal cost.*/
	int editDistDP(string str1, string str2, int m, int n)
	{
	    // Create a table to store results of subproblems
	    //int dp[m+1][n+1];
		vector< vector<int> > dp;

	    // Fill d[][] in bottom up manner
	    for (int i=0; i<=m; i++)
	    {
	        for (int j=0; j<=n; j++)
	        {
	            // If first string is empty, only option is to
	            // insert all characters of second string
	            if (i==0)
	                dp[i][j] = j;  // Min. operations = j

	            // If second string is empty, only option is to
	            // remove all characters of second string
	            else if (j==0)
	                dp[i][j] = i; // Min. operations = i

	            // If last characters are same, ignore last char
	            // and recur for remaining string
	            else if (str1[i-1] == str2[j-1])
	                dp[i][j] = dp[i-1][j-1];

	            // If last character are different, consider all
	            // possibilities and find minimum
	            else
	                dp[i][j] = 1 + min(dp[i][j-1],  // Insert
	                                   dp[i-1][j],  // Remove
	                                   dp[i-1][j-1]); // Replace
	        }
	    }

	    return dp[m][n];
	}
};
