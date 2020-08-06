package com.eomcs.oop.ex03;

public class Exam0730 {
  static class A {
    int a = 100;
    int b;
    int c;


    A() {
      a = 10;
    }
    int d = 10;
  }
  public static void main(String[] args) {

    A obj1 = new A();
    System.out.printf("a=%d, b=%d, c=%d, %d\n",
        obj1.a, obj1.b, obj1.c, obj1.d);


  }

}
