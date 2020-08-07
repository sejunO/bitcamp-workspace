package com.eomcs.util;

public class Test {
  public int a;
  public int b;
  public String s;
  public int c;

  public Test() {
    this.a = 10;
    this.b = 5;
    this.s = "s";
  }

  public Test(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public void add(int a, int b) {
    this.c = a + b;
  }


}
