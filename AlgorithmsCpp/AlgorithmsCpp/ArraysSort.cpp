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
		quickSort(data, left, part - 1);
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
	
	// void merge(int pocz, int sr, int kon)
	// {
		// int i,j,q;
		// for (i=pocz; i<=kon; i++) t[i]=tab[i];  // Skopiowanie danych do tablicy pomocniczej
		// i=pocz; j=sr+1; q=pocz;                 // Ustawienie wskaźników tablic
		// while (i<=sr && j<=kon) {         // Przenoszenie danych z sortowaniem ze zbiorów pomocniczych do tablicy głównej
		// if (t[i]<t[j])
		// tab[q++]=t[i++];
		// else
		// tab[q++]=t[j++];
		// }
		// while (i<=sr) tab[q++]=t[i++]; // Przeniesienie nie skopiowanych danych ze zbioru pierwszego w przypadku, gdy drugi zbiór się skończył
	// }

	// /* Procedura sortowania tab[pocz...kon] */
	// void mergesort(vector<int> &data, int pocz, int kon)
	// {
		// if (pocz<kon) 
		// {
			// int sr=(pocz+kon)/2;
			// mergesort(pocz, sr);    // Dzielenie lewej części
			// mergesort(sr+1, kon);   // Dzielenie prawej części
			// merge(pocz, sr, kon);   // Łączenie części lewej i prawej
		// }
	// }
 
};