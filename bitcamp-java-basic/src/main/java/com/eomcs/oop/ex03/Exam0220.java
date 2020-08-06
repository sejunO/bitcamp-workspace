package com.eomcs.oop.ex03;

public class Exam0220 {

  static class A {

    static int v1;
    int v2;

    static void m1() {
      System.out.println("m1()");
      v1 = 200;
    }

    void m2() {
      System.out.println("m2()");
      this.v2 = 200;

      m1();
    }

    static int abs(int value) {
      return (value < 0) ? -value : value;
    }

  }
  public static void main(String[] args) {
    A.m1();
    A obj1 = new A();
    obj1.m2();

    System.out.println(A.abs(-100));
    System.out.println(obj1.v2);
  }
}