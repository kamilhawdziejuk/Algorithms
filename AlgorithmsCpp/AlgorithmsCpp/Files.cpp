#include "stdafx.h"
#include <string>
#include <vector>
#include <cstdint>
#include <fstream>

using namespace std;

#pragma once
class Files
{
private: 
	ifstream fin;

public:
	Files()
	{
		fin.open("my-input-file.txt", ios::in);
		Read(fin, 10);
	}
	~Files()
	{
		fin.close();
	}

	static string Read(istream &stream, uint32_t count)
	{
		std::vector<char> result(count);  // Because vector is guranteed to be contiguous in C++03
		stream.read(&result[0], count);

		return std::string(&result[0], &result[count]);
	}

	string ReadCharByChar(istream &stream, uint32_t count)
	{
		char c;
		while (!stream.eof()) 
		{
			stream.get(c);
		}
	}
};

