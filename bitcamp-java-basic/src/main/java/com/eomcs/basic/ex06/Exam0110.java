package com.eomcs.basic.ex06;

//# 흐름 제어문 - 조건문 if
//
public class Exam0110 {
  public static void main(String[] args) {
    int age2 = 17;

    if(age2 >= 19) {
      if(age2 >= 65)
        System.out.println("gogo");
    } else
      System.out.println("미성년");


    age2 = 67;

    if(age2 < 8) {
      System.out.println("아동");
    } else if (age2 < 14) {
      System.out.println("어린이");
    } else if (age2 < 19 ) {
      System.out.println("청소년");
    } else if (age2 < 65) {
      System.out.println("성인");
    } else
      System.out.println("노인");


  }
}
/*
# if 조건문
문법1:
  if (조건) 문장1;
  => 조건이 참일 때 문장1을 수행한다.

문법2:
  if (조건) 문장1; else 문장2;
  => 조건이 참일 때 문장1을 수행하고, 거짓이면 문장2를 수행한다.
 */