package com.eomcs.net.ex11.step09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

// 역할:
// - 소켓에 연결된 클라이언트 요청을 처리한다.
public class RequestProcessor extends Thread {
  Socket socket;

  public RequestProcessor(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try (Socket socket = this.socket;
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());) {
      // GET /plus?a=100&b=200

      String request = in.readLine().split(" ")[1];
      String[] values = request.split("\\?");
      String op = values[0];



      while (true) {
        if (in.readLine().length() == 0) {
          break;
        }

        sendResponse(out, compute(request)); // 클라리언트에게 응답한다.
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String compute(String request) {
    try {
      String[] values = request.split(" ");

      int a = Integer.parseInt(values[0]);
      String op = values[1];
      int b = Integer.parseInt(values[2]);
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
        default:
          return String.format("%s 연산자를 지원하지 않습니다.", op);
      }
      return String.format("결과는 %d %s %d = %d 입니다.", a, op, b, result);

    } catch (Exception e) {
      return String.format("계산 중 오류 발생! - %s", e.getMessage());
    }
  }

  private void sendResponse(PrintStream out, String message) {
    out.println("HTTP/1.1 200 OK");
    out.println("Content-Type: text/plain;charset=UTF-8");
    out.println();
    out.println(message);
    out.flush();
  }


}
