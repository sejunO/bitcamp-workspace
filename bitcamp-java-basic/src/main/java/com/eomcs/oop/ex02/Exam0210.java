package com.eomcs.oop.ex02;

import com.eomcs.util.Cal;
import com.eomcs.util.Test;

public class Exam0210 {


  public static void main(String[] args) {
    Cal c = new Cal();
    Test t = new Test(4,5);
    c.plus(5900);
    c.나누기(2);
    c.plus(1400);
    c.plus(900);
    System.out.println(t.a);

    printValue(c.result);
  }
  static void printValue(int value) {
    System.out.println(value);
  }
}



