package com.eomcs.oop.ex06.b;

public class C {
  int a;
  int b;

  public void print() {
    System.out.println(a);
  }

  public void print(C z) {
    System.out.println(this.a);
    System.out.println(z.a);
  }



}
