
package com.eomcs.oop.ex03;

public class Exam0110 {
  public static void main(String[] args) {

    class A {
      int v1;
      boolean b2;
    }

    A obj1 = new A();
    A obj2 = new A();
    A obj3 = new A();

    obj1.v1 = 100;
    obj2.v1 = 200;
    obj3.v1 = 300;
    obj2.b2 = true;
  }

}
