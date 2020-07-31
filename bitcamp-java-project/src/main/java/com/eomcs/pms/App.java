package com.eomcs.pms;

// 클래스의 패키지 정보를 미리 선언하여 컴파일러에게 알려준다.
import java.sql.Date;
import java.util.Scanner;

// 1) 낱개의 변수를 사용하여 여러 회원 정보 처리하기
// 2) 조건문을 사용하여 입출력 제어하기
// - 필요한 만큼만 입력 받고 출력하고 싶다.
public class App {

  static class Member{
    int no;
    String name;
    String email;
    String password;
    String photo;
    String tel;
    Date now;
  }

  static int count = 0;
  final static int MAX_LENGTH = 5;
  static Member[] members = new Member[MAX_LENGTH];


  public static void main(String[] args) {

    System.out.println("[회원]");
    inputMember();
    System.out.println("------------------");
    printMembers();
  }

  static void inputMember() {
    Scanner keyInput = new Scanner(System.in);
    long currentMillis = 0;

    for(int i = 0; i < 5; i++) {

      count++;
      Member m = new Member();

      System.out.print("번호? ");
      m.no = keyInput.nextInt();
      keyInput.nextLine();

      System.out.print("이름? ");
      m.name = keyInput.nextLine();

      System.out.print("이메일? ");
      m.email = keyInput.nextLine();

      System.out.print("암호? ");
      m.password = keyInput.nextLine();

      System.out.print("사진? ");
      m.photo = keyInput.nextLine();

      System.out.print("전화? ");
      m.tel = keyInput.nextLine();

      currentMillis = System.currentTimeMillis(); // 1970-1-1 00:00:00 에서경과된 밀리초
      m.now = new Date(currentMillis);
      System.out.println();

      members[i] = m;

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String response = keyInput.nextLine();

      if (!response.equalsIgnoreCase("y"))
        break;
    }
    keyInput.close();
  }

  static void printMembers() {
    for(int i = 0; i < count; i++) {
      Member m = members[i];

      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
          m.no,  m.name,  m.email,  m.password,  m.photo,  m.tel,  m.now.toString() );
    }
  }
}













