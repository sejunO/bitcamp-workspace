// 다중 상속한 인터페이스 구현하기
package com.eomcs.oop.ex09.d;


public class Exam01 implements C {
  @Override
  public void m1() {} // A와 B의 규칙
  @Override
  public void m2() {} // B의 규칙
  @Override
  public void m3() {} // C의 규칙

  public static void main(String[] args) {
    A a = new Exam01();
    a.m1();
    B b = new Exam01();
    b.m2();

  }
}
