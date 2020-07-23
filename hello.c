#include <stdio.h>
#include <stdlib.h>
int main() {
    int age;
    age = 20;
    int* pAge = malloc(4);
    *pAge = 200;

    printf("%d",age);

     
    return 0;
}