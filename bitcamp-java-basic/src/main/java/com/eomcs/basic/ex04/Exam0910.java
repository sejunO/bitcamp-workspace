package com.eomcs.basic.ex04;

public class Exam0910 {
  public static void main(String[] args) {
    byte b = 100;
    short s = 100;
    int i = 100;
    long l = 100;
    float f = 100f;
    double d = 100.0;
    boolean bool = true;
    char c = 'A';
    
    float f2;
    
    f2 = b;
    System.out.println(f2);
    f2 = s;
    System.out.println(f2);
    f2 = i;
    System.out.println(f2);
    f2 = l;
    System.out.println(f2);
    f2 = c;
    System.out.println(f2);
    
    s = 32767;
    f2 = s;
    System.out.println(f2);
    
    i = 1712345678;
    System.out.println(i);
    f2 = i;
    System.out.println(f2); // 짤림
    
    l = 20012345678L;
    f2 = l;
    System.out.println(f2);
    
    f = 112.123f;
    b = (byte)f;
    System.out.println(b);
    s = (short)f;
    System.out.println(b);
    i = (int)f;
    System.out.println(i);
    l = (long)f;
    System.out.println(l);
  }
}