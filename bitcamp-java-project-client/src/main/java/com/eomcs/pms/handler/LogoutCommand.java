package com.eomcs.pms.handler;

import java.util.Map;
import com.eomcs.util.Prompt;

// Command 규칙에 따라 클래스를 정의한다.
public class LogoutCommand implements Command {

  @Override
  public void execute(Map<String, Object> context) {
    System.out.println("[로그아웃]");

    String response = Prompt.inputString("로그아웃 하시겠습니까? ");
    if (response.equalsIgnoreCase("y")) {
      context.remove("loginUser");
      System.out.println("안녕히가세요.");
    } else {
      System.out.println("로그아웃을 취소합니다.");
    }

  }
}
