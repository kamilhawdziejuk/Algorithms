#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <queue>
#include <map>
#include <functional>

using namespace std;

class ArraysSort
{
public:

	ArraysSort() {};
	~ArraysSort() {};


	class point
	{
		int x, y;
	public:
		static bool comp(const point &p1, const point &p2)
		{
			return p1.y < p2.y;
		}
	};

	void testStlSort()
	{
		vector<point> vec;
		sort(vec.begin(), vec.end(), point::comp);
	}


	void test()
	{
		vector<int> data = { 4,5,2,7,5,1,2,3,9,7,5,8,4 };
		quickSort(data, 0, data.size()-1);
	}

	void quickSort(vector<int> &data, int left, int right)
	{
		if (left >= right) return;

		int pivotIndex = left + (right - left)/2;
		int pivot = data[pivotIndex];
		int part = partition(data, left, right, pivot);
		quickSort(data, left, part - 1);
		quickSort(data, part, right);
	}

	int partition(vector<int>& data, int left, int right, int pivot)
	{
		while (left<=right)
		{
			while (data[left] < pivot) left++;
			while (data[right] > pivot) right--;
			if (left <= right)
			{
				swap(data[left], data[right]);
				left++;
				right--;
			}
		}
		return left;
	}
	
	vector<int> merge_sort(const vector<int>& input)
	{
		if(input.size()<=1) return input;
		vector<int> output(input.size());
	 
		//Split Vector//
		int midpoint=0.5*input.size();
		vector<int> input_left(input.begin(),input.begin()+midpoint);
		vector<int> input_right(input.begin()+midpoint,input.end());
	 
		input_left=merge_sort(input_left);
		input_right=merge_sort(input_right);
		merge(input_left.begin(),input_left.end(),input_right.begin(),input_right.end(),output.begin());
	 
		return output;
	}

};
