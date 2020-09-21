package com.eomcs.io.ex04;

import java.io.FileOutputStream;

public class Exam0210 {
  public static void main(String[] args) {
    try (FileOutputStream out = new FileOutputStream("temp/test.txt")) {

      int value = 1_3456_7890;

      out.write(value >> 24);
      out.write(value >> 16);
      out.write(value >> 8);
      out.write(value);

      System.out.println("성공");
    } catch (Exception e) {
      System.out.println("실패");
    }
  }
}
