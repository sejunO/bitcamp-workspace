package com.eomcs.basic.ex07;

public class Exam0415 {


  public static void main(String[] args) throws Exception {

    int result = 1;

    int n = 5;

    for (int i = 1; i < n+1; i++) {
      result *= i;
    }
    System.out.println(result);
    result = factorial(5);
    System.out.println(result);
  }
  static int factorial(int n) {
    if (n == 1)
      return 1;
    return n * factorial(n - 1);
  }

}