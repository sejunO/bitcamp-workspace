package com.eomcs.net.ex04.a;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("입력 1");
      int a = Integer.parseInt(sc.nextLine());

      System.out.println("op");
      String op = sc.nextLine();

      System.out.println("입력 2");
      int b = Integer.parseInt(sc.nextLine());


      try (Socket socket = new Socket("localhost", 8888);
          Scanner in = new Scanner(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

        out.writeInt(a);
        out.writeUTF(op);
        out.writeInt(b);

        String str = in.nextLine();
        System.out.println(str);


        System.out.printf("계속 하시겠습니까 (Y/n)");
        if (sc.nextLine().equalsIgnoreCase("n"))
          break;

      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }
}
