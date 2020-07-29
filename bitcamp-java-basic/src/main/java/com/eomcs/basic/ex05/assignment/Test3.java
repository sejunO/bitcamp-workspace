package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

//# 과제1 : 4바이트 정수 값을 입력 받은 후에 첫 바이트 부터 끝 바이트까지 순서대로 출력하
//실행 예)
//입력? 
//2에서 5까지의 합은 14입니다.
//
public class Test3 {

  public static void main(String[] args) {
    int value = 0xaabbccdd;
    
    int dd = value & 0xff;
    System.out.println(Integer.toHexString(dd));
    int cc = (value >> 8) & 0xff;
    System.out.println(Integer.toHexString(cc));
    int bb = (value >> 16) & 0xff;
    System.out.println(Integer.toHexString(bb));
    int aa = (value >> 24) & 0xff;
    System.out.println(Integer.toHexString(aa));
  }

}








