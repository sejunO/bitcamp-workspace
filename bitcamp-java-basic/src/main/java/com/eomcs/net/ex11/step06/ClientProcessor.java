package com.eomcs.net.ex11.step06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientProcessor {
  Scanner keyboardScanner = new Scanner(System.in);

  public void service() {
    while (true) {

      String input = prompt(keyboardScanner);
      if (input == null) {
        continue;
      } else if (input.equalsIgnoreCase("quit")) {
        break;
      }

      try (Socket socket = new Socket("localhost", 8888);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {


        sendRequest(out, input);
        receiveResponse(in); // 서버의 실행 결과를 출력


      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private String prompt(Scanner keyboardScanner) {
    System.out.printf("계산식 > ");
    String input = keyboardScanner.nextLine();

    if (!input.equalsIgnoreCase("quit") && input.split(" ").length != 3) {
      System.out.println("입력 형식이 올바르지 않습니다. 예) 23 + 5");
      return null;
    }
    return input;
  }

  private void sendRequest(PrintStream out, String message) throws Exception {
    out.println(message);
    out.flush();
  }

  private void receiveResponse(BufferedReader in) throws Exception {
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
