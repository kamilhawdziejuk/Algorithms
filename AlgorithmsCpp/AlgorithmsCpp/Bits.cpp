#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <queue>
#include <map>
#include <functional>
#include <bitset>

using namespace std;

class Bits
{
public:
	Bits() {};
	~Bits() {};

	string Dec2ToBin2BitSet(uint32_t number)
	{
		string binary = std::bitset<32>(number).to_string();
		int posNot0 = binary.find_first_not_of('0');
		return binary.substr(posNot0, binary.size() - posNot0);
	}

	unsigned long Bin2DecBitset(string binary)
	{
		unsigned long decimal = std::bitset<32>(binary).to_ulong();
		return decimal;
	}

    uint32_t reverseBits(uint32_t n) {
        string str = Dec2ToBin2BitSet(n);
        std::reverse(str.begin(), str.end());
        unsigned long res = Bin2DecBitset(str);
        return (uint32_t)res;
    }
};

int mainBits()
{
	//shared_ptr<Bits> b(new Bits());
	Bits *b = new Bits();
	 uint32_t res = b->reverseBits(0);
	 delete b;
	 return 0;
}
