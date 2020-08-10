package com.eomcs.oop.ex03;

public class Exam0710 {
  static class A {
    int a;
    int b;
    int c;

    {
      a = 100;
      System.out.println("H e l l o !");
    }

  }
  public static void main(String[] args) {
    A obj1 = new A();
    System.out.println(obj1.a);

  }
}
