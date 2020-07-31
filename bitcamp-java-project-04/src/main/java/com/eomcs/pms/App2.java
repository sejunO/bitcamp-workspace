package com.eomcs.pms;


import java.sql.Date;
import java.util.Scanner;

public class App2 {
  final static int N = 100;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] no = new int[N];
    String[] title = new String[N];
    String[] content = new String[N];
    Date[] startDate = new Date[N];
    Date[] endDate = new Date[N];
    String[] owner = new String[N];
    String[] members = new String[N];

    System.out.print("[프로젝트]");
    int count = 0;
    for (int i = 0; i < N; i++) {
      System.out.print("번호: ");
      no[i] = sc.nextInt();
      sc.nextLine();

      System.out.print("프로젝트명: ");
      title[i] = sc.nextLine();

      System.out.print("내용: ");
      content[i] = sc.nextLine();

      System.out.print("시작일: ");
      startDate[i] = Date.valueOf(sc.nextLine());

      System.out.print("종료일: " );
      endDate[i] = Date.valueOf(sc.nextLine());

      System.out.print("만든이: ");
      owner[i] = sc.nextLine();

      System.out.print("팀원: ");
      members[i] = sc.nextLine();

      System.out.println();
      count++;
      System.out.print("계속? y/N");
      String response = sc.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }

    }
    sc.close();

    for (int i = 0; i < count; i++) {
      System.out.println("--------------------------------");
      System.out.println("번호: " + no[i]);
      System.out.println("프로젝트명: " + title[i]);
      System.out.println("내용: " + content[i]);
      System.out.println("시작일: " + startDate[i].toString());
      System.out.println("종료일: " + endDate[i].toString());
      System.out.println("만든이: " + owner[i]);
      System.out.println("팀원: " + members[i]);

    }

  }

}
