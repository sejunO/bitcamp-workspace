package com.eomcs.basic.ex07;

public class Exam0210 {
  public static void main(String[] args) {
    m1();
    m2("Steven Gerrard");
    String message = m3();
    message = m4("홍길동");
    System.out.println(message);

    message = m5("홍길동", 20, false);
    System.out.println(message);

    m6("홍길동", 100, 90, 80);

    int[] values = {100, 90, 80, 70, 60};
    m7("홍길동", values);

    m8("홍길동",100, 90, 80, 70, 60);
    m8("홍길동",100, 90, 80, 70);
    m8("홍길동",100, 90, 80);
    m10(new int[] {100, 90, 80}, new String[] {"국어", "영어", "수학"}, "오세준");

    int sum = 0;


    sum = plus(plus(plus(2,3),7),4);
    System.out.println(sum);
  }
  static void m1() {
    System.out.println("Hello");
  }

  static void m2(String name) {
    System.out.println(name +" 님 반갑습니다!");
  }
  static String m3() {
    return "안녕";
  }
  static String m4(String name) {
    return name + "님 반갑습니다";
  }
  static String m5(String name, int age, boolean working) {
    return age + "살" + name + "님은 현재 재직상태가 " + working + " 입니다";
  }

  static void m6(String name, int a, int b, int c) {
    int sum = a + b + c;
    int aver = sum / 3;
    System.out.printf("%s: %d(%d)\n", name, sum, aver);
  }
  static void m7(String name, int[] scores) {
    int sum = 0;
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i];
    }
    double aver = 0;
    if (scores.length > 0) {
      aver = (double)sum / scores.length;
    }
    System.out.printf("%s: %d(%f)\n", name, sum, aver);
  }
  static void m8(String name, int... scores) {
    int sum = 0;
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i];
    }
    double aver = 0;
    if (scores.length > 0) {
      aver = (double)sum / scores.length;
    }
    System.out.printf("%s: %d(%f)\n", name, sum, aver);
  }
  static void m10 (int[] scores, String[] titles, String name) {
    if (scores.length != titles.length) {
      System.out.println("과목 수와 점수의 개수가 다릅니다.");
      return;
    }
    System.out.println(name + "님 점수!");
    for (int i = 0; i < scores.length; i++) {
      System.out.printf("%s = %d 점\n", titles[i], scores[i]);
    }
  }
  static int plus(int a, int b) {
    return a + b;
  }
}
