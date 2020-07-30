package com.eomcs.basic.sejun;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();

    if (B < 45) {
      B = 60 + B - 45;
      A--;
    } else {
      B = B -45;
    }

    if (A > 24) {
      A = A % 24;
    } else if (A < 0) {
      A = (A + 24);
    }
    System.out.printf("%d %d",A, B);
  }
}
