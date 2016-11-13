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
#include <climits>

using namespace std;
int N, M;

class Elipse
{
public:
	double x1, x2;
	double y1, y2;
	double a;

	double dist(double x1, double y1, double x2, double y2)
	{
		return sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
	}

	bool contains(double testx, double testy)
	{
		double d1 = dist(x1, testx, y1, testy);
		double d2 = dist(x2, testx, y2, testy);
		return (d1 + d2 <= 2 * a);
	}
};

class Polygon
{
public:
	vector<double> vecx;
	vector<double> vecy;

	bool contains(double testx, double testy) {
		//vector<Point> points = polygon.getPoints();
		int i, j, nvert = vecx.size();
		bool c = false;

		for (i = 0, j = nvert - 1; i < nvert; j = i++) {
			if (((vecy[i] >= testy) != (vecy[j] >= testy)) &&
				(testx <= (vecx[j] - vecx[i]) * (testy - vecy[i]) / (vecy[j] - vecy[i]) + vecx[i])
				)
				c = !c;
		}

		return c;
	}
	
};

class GoodPointProblem
{
public:

	ifstream fcin;
	ofstream fcout;
	vector<Polygon> pols;
	vector<Elipse> elis;

	void virtual Solve()
	{
		fcin.open("D:\\stones.txt", ios::in);
		//fcout.open("D:\\stones.out", ios::out | ios::app);
		fcin >> N;

		double minX = 10000;
		double maxX = -10000;
		double minY = 10000;
		double maxY = -10000;
		for (int i = 0; i < N; i++)
		{
			int cnt;
			fcin >> cnt;
			Polygon pol;

			for (int j = 0; j < cnt; j++)
			{
				double x, y;
				fcin >> x;
				fcin >> y;
				pol.vecx.push_back(x);
				pol.vecy.push_back(y);

				minX = min(minX, x);
				maxX = max(maxX, x);
				minY = min(minY, y);
				maxY = max(maxY, y);
			}
			pols.push_back(pol);
		}

		fcin >> M;
		for (int i = 0; i < M; i++)
		{
			Elipse el;
			fcin >> el.x1 >> el.y1 >> el.x2 >> el.y2 >> el.a;
			elis.push_back(el);
		}

		bool found = false;
		double resX = -10000;
		double resY = -10000;
		for (double i = minX; i <= maxX; i++)
		{
			if (found) break;
			for (double j = minY; j <= maxY; j++)
			{
				if (found) break;

				found = true;
				for (int p = 0; p < pols.size(); p++)
				{
					if (!pols[p].contains((int)i, (int)j))
					{
						found = false;
						break;
					}
				}
				if (found)
				{
					for (int e = 0; e < elis.size(); e++)
					{
						if (!elis[e].contains((int)i, (int)j))
						{
							found = false;
							break;
						}
					}
				}
				if (found)
				{
					resX = i;
					resY = j;
				}
			}
		}
		cout << resX << endl;
		cout << resY << endl;
	}
};

int main()
{
	GoodPointProblem *p = new GoodPointProblem();
	p->Solve();
	delete p;
	return 0;
}