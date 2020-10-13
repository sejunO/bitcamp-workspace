package com.eomcs.pms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
import com.eomcs.pms.handler.Command;
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
import com.eomcs.pms.listener.AppInitListener;
import com.eomcs.pms.listener.DataHandlerListener;
import com.eomcs.util.Prompt;

public class App {
  List<ApplicationContextListener> listeners = new ArrayList<>();
  Map<String, Object> context = new Hashtable<>();
  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationContextListenerOnServiceSrarted() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationContextListenerOnServiceStopped() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }

  public static void main(String[] args) throws Exception {
    App app = new App();
    app.addApplicationContextListener(new AppInitListener());
    app.addApplicationContextListener(new DataHandlerListener());
    app.service();
  }

  @SuppressWarnings("unchecked")
  public void service() throws Exception {
    notifyApplicationContextListenerOnServiceSrarted();
    Map<String, Command> commandMap = new HashMap<>();

    commandMap.put("/board/add", new BoardAddCommand((List<Board>) context.get("boardList")));
    commandMap.put("/board/list", new BoardListCommand((List<Board>) context.get("boardList")));
    commandMap.put("/board/detail", new BoardDetailCommand((List<Board>) context.get("boardList")));
    commandMap.put("/board/update", new BoardUpdateCommand((List<Board>) context.get("boardList")));
    commandMap.put("/board/delete", new BoardDeleteCommand((List<Board>) context.get("boardList")));

    MemberListCommand memberListCommand = new MemberListCommand(
        (List<Member>) context.get("memberList"));
    commandMap.put("/member/add", new MemberAddCommand(
        (List<Member>) context.get("memberList")));
    commandMap.put("/member/list", memberListCommand);
    commandMap.put("/member/detail", new MemberDetailCommand(
        (List<Member>) context.get("memberList")));
    commandMap.put("/member/update", new MemberUpdateCommand(
        (List<Member>) context.get("memberList")));
    commandMap.put("/member/delete", new MemberDeleteCommand(
        (List<Member>) context.get("memberList")));

    commandMap.put("/project/add", new ProjectAddCommand(
        (List<Project>) context.get("projectList"), memberListCommand));
    commandMap.put("/project/list", new ProjectListCommand(
        (List<Project>) context.get("projectList")));
    commandMap.put("/project/detail", new ProjectDetailCommand(
        (List<Project>) context.get("projectList")));
    commandMap.put("/project/update", new ProjectUpdateCommand(
        (List<Project>) context.get("projectList"), memberListCommand));
    commandMap.put("/project/delete", new ProjectDeleteCommand(
        (List<Project>) context.get("projectList")));

    commandMap.put("/task/add", new TaskAddCommand(
        (List<Task>) context.get("taskList"), memberListCommand));
    commandMap.put("/task/list", new TaskListCommand(
        (List<Task>) context.get("taskList")));
    commandMap.put("/task/detail", new TaskDetailCommand((List<Task>) context.get("taskList")));
    commandMap.put("/task/update", new TaskUpdateCommand(
        (List<Task>) context.get("taskList"), memberListCommand));
    commandMap.put("/task/delete", new TaskDeleteCommand((List<Task>) context.get("taskList")));

    commandMap.put("/hello", new HelloCommand());

    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();

    loop: while (true) {
      String inputStr = Prompt.inputString("명령> ");

      if (inputStr.length() == 0) {
        continue;
      }

      commandStack.push(inputStr);
      commandQueue.offer(inputStr);

      switch (inputStr) {
        case "history":
          printCommandHistory(commandStack.iterator());
          break;
        case "history2":
          printCommandHistory(commandQueue.iterator());
          break;
        case "quit":
        case "exit":
          System.out.println("안녕!");
          break loop;
        default:
          Command command = commandMap.get(inputStr);
          if (command != null) {
            try {
              // 실행 중 오류가 발생할 수 있는 코드는 try 블록 안에 둔다.
              command.execute();
            } catch (Exception e) {
              // 오류가 발생하면 그 정보를 갖고 있는 객체의 클래스 이름을 출력한다.
              System.out.println("--------------------------------------------------------------");
              System.out.printf("명령어 실행 중 오류 발생: %s\n", e);
              System.out.println("--------------------------------------------------------------");
            }
          } else {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
      System.out.println();
    }

    Prompt.close();

    // 데이터를 파일에 저장


    notifyApplicationContextListenerOnServiceStopped();

  }

  static void printCommandHistory(Iterator<String> iterator) {
    try {
      int count = 0;
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
        count++;

        if ((count % 5) == 0 && Prompt.inputString(":").equalsIgnoreCase("q")) {
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("history 명령 처리 중 오류 발생!");
    }
  }






}
