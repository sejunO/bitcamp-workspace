package com.eomcs.net.ex04.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
  public static void main(String[] args) {
    Map<Long, Integer> map = new HashMap<>();
    try (ServerSocket ss = new ServerSocket(8888)) {
      while (true) {
        try (Socket socket = ss.accept();
            DataInputStream in= new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
          int result = 0;
          long ID = in.readLong();
          Integer obj = map.get(ID);
          String op = in.readUTF();
          int value = in.readInt();
          System.out.println(value);
          if (obj == null) {
            System.out.println("신규");
            ID = System.currentTimeMillis();
          } else {
            System.out.println("기존");
            result = map.get(ID);
          }
          switch (op) {
            case "+":
              result += value;
              break;
            case "-":
              result -= value;
              break;
            case "*":
              result *= value;
              break;
            case "/":
              result /= value;
              break;
          }
          map.put(ID, value);


          out.writeLong(ID);

          out.writeInt(result);



        }
      }
    } catch (Exception e) {

    }

  }
}
