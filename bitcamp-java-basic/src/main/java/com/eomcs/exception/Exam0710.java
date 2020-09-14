package com.eomcs.exception;

public class Exam0710 {
  static void m1() {
    m2();
  }

  static void m2() {
    m3();
  }

  static void m3() {
    m4();
  }

  static void m4() throws Exception {
    System.out.println("따발총");
  }

  public static void main(String[] args) {
    m1();
  }
}
