package com.eomcs.basic.ex07;

public class Exam0420 {


  static class My {
    int a;
    int b;
  }

  static My getMy() {
    My ref = new My();
    ref.a = 100;
    ref.b = 200;
    return ref;
  }
  public static void main(String[] args) throws Exception {
    My ref = getMy();
    System.out.println(ref.a);
  }

}

