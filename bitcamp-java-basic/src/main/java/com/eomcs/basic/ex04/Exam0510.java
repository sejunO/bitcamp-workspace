package com.eomcs.basic.ex04;

public class Exam0510 {
  public static void main(String[] args) {
    int[] p = new int[3];
    
    int[] p2; 
    int p3[];
    
    
    p[0] = 100;
    p[1] = 200;
    p[2] = 300;
    
    System.out.printf("%d %d %d \n", p[0], p[1], p[2]);
    
    int sum = 0;
    for(int i = 0; i < p.length; i++) {
      sum = sum + p[i];
    }
    
    
    
    System.out.println(sum);
    
    System.out.println(p.length);
    
    p2 = p;
    
    p2[1] = 1000;
    System.out.println(p[1]);
    
    p = new int[4];
    p[1] = 2000;
    System.out.printf("%d %d \n", p[1], p2[1]);
    
    int[] k2 = new int[3];
    System.out.println(k2[0]);
    System.out.println(k2[1]);
    System.out.println(k2[2]);
    
    
    int[] x1 = new int[3];
    int[] x2 = new int[4];
    int[] x3 = x1;
    x2 = x1;
    
  }

}