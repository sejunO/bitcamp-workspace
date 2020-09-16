package com.eomcs.oop.ex12;

public class Exam0120 {
  interface Test {
    void test();
  }
  public static void main(String[] args) {
    Test test = () -> System.out.println("test"); 

    test.test();
  }
}
