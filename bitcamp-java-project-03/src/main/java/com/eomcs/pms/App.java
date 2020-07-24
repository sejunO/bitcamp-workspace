package com.eomcs.pms;

public class App {

  public static void main(String[] args) {
    
    java.util.Scanner keyInput = new java.util.Scanner(System.in);
    System.out.println("[회원]");
    System.out.print("번호: ");
    int no = keyInput.nextInt();
    keyInput.nextLine();
    System.out.print("이름: ");
    String name = keyInput.nextLine();
    System.out.print("이메일: ");
    String email = keyInput.nextLine();
    System.out.print("암호:");
    String pass = keyInput.nextLine();
    System.out.print("사진: ");
    String ph = keyInput.nextLine();
    System.out.print("전화: ");
    String num = keyInput.nextLine();
    
    long currentMillis = System.currentTimeMillis();
    java.sql.Date now = new java.sql.Date(currentMillis);
    
    
    
    keyInput.close();
    
    System.out.println("-----------------------------");
    System.out.println("번호: " + no);
    System.out.println("이름: " + name);
    System.out.println("이메일: " + email);
    System.out.println("사진: " + ph);
    System.out.println("전화: " + num);
    System.out.println(now.toString());
  }
}
