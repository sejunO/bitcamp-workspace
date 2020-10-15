package com.eomcs.pms.listener;

import java.util.List;
import java.util.Map;
import com.eomcs.context.ApplicationContextListener;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.domain.Task;
import com.eomcs.pms.handler.BoardAddCommand;
import com.eomcs.pms.handler.BoardDeleteCommand;
import com.eomcs.pms.handler.BoardDetailCommand;
import com.eomcs.pms.handler.BoardListCommand;
import com.eomcs.pms.handler.BoardUpdateCommand;
import com.eomcs.pms.handler.CalculatorCommand;
import com.eomcs.pms.handler.HelloCommand;
import com.eomcs.pms.handler.MemberAddCommand;
import com.eomcs.pms.handler.MemberDeleteCommand;
import com.eomcs.pms.handler.MemberDetailCommand;
import com.eomcs.pms.handler.MemberListCommand;
import com.eomcs.pms.handler.MemberUpdateCommand;
import com.eomcs.pms.handler.ProjectAddCommand;
import com.eomcs.pms.handler.ProjectDeleteCommand;
import com.eomcs.pms.handler.ProjectDetailCommand;
import com.eomcs.pms.handler.ProjectListCommand;
import com.eomcs.pms.handler.ProjectUpdateCommand;
import com.eomcs.pms.handler.TaskAddCommand;
import com.eomcs.pms.handler.TaskDeleteCommand;
import com.eomcs.pms.handler.TaskDetailCommand;
import com.eomcs.pms.handler.TaskListCommand;
import com.eomcs.pms.handler.TaskUpdateCommand;

public class RequestMappingListener implements ApplicationContextListener {


  @SuppressWarnings("unchecked")
  @Override
  public void contextInitialized(Map<String, Object> context) {
    context.put("/board/add", new BoardAddCommand((List<Board>) context.get("boardList")));
    context.put("/board/list", new BoardListCommand((List<Board>) context.get("boardList")));
    context.put("/board/detail", new BoardDetailCommand((List<Board>) context.get("boardList")));
    context.put("/board/update", new BoardUpdateCommand((List<Board>) context.get("boardList")));
    context.put("/board/delete", new BoardDeleteCommand((List<Board>) context.get("boardList")));

    MemberListCommand memberListCommand = new MemberListCommand(
        (List<Member>) context.get("memberList"));
    context.put("/member/add", new MemberAddCommand(
        (List<Member>) context.get("memberList")));
    context.put("/member/list", memberListCommand);
    context.put("/member/detail", new MemberDetailCommand(
        (List<Member>) context.get("memberList")));
    context.put("/member/update", new MemberUpdateCommand(
        (List<Member>) context.get("memberList")));
    context.put("/member/delete", new MemberDeleteCommand(
        (List<Member>) context.get("memberList")));

    context.put("/project/add", new ProjectAddCommand(
        (List<Project>) context.get("projectList"), memberListCommand));
    context.put("/project/list", new ProjectListCommand(
        (List<Project>) context.get("projectList")));
    context.put("/project/detail", new ProjectDetailCommand(
        (List<Project>) context.get("projectList")));
    context.put("/project/update", new ProjectUpdateCommand(
        (List<Project>) context.get("projectList"), memberListCommand));
    context.put("/project/delete", new ProjectDeleteCommand(
        (List<Project>) context.get("projectList")));

    context.put("/task/add", new TaskAddCommand(
        (List<Task>) context.get("taskList"), memberListCommand));
    context.put("/task/list", new TaskListCommand(
        (List<Task>) context.get("taskList")));
    context.put("/task/detail", new TaskDetailCommand((List<Task>) context.get("taskList")));
    context.put("/task/update", new TaskUpdateCommand(
        (List<Task>) context.get("taskList"), memberListCommand));
    context.put("/task/delete", new TaskDeleteCommand((List<Task>) context.get("taskList")));
    context.put("/calc", new CalculatorCommand());
    context.put("/hello", new HelloCommand());
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {

  }

}
