package com.eomcs.basic.ex07;

public class Exam0414 {

  public static void main(String[] args) throws Exception {
    int a = 1;
    int b = 100;
    Add ad= new Add();
    ad.add(a,b);
    System.out.printf("%d %d",  a, b);
  }

  static class Add {
    int a = 5;
    int b = 2;

    public void add(int a, int b) {
      System.out.println(a);
    }


  }
}