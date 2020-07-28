package com.eomcs.basic.ex05;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    String[] test = new String[N+1];
    
    for(int i = 0; i < N; i++) {
      int sum = 0, count = 0;
      test[i] = sc.next();
      for(int j = 0; j < test[i].length(); j++) {
        if (test[i].charAt(j) == 'O')
          sum += ++count;
        else count = 0;
      }
      System.out.println(sum);
    }
    sc.close();
  }

}
