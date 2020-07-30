package com.eomcs.basic.sejun;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();

    if (A < B) {
      int temp = A;
      A = B;
      B = temp;
    }
    int a = A, b = B;



    while (b > 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }



    System.out.printf("%d %d",a, A*B/a);
  }
}
