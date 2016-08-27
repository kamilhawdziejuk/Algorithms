#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <queue>
#include <map>
#include <functional>

class ArraysSort
{
public:

	ArraysSort() {};
	~ArraysSort() {};

	void test()
	{
		vector<int> data = { 4,5,2,7,5,1,2,3,9,7,5,8,4 };
		quickSort(data, 0, data.size()-1);
	}

	void quickSort(vector<int> &data, int left, int right)
	{
		if (left >= right) return;

		int part = partition(data, left, right);
		quickSort(data, left, part);
		quickSort(data, part + 1, right);
	}

	int partition(vector<int>& data, int i, int j)
	{
		int pivotIndex = i + (j - i) / 2;
		int pivot = data[pivotIndex];
		while (i<=j)
		{
			while (data[i] < pivot) i++;
			while (data[j] > pivot) j--;
			if (i < j)
			{
				swap(data[i], data[j]);
				i++;
				j--;
			}
			else
			{
				break;
			}
		}
		return j;
	}

	/*
	int partition(vector<int> input, int i, int j)
	{
		int pivot = input[j];
		while (i < j)
		{
			while (input[i] < pivot) i++;
			while (input[j] > pivot) j--;

			if (input[i] == input[j])
			{
				i++;
			}
			else if (i < j)
			{
				swap(input[i], input[j]);
			}
		}

		return j;
	}*/


};