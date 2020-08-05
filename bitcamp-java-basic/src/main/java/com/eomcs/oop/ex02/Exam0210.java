package com.eomcs.oop.ex02;


import com.eomcs.util.Calculator;


public class Exam0210 {

  public static void main(String[] args) {
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(2);
    c1.plus(3);
    c1.minus(1);
    c1.multiple(7);
    c2.plus(2);
    c1.divide(3);

    printResult(c1.result);
    printResult(c2.result);
  }
  static void printResult(int value) {
    System.out.println("----------------");
    System.out.println("결과 ====>   " + value);
    System.out.println("----------------");
  }
}



