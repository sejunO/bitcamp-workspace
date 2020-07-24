package com.eomcs.pms;

// 클래스의 패키지 정보를 미리 선언하여 컴파일러에게 알려준다.
import java.sql.Date;
import java.util.Scanner;

// 1) 낱개의 변수를 사용하여 여러 회원 정보 처리하기
// 2) 조건문을 사용하여 입출력 제어하기
// - 필요한 만큼만 입력 받고 출력하고 싶다.
public class App_e {

  public static void main(String[] args) {

    Scanner keyInput = new Scanner(System.in);

    System.out.println("[회원]");

    int maxLength = 5;
    int[] no = new int[maxLength];
    String[] name = new String[maxLength];
    String[] email = new String[maxLength];
    String[] password = new String[maxLength];
    String[] photo = new String[maxLength];
    String[] tel = new String[maxLength];
    Date[] now = new Date[maxLength];
    long currentMillis = 0;
    int count = 0;
    
    for(int i = 0; i < maxLength; i++) {
      count++;
      System.out.print("번호? ");
      no[i] = keyInput.nextInt();
      keyInput.nextLine();

      System.out.print("이름? ");
      name[i] = keyInput.nextLine();

      System.out.print("이메일? ");
      email[i] = keyInput.nextLine();

      System.out.print("암호? ");
      password[i] = keyInput.nextLine();

      System.out.print("사진? ");
      photo[i] = keyInput.nextLine();

      System.out.print("전화? ");
      tel[i] = keyInput.nextLine();

      currentMillis = System.currentTimeMillis(); // 1970-1-1 00:00:00 에서경과된 밀리초
      now[i] = new Date(currentMillis);
      System.out.println();

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String response = keyInput.nextLine();
      
      if (!response.equalsIgnoreCase("y"))
        break;
      
    }
    keyInput.close();
    
    System.out.println("-----------------------");
    
    for(int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
          no[i], name[i], email[i], password[i], photo[i], tel[i], now[i].toString() );
    }
  }
}

  

    









