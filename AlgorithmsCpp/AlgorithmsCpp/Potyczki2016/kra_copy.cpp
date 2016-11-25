#include <cstdlib>
#include <iostream>

#include "krazki.h"
#include "krazki.cpp"
#include "message.h"

int main() {
  // Tylko zerowy komputer coś liczy.
  if (MyNodeId() != 0) {
    return EXIT_SUCCESS;
  }
  int depth;
  long long int max_disc_diameter = 0;
  for (int i = 1; i <= NumberOfDiscs(); i++) {
    max_disc_diameter = std::max(max_disc_diameter, DiscDiameter(i));
  }
  if (HoleDiameter(PipeHeight()) < max_disc_diameter) {
    depth = 0;
  } else {
    depth = std::max(0, PipeHeight() - NumberOfDiscs() + 1);
  }
  std::cout << depth << std::endl;
  return EXIT_SUCCESS;
}
