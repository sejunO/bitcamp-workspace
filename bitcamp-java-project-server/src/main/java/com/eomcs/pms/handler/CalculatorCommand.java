package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.util.Prompt;

// Command 규칙에 따라 클래스를 정의한다.
public class CalculatorCommand implements Command {


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[계산]");

      String input = Prompt.inputString("계산식? (예: 5 * 3)", out, in);
      String[] arr = input.split(" ");
      if (arr.length != 3) {
        out.println("그건 안됨");
        out.println("15 * 45 이런식으로");
        out.flush();
      }

      int a = Integer.parseInt(arr[0]);
      int b = Integer.parseInt(arr[2]);
      String op = arr[1];
      int result = 0;
      switch (op) {
        case "+": result = a+b; break;
        case "-": result = a-b; break;
        case "*": result = a*b; break;
        case "/": result = a/b; break;
        default:
          out.println("그건 안됨");
          out.flush();
          return;
      }

      out.printf("계산 결과: %d %s %d = %d\n", a, op, b, result);

    } catch (Exception e) {
      out.printf("오류 발생! - %s\n", e.getMessage());
    }
  }
}
