package com.eomcs.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CTest {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 8888);
        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream())) {
      System.out.println("서버와 연결 성공");
      System.out.printf("아이디 : ");
      out.println(sc.nextLine());
      out.flush();
      String yourName = in.readLine();
      while (true) {
        System.out.printf("나 : ");
        out.println(sc.nextLine());
        out.flush();
        String str = in.readLine();
        if (str.equals("exit")) {
          break;
        }
        System.out.println(yourName + " : " + str);

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
