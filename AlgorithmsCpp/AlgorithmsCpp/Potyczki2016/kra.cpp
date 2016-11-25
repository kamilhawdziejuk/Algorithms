#include <cstdlib>
#include <iostream>
#include <vector>

#include "krazki.h"
#include "krazki.cpp"
#include "message.h"

using namespace std;

int n;
int m;
vector<long long> vec;
vector<long long> tests;

int last;

int findMin(int nr)
{
  long long val = tests[nr-1];
  int res = 0;
  for (int i = 1; i <= last; i++)
  {
    if (val > vec[i-1])
    {
      break;
    }
    else
    {
      res++;
    }
  }
  return res;
}

int main() {
  // Tylko zerowy komputer coś liczy.
  if (MyNodeId() != 0) {
    return EXIT_SUCCESS;
  }

  n = PipeHeight();
  m = NumberOfDiscs();

  long long d;
  for (int i = 1; i <= n; i++)
  {
    d = HoleDiameter(i);
    vec.push_back(d);
  }

  for (int i = 1; i <= m; i++)
  {
    d = DiscDiameter(i);
    tests.push_back(d);
  }

  last = n;

  for (int i = 1; i <= m; i++)
  {
    last = findMin(i);
    if (i < m)
    {
      last--;
    }
    if (last == 0)
    {
      break;
    }
  }

  std::cout << last << std::endl;
  return EXIT_SUCCESS;
}
