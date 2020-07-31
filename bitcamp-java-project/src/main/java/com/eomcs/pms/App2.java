package com.eomcs.pms;


import java.sql.Date;
import java.util.Scanner;

class Project {
  int no;
  String title;
  String content;
  Date startDate;
  Date endDate;
  String owner;
  String members;
}

public class App2 {
  final static int N = 100;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Project[] projects = new Project[N];

    System.out.print("[프로젝트]");
    int count = 0;
    for (int i = 0; i < N; i++) {
      count++;
      Project p = new Project();

      System.out.print("번호: ");
      p.no = sc.nextInt();
      sc.nextLine();

      System.out.print("프로젝트명: ");
      p.title = sc.nextLine();

      System.out.print("내용: ");
      p.content = sc.nextLine();

      System.out.print("시작일: ");
      p.startDate = Date.valueOf(sc.nextLine());

      System.out.print("종료일: " );
      p.endDate = Date.valueOf(sc.nextLine());

      System.out.print("만든이: ");
      p.owner = sc.nextLine();

      System.out.print("팀원: ");
      p.members = sc.nextLine();

      System.out.println();

      projects[i] = p;

      System.out.print("계속? y/N");
      String response = sc.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }

    }
    sc.close();

    for (int i = 0; i < count; i++) {
      Project p = new Project();
      p = projects[i];

      System.out.println("--------------------------------");
      System.out.println("번호: " + p.no);
      System.out.println("프로젝트명: " + p.title);
      System.out.println("내용: " + p.content);
      System.out.println("시작일: " + p.startDate.toString());
      System.out.println("종료일: " + p.endDate.toString());
      System.out.println("만든이: " + p.owner);
      System.out.println("팀원: " + p.members);

    }

  }

}