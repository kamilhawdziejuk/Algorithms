#include "stdafx.h"
#include <string>
#include <algorithm>

using namespace::std;

class Strings
{
	public:
		Strings() {}
		~Strings() {}

		string reverseString_std(string str) {
			reverse(str.begin(), str.end());
			return str;
		}

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
};
