// 인터페이스의 스태틱 메서드 호출
package com.eomcs.oop.ex09.g;

public class Exam0130 {
  public static void main(String[] args) {
    System.out.println(A.m1());

    Exam0110 a = new Exam0110();
    a.m2();
    A b = new Exam0120();
    b.m2();

  }
}
