package com.eomcs.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class STest {
  public static void main(String[] args) {
    try (ServerSocket ss = new ServerSocket(8888); Scanner sc = new Scanner(System.in);) {

      try (Socket socket = ss.accept();
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(socket.getOutputStream())) {
        System.out.println("클라이언트와 연결 성공");

        System.out.printf("아이디 : ");
        out.println(sc.nextLine());
        out.flush();
        String yourName = in.readLine();

        while (true) {
          String str = in.readLine();
          if (str.equalsIgnoreCase("exit")) {
            break;
          }
          System.out.println(yourName + " : " + str);
          System.out.printf("나 : ");
          out.println(sc.nextLine());
          out.flush();

        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
