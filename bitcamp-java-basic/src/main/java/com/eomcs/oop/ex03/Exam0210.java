package com.eomcs.oop.ex03;

public class Exam0210 {
  static class A {
    int value;

    static void m1() {

    }

    void m2() {
      this.value = 100;
    }

    void m3() {
      value =200;
    }

    void m4(int value) {
      value = 200;

      this.value = value;
    }
  }

  public static void main(String[] args) {
    A.m1();

    A obj1 = new A();

    obj1.m2();
    obj1.m4(34);

    A obj2 = new A();
    obj2.m2();
    System.out.println(obj1.value);
  }
}