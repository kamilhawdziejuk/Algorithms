#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <queue>
#include <map>
#include <functional>

using namespace std;

class Maths
{
public:
	Maths() {};
	~Maths() {};

	//https://leetcode.com/problems/powx-n/
	//O(logn)
     double MyPow(double x, int n) {
            if (n==0) return 1;
            if (n==1) return x;
            if (n==-1) return 1/x;
            return MyPow(x*x,n/2)*(n%2==0?1:n>0?x:1/x);
    }
};
