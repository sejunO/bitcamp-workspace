package com.eomcs.net.ex02;

import java.net.ServerSocket;
import java.util.Scanner;

public class Server0110 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("클라이언트 기다리는중 ");
    sc.nextLine();

    ss.close();
    System.out.println("서버 종료");
    sc.close();
  }
}
