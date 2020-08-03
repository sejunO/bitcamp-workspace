package com.eomcs.pms;

// 클래스의 패키지 정보를 미리 선언하여 컴파일러에게 알려준다.
import java.sql.Date;
import java.util.Scanner;

// 1) 낱개의 변수를 사용하여 여러 회원 정보 처리하기
// 2) 조건문을 사용하여 입출력 제어하기
// - 필요한 만큼만 입력 받고 출력하고 싶다.
public class App {

  static class Member{

  }

  final static int N = 5;
  final static int PN = 5;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long currentMillis = 0;
    int[] no = new int[N];
    String[] name = new String[N];
    String[] email = new String[N];
    String[] password= new String[N];
    String[] photo= new String[N];
    String[] tel= new String[N];
    Date[] now = new Date[N];
    int count = 0;

    int[] pno = new int[PN];
    String[] ptitle = new String[PN];
    String[] pcontent = new String[PN];
    Date[] pstartDate = new Date[PN];
    Date[] pendDate = new Date[PN];
    String[] powner = new String[PN];
    String[] pmembers = new String[PN];
    int pcount = 0;

    String[] tproject = new String[N];
    int[] tno = new int[N];
    String[] tob = new String[N];
    Date[] tendDate = new Date[N];
    int[] tstate = new int[N];
    String[] towner = new String[N];
    int tcount = 0;

    loop:
      while (true) {
        System.out.print("명령>");
        String command = sc.nextLine();

        switch (command.toLowerCase()) {
          case "/member/add":
            System.out.println("회원 등록");

            System.out.print("번호? ");
            no[count] = sc.nextInt();
            sc.nextLine();

            System.out.print("이름? ");
            name[count] = sc.nextLine();

            System.out.print("이메일? ");
            email[count] = sc.nextLine();

            System.out.print("암호? ");
            password[count] = sc.nextLine();

            System.out.print("사진? ");
            photo[count] = sc.nextLine();

            System.out.print("전화? ");
            tel[count] = sc.nextLine();

            currentMillis = System.currentTimeMillis(); // 1970-1-1 00:00:00 에서경과된 밀리초
            now[count] = new Date(currentMillis);
            System.out.println();
            count++;
            break;
          case "/member/list":
            System.out.println("회원 목록");
            for(int i = 0; i < count; i++) {
              System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
                  no[i],  name[i],  email[i],  password[i],  photo[i],  tel[i],  now[i].toString());
            }
            break;
          case "/project/add":
            System.out.println("[프로젝트 등록]");
            System.out.print("번호: ");
            pno[pcount] = sc.nextInt();
            sc.nextLine();

            System.out.print("프로젝트명: ");
            ptitle[pcount] = sc.nextLine();

            System.out.print("내용: ");
            pcontent[pcount] = sc.nextLine();

            System.out.print("시작일: ");
            pstartDate[pcount] = Date.valueOf(sc.nextLine());

            System.out.print("종료일: " );
            pendDate[pcount] = Date.valueOf(sc.nextLine());

            System.out.print("만든이: ");
            powner[pcount] = sc.nextLine();

            System.out.print("팀원: ");
            pmembers[pcount] = sc.nextLine();
            pcount++;
            break;
          case "/project/list":
            for (int i = 0; i < pcount; i++) {
              System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
                  pno[i],  ptitle[i],  pcontent[i],  pstartDate[i].toString(), pendDate[i].toString(),  powner[i],  pmembers[i]);
            }

            break;
          case "/task/add":
            System.out.printf("프로젝트: ");
            tproject[tcount] = sc.nextLine();

            System.out.printf("번호: ");
            tno[tcount] = sc.nextInt();
            sc.nextLine();
            System.out.printf("내용: ");
            tob[tcount] = sc.nextLine();

            System.out.printf("완료일: ");
            tendDate[tcount] = Date.valueOf(sc.nextLine());

            System.out.println("상태: ");
            System.out.printf("0: 신규 \n1: 진행중\n2: 완료\n > ");
            tstate[tcount] = sc.nextInt();
            sc.nextLine();

            System.out.printf("담당자: ");
            towner[tcount] = sc.nextLine();
            tcount++;
            break;
          case "/task/list":
            for(int i = 0; i < tcount; i++) {

              System.out.println("프로젝트 " + tproject[i]);
              System.out.println("번호: " + tno[i]);
              System.out.println("내용: " + tob[i]);
              System.out.println("완료일: " + tendDate[i]);
              switch(tstate[i]) {
                case 1:
                  System.out.println("상태: 신규");
                  break;
                case 2:
                  System.out.println("상태: 진행중");
                  break;
                default:
                  System.out.println("상태: 완료");
              }
              System.out.println("담당자: " + towner[i]);
              System.out.println();
            }
            break;
          case "quit":
          case "exit":
            System.out.println("B y e !");
            break loop;
          default: System.out.println("실행할 수 없는 명령");
        }
        System.out.println();
      }
    sc.close();



    /*
    System.out.println("[회원]");
    inputMember();
    System.out.println("------------------");
    printMembers();
  }

  static void inputMember() {
    Scanner keyInput = new Scanner(System.in);


    for(int i = 0; i < 5; i++) {

      count++;
      Member m = new Member();

      members[i] = m;

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String response = keyInput.nextLine();

      if (!response.equalsIgnoreCase("y"))
        break;
    }
    keyInput.close();
  }

  static void printMembers() {

     */
  }
}













