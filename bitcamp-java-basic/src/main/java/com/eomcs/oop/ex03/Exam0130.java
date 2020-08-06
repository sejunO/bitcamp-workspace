package com.eomcs.oop.ex03;

public class Exam0130 {
  static class A {
    static int v1;
    static boolean v2;
    int a;
  }
  public static void main(String[] args) {


    A obj1 = new A();
    A obj2 = new A();

    obj1.v1 = 100;
    obj2.v1 = 200;
    obj1.a = 100;
    obj2.a = 200;

    System.out.println(obj1.v1);
    System.out.println(obj2.v1);

    System.out.println(obj1.a);
    System.out.println(obj2.a);
  }

}
