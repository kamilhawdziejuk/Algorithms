#include "cielib.h"

int main() {
	int t[podajD()]; // W C legalne.
	for(int i = 0; i < podajD(); ++i) {
		t[i] = i;
	}

	while(czyCieplo(t)) {
		for(int i = 0; i < podajD(); ++i) {
			t[i] += 1;
		}
	}

	znalazlem(t);
}
