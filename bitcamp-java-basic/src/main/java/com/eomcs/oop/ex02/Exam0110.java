package com.eomcs.oop.ex02;

public class Exam0110 {

  public static void main(String[] args) {

    String name = "홍길";
    int kor = 100;
    int eng = 90;
    int math = 80;
    int sum = kor + eng + math;
    float aver = (float)sum / 3;

    printScore(name, kor, eng, math, sum, aver);

  }

  static void printScore(String name, int kor, int eng, int math, int sum, float aver) {
    System.out.printf("%s : %d, %d, %d, %d, %f", name,kor,eng,math,sum,aver);
  }
}



