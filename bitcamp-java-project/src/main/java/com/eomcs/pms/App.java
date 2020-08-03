package com.eomcs.pms;

// 클래스의 패키지 정보를 미리 선언하여 컴파일러에게 알려준다.
import java.sql.Date;
import java.util.Scanner;

// 1) 낱개의 변수를 사용하여 여러 회원 정보 처리하기
// 2) 조건문을 사용하여 입출력 제어하기
// - 필요한 만큼만 입력 받고 출력하고 싶다.
public class App {
  static Scanner sc = new Scanner(System.in);
  final static int N = 5;
  final static int PN = 5;
  //Member
  static int[] mno = new int[N];
  static String[] mname = new String[N];
  static String[] memail = new String[N];
  static String[] mpassword= new String[N];
  static String[] mphoto= new String[N];
  static String[] mtel= new String[N];
  static Date[] mnow = new Date[N];
  static int mcount = 0;
  //Project
  static int[] pno = new int[PN];
  static String[] ptitle = new String[PN];
  static String[] pcontent = new String[PN];
  static Date[] pstartDate = new Date[PN];
  static Date[] pendDate = new Date[PN];
  static String[] powner = new String[PN];
  static String[] pmembers = new String[PN];
  static int pcount = 0;
  //Task
  static String[] tproject = new String[N];
  static int[] tno = new int[N];
  static String[] tob = new String[N];
  static Date[] tendDate = new Date[N];
  static int[] tstate = new int[N];
  static String[] towner = new String[N];
  static int tcount = 0;
  public static void main(String[] args) {


    loop:
      while (true) {
        System.out.print("명령>");
        String command = sc.nextLine();

        switch (command.toLowerCase()) {
          case "/member/add":
            addMember();
            break;
          case "/member/list":
            listMember();
            break;
          case "/project/add":
            addProject();
            break;
          case "/project/list":
            listProject();
            break;
          case "/task/add":
            addTask();
            break;
          case "/task/list":
            listTask();
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
  }
  static void addMember() {
    System.out.println("회원 등록");

    mno[mcount] = promptInt("번호? ");
    mname[mcount] = promptString("이름? ");
    memail[mcount] = promptString("이메일? ");
    mpassword[mcount] = promptString("암호? ");
    mphoto[mcount] = promptString("사진? ");
    mtel[mcount] = promptString("전화? ");
    mnow[mcount] = new Date(System.currentTimeMillis());
    System.out.println();
    mcount++;
  }
  static void listMember() {
    System.out.println("회원 목록");
    for(int i = 0; i < mcount; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
          mno[i],  mname[i],  memail[i],  mpassword[i],  mphoto[i],  mtel[i],  mnow[i].toString());
    }
  }
  static void addProject() {
    System.out.println("[프로젝트 등록]");
    pno[pcount] = promptInt("번호: ");
    ptitle[pcount] = promptString("프로젝트명: ");
    pcontent[pcount] = promptString("내용: ");
    pstartDate[pcount] = promptDate("시작일: ");
    pendDate[pcount] = promptDate("종료일: ");
    powner[pcount] = promptString("만든이? ");
    pmembers[pcount] = promptString("팀원: ");
    pcount++;
  }

  static void listProject() {
    for (int i = 0; i < pcount; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
          pno[i],  ptitle[i],  pcontent[i],  pstartDate[i].toString(), pendDate[i].toString(),  powner[i],  pmembers[i]);
    }
  }

  static void addTask() {
    tproject[tcount] = promptString("프로젝트: ");
    tno[tcount] = promptInt("번호: ");
    tob[tcount] = promptString("내용: ");
    tendDate[tcount] = promptDate("완료일: ");
    tstate[tcount] = promptInt("상태: \n0: 신규 \n1: 진행중\n2: 완료\n > ");
    towner[tcount] = promptString("담당자: ");
    tcount++;
  }

  static void listTask() {
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
  }
  static String promptString(String title) {
    System.out.printf(title);
    return sc.nextLine();
  }
  static int promptInt(String title) {
    return Integer.parseInt(promptString(title));
  }
  static Date promptDate(String title) {
    return Date.valueOf(promptString(title));
  }
}













