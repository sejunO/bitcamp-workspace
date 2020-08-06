package com.eomcs.oop.ex02;

public class Exam0114 {

  static class Score {

    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    static void computeScore(Score s) {
      s.sum = s.kor + s.eng + s.math;
      s.aver = (float)s.sum / 3;
    }

  }

  public static void main(String[] args) {
    Score s1 = new Score();

    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 97;
    s1.math = 80;
    Score.computeScore(s1);

    Score s2 = new Score();

    s2.name = "오세준";
    s2.kor = 90;
    s2.eng = 100;
    s2.math = 100;
    Score.computeScore(s2);

    printScore(s1);
    printScore(s2);

  }
  static void printScore(Score s) {
    System.out.printf("%s : %d, %d, %d, %d, %.1f \n",
        s.name,s.kor,s.eng,s.math,s.sum,s.aver);
  }

}