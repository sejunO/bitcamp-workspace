package com.eomcs.oop.ex03;

public class Exam0680 {

  public static class A {
    static int a = 7;

    static {
      a += B.b;
    }
  }

  public static class B {
    static int b = 22;
    static {
      b += A.a;

    }
  }

  public static void main(String[] args) {
    System.out.println(A.a);
    System.out.println(B.b);
  }
}
