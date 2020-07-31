package com.eomcs.basic.ex06;

public class Exam0432 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    loop1: {
    for (int i =1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
        if (j == 5) {
          break loop1;
        }
      }
      System.out.println();
    }
    System.out.println("------------------------");
  }
  }

}
