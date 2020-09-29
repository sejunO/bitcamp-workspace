package com.eomcs.net.ex04.a;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerTest {
  static Map<Long, Integer> resultMap = new HashMap<>();

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

      while (true) {

        int a = in.readInt();
        String op = in.readUTF();
        int b = in.readInt();
        int result = 0;

        switch (op) {
          case "+":
            result = a + b;
            break;
          case "-":
            result = a - b;
            break;
          case "*":
            result = a * b;
            break;
          case "/":
            result = a / b;
            break;
        }

        out.printf("%d %s %d = %d\n", a, op, b, result);
        System.out.printf("%d %s %d = %d\n", a, op, b, result);
        System.out.println("값을 보냈음");

      }
    } catch (Exception e) {

    }

  }
}
