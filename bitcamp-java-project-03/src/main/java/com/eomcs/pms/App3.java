package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("작업");
    System.out.printf("프로젝트: ");
    String project = sc.nextLine();
    
    System.out.printf("번호: ");
    String no = sc.nextLine();
    int no1 = Integer.parseInt(no);
    
    System.out.printf("내용: ");
    String ob = sc.nextLine();
    
    System.out.printf("완료일: ");
    Date endDate = Date.valueOf(sc.nextLine());
    
    System.out.println("상태: ");
    System.out.printf("0: 신규 \n1: 진행중\n2: 완료\n > ");
    int state = sc.nextInt();
    sc.nextLine();
    
    System.out.printf("담당자: ");
    String name = sc.nextLine();
    
    System.out.println("-----------------------------");
    
    System.out.println("프로젝트 " + project);
    System.out.println("번호: " + no);
    System.out.println("내용: " + ob);
    System.out.println("완료일: " + endDate);
//    if (state == 0 )
//      System.out.println("상태: 신규");
//    else if (state == 1)
//      System.out.println("상태: 진행중");
//    else
//      System.out.println("상태: 완료");
    
    switch(state) {
      case 1: 
        System.out.println("상태: 신규");
        break;
      case 2:
        System.out.println("상태: 진행중");
        break;
      default:
        System.out.println("상태: 완료");
    }
    System.out.println("담당자: " + name);
  }
}
