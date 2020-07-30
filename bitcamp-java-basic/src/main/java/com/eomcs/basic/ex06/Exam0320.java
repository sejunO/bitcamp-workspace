package com.eomcs.basic.ex06;

//# 흐름 제어문 - break와 continue 활용
//
public class Exam0320 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;
    while (count++ < 100) {
      sum += count;
    }
    System.out.printf("%d", sum);
  }
}
