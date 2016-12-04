#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <unordered_map> //std::make_heap, std::pop_heap, std::push_heap, std::sort_heap
#include <queue>
#include <map>
#include <functional>
#include <iostream>

using namespace std;

class Heaps
{
public:
	Heaps() {};
	~Heaps() {};

	void Push(vector<int>& heap, int val) {
		heap.push_back(val);
		push_heap(heap.begin(), heap.end(), greater<int>());
	}


	double extractMedian(vector<int> & vec)
	{
		int size = vec.size();
		int mid = size / 2;
		if (size % 2 == 0)
		{
			return 0.5*(vec[mid-1] + vec[mid]);
		}
		else
		{
			return vec[mid];
		}
	}

	int main(){
		int n;
		cin >> n;
		vector<int> a;// (n);
		make_heap(a.begin(), a.end());
		for (int a_i = 0; a_i < n; a_i++){
			int d = a_i+1;
			//cin >> d;// a[a_i];
			Push(a, d);
			//a.push_back(d);
			//sort_heap(a.begin(), a.end());
			cout << extractMedian(a) << endl;
		}
		return 0;
	}
};
