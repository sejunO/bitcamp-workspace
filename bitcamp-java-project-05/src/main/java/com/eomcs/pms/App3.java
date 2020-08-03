package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  final static int N = 10;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] project = new String[N];
    int[] no = new int[N];
    String[] ob = new String[N];
    Date[] endDate = new Date[N];
    int[] state = new int[N];
    String[] owner = new String[N];
    int count = 0;

    System.out.println("작업");
    for (int i = 0; i < N; i++) {
      System.out.printf("프로젝트: ");
      project[i] = sc.nextLine();

      System.out.printf("번호: ");
      no[i] = sc.nextInt();
      sc.nextLine();
      System.out.printf("내용: ");
      ob[i] = sc.nextLine();

      System.out.printf("완료일: ");
      endDate[i] = Date.valueOf(sc.nextLine());

      System.out.println("상태: ");
      System.out.printf("0: 신규 \n1: 진행중\n2: 완료\n > ");
      state[i] = sc.nextInt();
      sc.nextLine();

      System.out.printf("담당자: ");
      owner[i] = sc.nextLine();

      count++;

      System.out.print("계속? y/N");
      String response = sc.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }

    }

    System.out.println("-----------------------------");
    for(int i = 0; i < count; i++) {

      System.out.println("프로젝트 " + project[i]);
      System.out.println("번호: " + no[i]);
      System.out.println("내용: " + ob[i]);
      System.out.println("완료일: " + endDate[i]);
      switch(state[i]) {
        case 1:
          System.out.println("상태: 신규");
          break;
        case 2:
          System.out.println("상태: 진행중");
          break;
        default:
          System.out.println("상태: 완료");
      }
      System.out.println("담당자: " + owner[i]);
    }

  }
}
