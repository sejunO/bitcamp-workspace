package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("[");
    System.out.print("프로젝트");
    System.out.println("]");

    System.out.print("번호: ");
    int no = sc.nextInt();

    System.out.print("프로젝트명: ");
    String project = sc.nextLine();

    System.out.print("내용: ");
    String ob = sc.nextLine();

    System.out.print("시작일: ");
    Date startDate = Date.valueOf(sc.nextLine());

    System.out.print("종료일: " );
    Date endDate = Date.valueOf(sc.nextLine());

    System.out.print("만든이: ");
    String name = sc.nextLine();
    
    System.out.print("팀원: ");
    
    String team = sc.nextLine();
    
    System.out.println("--------------------------------");
    System.out.println("번호: " + no);
    System.out.println("프로젝트명: " + project);
    System.out.println("내용: " + ob);
    System.out.println("시작일: " + startDate.toString());
    System.out.println("종료일: " + endDate.toString());
    System.out.println("만든이: " + name);
    System.out.println("팀원: " + team);
    
  }
  
}
