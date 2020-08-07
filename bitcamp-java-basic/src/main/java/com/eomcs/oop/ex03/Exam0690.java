package com.eomcs.oop.ex03;

public class Exam0690 {

  public static class A {

    static int a = 100;

    static {
      a = 200;
      System.out.println("static");
    }

    static int b = 300;

    static {
      b = 400;
    }
  }
}
