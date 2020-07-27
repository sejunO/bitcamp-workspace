#include <stdio.h>
#include <stdlib.h>
int main() {
  int i1, i2, i3;
  int i[3];

  i[0] = 100;
  i[1] = 200;
  i[2] = 300;
  
  printf("%d %d %d \n", i[0], i[1], i[2]);

  int* p;

  p = &i[0];
  printf("%d\n", *(p+1));

    p = &i[1];
  printf("%d\n", *p);

    p = &i[2];
  printf("%d\n", *p);

  int* p2 = (int*)malloc(12);

  *p2 = 110;
  *(p2+1) = 220;
  *(p2+2) = 330;

  printf("%d %d %d \n", *p2, *(p2+1), *(p2+2));

  printf("%d\n", *(p2+4));

  free(p2);

  return 0;
}


