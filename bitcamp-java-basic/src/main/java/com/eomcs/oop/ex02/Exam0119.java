package com.eomcs.oop.ex02;

import com.eomcs.oop.ex02.util.Score4;

public class Exam0119 {

  public static void main(String[] args) {
    Score4 s1 = new Score4("홍길동", 100, 90, 87);
    Score4 s2 = new Score4("오세", 90, 100, 100);
    Score4 s3 = new Score4("세준", 100);
    Score4 s4 = new Score4();
    printScore(s1);
    printScore(s2);
    printScore(s3);
    printScore(s4);
  }
  static void printScore(Score4 s) {
    System.out.printf("%s : %d, %d, %d, %d, %.1f \n",
        s.name,s.kor,s.eng,s.math,s.sum,s.aver);
  }

}

