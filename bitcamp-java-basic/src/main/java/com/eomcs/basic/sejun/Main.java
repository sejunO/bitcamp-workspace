package com.eomcs.basic.sejun;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int d = 0, h = 0, m = 0, s =0;
    s = a/86400;
    m = (a%86400/3600);
    h = (a%86400%3600/24);
    d = (a%86400%2600%24/24);
    System.out.printf("%d %d %d %d", s , m ,h, d);
    
  }
}

 