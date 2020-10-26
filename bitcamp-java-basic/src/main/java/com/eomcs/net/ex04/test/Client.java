package com.eomcs.net.ex04.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) {
    long ID = 0;
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.printf("연산자?");
      String op = sc.next();

      System.out.printf("값?");
      int num = sc.nextInt();
      try (Socket socket = new Socket("localhost", 8888);
          DataInputStream in = new DataInputStream(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

        out.writeLong(ID);

        out.writeUTF(op);
        out.writeInt(num);

        ID = in.readLong();
        System.out.println(in.readInt());

      } catch (Exception e) {

      }
    }
  }
}
