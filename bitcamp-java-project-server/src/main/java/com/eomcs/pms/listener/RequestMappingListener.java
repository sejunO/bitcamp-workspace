package com.eomcs.pms.listener;

import java.util.Map;
import com.eomcs.context.ApplicationContextListener;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.handler.BoardAddCommand;
import com.eomcs.pms.handler.BoardDeleteCommand;
import com.eomcs.pms.handler.BoardDetailCommand;
import com.eomcs.pms.handler.BoardListCommand;
import com.eomcs.pms.handler.BoardSearchCommand;
import com.eomcs.pms.handler.BoardUpdateCommand;
import com.eomcs.pms.handler.ProjectAddCommand;
import com.eomcs.pms.service.BoardService;
import com.eomcs.pms.service.MemberService;
import com.eomcs.pms.service.ProjectService;
import com.eomcs.pms.service.TaskService;

// 클라이언트 요청을 처리할 커맨드 객체를 준비한다.
public class RequestMappingListener implements ApplicationContextListener {

  @SuppressWarnings("unchecked")
  @Override
  public void contextInitialized(Map<String,Object> context) {
    // 옵저버가 작업한 결과를 맵에서 꺼낸다.
    try {
      BoardService boardService = (BoardService) context.get("boardService");
      MemberService memberService = (MemberService) context.get("memberService");
      ProjectService projectService = (ProjectService) context.get("projectService");
      TaskService taskService = (TaskService) context.get("taskService");

      Member loginUser = memberService.get("x3@test.com", "1111");
      context.put("loginUser", loginUser);

      context.put("/board/add", new BoardAddCommand(boardService));
      context.put("/board/list", new BoardListCommand(boardService));
      context.put("/board/detail", new BoardDetailCommand(boardService));
      context.put("/board/update", new BoardUpdateCommand(boardService));
      context.put("/board/delete", new BoardDeleteCommand(boardService));
      context.put("/board/search", new BoardSearchCommand(boardService));
      //
      //      MemberListCommand memberListCommand = new MemberListCommand(memberList);
      //      context.put("/member/add", new MemberAddCommand(memberList));
      //      context.put("/member/list", memberListCommand);
      //      context.put("/member/detail", new MemberDetailCommand(memberList));
      //      context.put("/member/update", new MemberUpdateCommand(memberList));
      //      context.put("/member/delete", new MemberDeleteCommand(memberList));
      //
      context.put("/project/add", new ProjectAddCommand(projectService, memberService));
      //      context.put("/project/list", new ProjectListCommand(projectList));
      //      context.put("/project/detail", new ProjectDetailCommand(projectList));
      //      context.put("/project/update", new ProjectUpdateCommand(projectList, memberListCommand));
      //      context.put("/project/delete", new ProjectDeleteCommand(projectList));
      //
      //      context.put("/task/add", new TaskAddCommand(taskList, memberListCommand));
      //      context.put("/task/list", new TaskListCommand(taskList));
      //      context.put("/task/detail", new TaskDetailCommand(taskList));
      //      context.put("/task/update", new TaskUpdateCommand(taskList, memberListCommand));
      //      context.put("/task/delete", new TaskDeleteCommand(taskList));
      //
      //      context.put("/hello", new HelloCommand());

      //      context.put("/calc", new CalculatorCommand());

    } catch (Exception e) {

      System.out.println("객체 준비중 오류");
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
  }
}
