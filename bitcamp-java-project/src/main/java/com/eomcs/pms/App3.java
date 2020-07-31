package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  static class Task {
    String project;
    int no;
    String ob;
    Date endDate;
    int state;
    String owner;
  }

  final static int N = 10;
  static Task[] tasks = new Task[N];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = 0;

    System.out.println("작업");
    for (int i = 0; i < N; i++) {
      count++;
      Task t = new Task();

      System.out.printf("프로젝트: ");
      t.project = sc.nextLine();

      System.out.printf("번호: ");
      t.no = sc.nextInt();
      sc.nextLine();

      System.out.printf("내용: ");
      t.ob = sc.nextLine();

      System.out.printf("완료일: ");
      t.endDate = Date.valueOf(sc.nextLine());

      System.out.println("상태: ");
      System.out.printf("0: 신규 \n1: 진행중\n2: 완료\n > ");
      t.state = sc.nextInt();
      sc.nextLine();

      System.out.printf("담당자: ");
      t.owner = sc.nextLine();

      tasks[i] = t;

      System.out.print("계속? y/N");
      String response = sc.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }

    }

    System.out.println("-----------------------------");
    for(int i = 0; i < count; i++) {
      Task t = new Task();
      t = tasks[i];
      System.out.println("프로젝트 " + t.project);
      System.out.println("번호: " + t.no);
      System.out.println("내용: " + t.ob);
      System.out.println("완료일: " + t.endDate);
      switch(t.state) {
        case 1:
          System.out.println("상태: 신규");
          break;
        case 2:
          System.out.println("상태: 진행중");
          break;
        default:
          System.out.println("상태: 완료");
      }
      System.out.println("담당자: " + t.owner);
    }

  }
}
