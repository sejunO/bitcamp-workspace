package com.eomcs.oop.ex02;

import com.eomcs.util.Cal;

public class Exam0210 {

  public static void main(String[] args) {
    Cal c = new Cal();


    c.plus(5900);
    c.나누기(2);
    c.plus(1400);
    c.plus(900);


    printValue(c.result);
  }
  static void printValue(int value) {
    System.out.println(value);
  }
}



