package com.eomcs.basic.ex07;

import java.util.ArrayList;

public class Exam0413 {
  public static void main(String[] args) throws Exception {
    int[] arr;
    ArrayList list = new ArrayList();

    while (true) {
      list.add(createArray());
      Thread.currentThread().sleep(2000);
    }


  }
  static int[] createArray() {
    System.out.println(" . ");
    return new int[1000000];
  }
}