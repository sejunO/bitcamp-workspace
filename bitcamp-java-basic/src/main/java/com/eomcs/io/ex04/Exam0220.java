package com.eomcs.io.ex04;

import java.io.FileInputStream;

public class Exam0220 {

  public static void main(String[] args) {
    try (FileInputStream in = new FileInputStream("temp/test.txt")) {

      int value = in.read() << 24;
      value += in.read() << 16;
      value += in.read() << 8;
      value += in.read();

      System.out.println(value);

    } catch (Exception e) {

    }
  }

}
