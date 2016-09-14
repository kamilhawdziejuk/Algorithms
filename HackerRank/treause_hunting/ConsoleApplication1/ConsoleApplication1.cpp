#include "stdafx.h"

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <iomanip>  
#include <algorithm>
using namespace std;

int main() {
	double a, b, x, y;
	cin >> x >> y >> a >> b;
	double W = a*a + b*b;
	double Wk = x*a + b*y;
	double Wn = a*y - b*x;
	double k = Wk / W;
	double n = Wn / W;

	cout.setf(ios::fixed);
	cout << setprecision(5) << k << endl << n;
	return 0;
}

