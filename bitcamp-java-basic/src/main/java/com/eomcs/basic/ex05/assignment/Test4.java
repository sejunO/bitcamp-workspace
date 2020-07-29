package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

//# 과제1 : 4바이트 정수 값을 입력 받은 후에 첫 바이트 부터 끝 바이트까지 순서대로 출력하
//실행 예)
//입력? 
//2에서 5까지의 합은 14입니다.
//
public class Test4 {

  public static void main(String[] args) {
    int value = 23459876;
    System.out.println(value);
    
    while (value > 0) {
      System.out.println(value % 10);
      value = value / 10;
    }
//    int six = value & 0xf | 0x6;
//    System.out.println(six);
//    
//    int seven = value & 0xf | 0x7;
//    System.out.println(seven);
//    
//    int eight = (value << 1) & 0xf;
//    System.out.println(eight);
//    
//    int nine = (value >> 2) & 0xf;
//    System.out.println(nine);
//    
//    int five = (value >> 16) & 0xf;
//    System.out.println(five);
//    
//    int four = value & 0xf;
//    System.out.println(four);
//    
//    int three = (value >> 1) & 0xf ^ 0x1;
//    System.out.println(three);
//    
//    int two = (value >> 1) & 0xf;
//    System.out.println(two);
  }
}








