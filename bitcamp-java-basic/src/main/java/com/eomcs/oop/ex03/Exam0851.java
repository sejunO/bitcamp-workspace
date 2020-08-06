package com.eomcs.oop.ex03;

public class Exam0851 {
  static class A {
    int b = 200;
    int c;

    A() {
      System.out.println("A");
    }
    {
      a = 111;
      System.out.println("초기화");
    }

    int a = 100;

  }
  public static void main(String[] args) {
    A obj1 = new A();
    System.out.println(obj1.a);
  }
}
