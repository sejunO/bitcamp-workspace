package com.eomcs.basic.ex07;

public class Exam0450 {

  public static void main(String[] args) {
    // 합계를 출력하는 프로그램을 작성하라.
    // $ java -cp ./bin/main com.eomcs.basic.ex07.Exam0530 200 43 56
    //
    int sum = 0;
    for (String arg : args)
      sum += Integer.parseInt(arg);
    System.out.printf("합계: %d\n", sum);
  }
}
