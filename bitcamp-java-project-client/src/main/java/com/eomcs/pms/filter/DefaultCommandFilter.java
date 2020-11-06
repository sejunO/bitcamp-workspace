package com.eomcs.pms.filter;

import java.util.Map;
import com.eomcs.pms.handler.Command;
import com.eomcs.pms.handler.Request;

public class DefaultCommandFilter implements CommandFilter{

  @SuppressWarnings("unchecked")
  @Override
  public void doFilter(Request request, FilterChain next) throws Exception {

    Map<String,Object> context = request.getContext();

    Map<String,Command> commandMap = (Map<String,Command>)context.get("commandMap");
    Command command = commandMap.get(request.getCommandPath());
    if (command != null) {
      try {
        command.execute(context);
      } catch (Exception e) {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("명령어 실행 중 오류 발생: %s\n", e);
        System.out.println("--------------------------------------------------------------");
      }
    } else {
      System.out.println("실행할 수 없는 명령입니다.");
    }

  }
}
