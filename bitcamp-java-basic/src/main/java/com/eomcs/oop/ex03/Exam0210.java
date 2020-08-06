package com.eomcs.oop.ex03;

public class Exam0210 {

  static class A {

    static int v1;
    int v2;

    static void m1() {
      System.out.println("m1()");
    }
    void m2() {
      System.out.println("m2()");
    }

    static int abs(int value) {
      if (value < 0) {
        return value * -1;
      } else {
        return value;
      }
    }
  }
  public static void main(String[] args) {
    A.m1();
    A obj1 = new A();
    obj1.m2();

    System.out.println(A.abs(-100));
  }
}