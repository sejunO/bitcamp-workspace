package com.eomcs.oop.ex03;


public class Exam0610 {
  static class A{

    static int x = 10;
    int y = 100;

    static {
      System.out.println("static #1");
    }
    static void m1() {

    }
    {
      System.out.println("인스 #1");
    }
    public A() {
      System.out.println("Exam0610()!");

      {
        System.out.println("인스 #2");
      }
    }
    public A(int value) {
      System.out.println("int");
    }
  }
  static class B{
    static int x = 100;
    int y;
  }
  public static void main(String[] args) {
    A.m1();
    A obj1 = new A();
    System.out.println(A.x);
    System.out.println(obj1.y);

    new A(100);
  }
}
