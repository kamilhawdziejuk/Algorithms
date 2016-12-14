#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <unordered_map> //std::make_heap, std::pop_heap, std::push_heap, std::sort_heap
#include <queue>
#include <map>
#include <functional>
#include <iostream>

using namespace std;

class MinHeap
{
private:
	vector<int> _vector;

	void BubbleDown(int index)
	{
		int length = _vector.size();
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;

		if (leftChildIndex >= length)
			return; //index is a leaf

		int minIndex = index;

		if (_vector[index] > _vector[leftChildIndex])
		{
			minIndex = leftChildIndex;
		}

		if ((rightChildIndex < length) && (_vector[minIndex] > _vector[rightChildIndex]))
		{
			minIndex = rightChildIndex;
		}

		if (minIndex != index)
		{
			//need to swap
			int temp = _vector[index];
			_vector[index] = _vector[minIndex];
			_vector[minIndex] = temp;
			BubbleDown(minIndex);
		}
	}
	void BubbleUp(int index)
	{
		if (index == 0)
			return;

		int parentIndex = (index - 1) / 2;

		if (_vector[parentIndex] > _vector[index])
		{
			int temp = _vector[parentIndex];
			_vector[parentIndex] = _vector[index];
			_vector[index] = temp;
			BubbleUp(parentIndex);
		}
	}

	void Heapify()
	{
		int length = _vector.size();
		for (int i = length - 1; i >= 0; --i)
		{
			BubbleDown(i);
		}
	}

public:
	//MinHeap(int* array, int length);
	MinHeap(const vector<int>& vector) : _vector(vector)
	{
		Heapify();
	}

	MinHeap() {}

	void Insert(int newValue)
	{
		int length = _vector.size();
		_vector[length] = newValue;

		BubbleUp(length);
	}

	int GetMin()
	{
		return _vector[0];
	}

	void DeleteMin()
	{
		int length = _vector.size();

		if (length == 0)
		{
			return;
		}

		_vector[0] = _vector[length - 1];
		_vector.pop_back();

		BubbleDown(0);
	}
};


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
