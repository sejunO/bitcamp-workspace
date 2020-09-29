package com.eomcs.net.ex04.a;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest2 {
  public static void main(String[] args) throws IOException {

    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버 기다리는중");
    while (true) {
      Socket socket = ss.accept();
      pro(socket);
    }

  }

  static void pro(Socket socket) {

    try (Socket socket2 = socket;
        PrintStream out = new PrintStream(socket.getOutputStream());
        DataInputStream in =
            new DataInputStream(new BufferedInputStream(socket.getInputStream()))) {
      System.out.println("서버와 연결됨 ");

      loop: while (true) {

        String op = in.readUTF();
        int b = in.readInt();
        int result = 0;

        switch (op) {
          case "+":
            result += b;
            break;
          case "-":
            result -= b;
            break;
          case "*":
            result *= b;
            break;
          case "/":
            result /= b;
            break;
          case "exit":
            break loop;
        }

        out.printf("%d \n", result);
        System.out.println("값을 보냈음");

      }
      out.println("exit");
    } catch (Exception e) {

    }

  }
}
