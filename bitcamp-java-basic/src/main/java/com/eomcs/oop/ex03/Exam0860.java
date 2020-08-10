package com.eomcs.oop.ex03;

public class Exam0860 {
  static class A {
    int a = 100;

    {
      this.a = 200;
      System.out.println("ch");
    }

    A() {
      System.out.println("A");
    }

    A(int a) {
      this.a = a;
    }
  }
  public static void main(String[] args) {
    A obj1 = new A();
    System.out.println(obj1.a);

    A obj2 = new A(22);
    System.out.println(obj2.a);

    A obj3 = new A();
  }
}


