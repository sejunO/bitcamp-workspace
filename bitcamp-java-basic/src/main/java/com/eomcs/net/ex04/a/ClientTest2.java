package com.eomcs.net.ex04.a;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    try (Socket socket = new Socket("localhost", 8888);
        Scanner in = new Scanner(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
      while (true) {
        System.out.println("op");
        String op = sc.nextLine();

        System.out.println("입력 2");
        int b = Integer.parseInt(sc.nextLine());

        out.writeUTF(op);
        out.writeInt(b);

        String str = in.nextLine();
        System.out.println(str);

      }



    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
