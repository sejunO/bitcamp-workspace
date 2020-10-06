// 계산기 클라이언트 만들기 - 3단계: 응답을 읽는 코드를 별도의 메서드로 분리한다.
// - 기능 별로 메서드로 분리하면 코드를 관리하기가 편하다.
package com.eomcs.net.ex11.step03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  public static void main(String[] args) {

    try (Scanner key = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      readResponse(in);

      while (true) {
        String input = key.nextLine();
        out.println(input);
        out.flush();
        readResponse(in);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  static void readResponse(BufferedReader in) throws Exception {
    while (true) {
      String input = in.readLine();
      if (input.length() == 0) {
        // 빈 줄을 읽었다면 읽기를 끝낸다.
        break;
      }
      System.out.println(input);
    }
  }
}


