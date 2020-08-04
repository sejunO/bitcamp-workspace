#include <stdio.h>
#include <stdlib.h>


void f1(int a) {
  a = 100;
}
void f2(int* p) {
  *p = 100;
}

int main() {
  int a = 200;
   f1(a);

   printf("a = %d\n" ,a);

   f2(&a);
  printf("a = %d\n" ,a);
   

  return 0;
}


