package com.eomcs.basic.ex07;

public class Exam0414 {

  public static void main(String[] args) throws Exception {
    int a = 1;
    int b = 100;
    Add ad= new Add();
    ad.add(a,b);
    System.out.println(ad.result);
  }

  static class Add {
    int result = 0;

    void add(int a, int b) {
      this.result = a + b;
    }
  }
}
