// 계산기 서버 만들기 - 4단계: 클라이언트가 보낸 요청을 받아 그대로 되돌려 준다.
package com.eomcs.net.ex11.step06;

import java.net.ServerSocket;

public class CalculatorServer {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      while (true) {
        RequestProcessor thread = new RequestProcessor(serverSocket.accept());
        thread.start();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
