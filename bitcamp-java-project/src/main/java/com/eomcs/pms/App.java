package com.eomcs.pms;

import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.domain.Task;
import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.ArrayList;
import com.eomcs.util.LinkedList;
import com.eomcs.util.List;
import com.eomcs.util.Prompt;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

public class App {

  public static void main(String[] args) {

    List<Board> boardList = new ArrayList<>();
    List<Member> memberList = new LinkedList<>();
    List<Project> projectList = new LinkedList<>();
    List<Task> taskList = new LinkedList<>();

    BoardHandler boardHandler = new BoardHandler(boardList);
    MemberHandler memberHandler = new MemberHandler(memberList);

    ProjectHandler projectHandler = new ProjectHandler(projectList, memberHandler);
    TaskHandler taskHandler = new TaskHandler(taskList, memberHandler);
    Stack<String> stack = new Stack<>();
    Queue<String> queue = new Queue<>();

    loop: while (true) {
      String command = Prompt.inputString("명령> ");

      stack.push(command);
      queue.offer(command);

      switch (command) {
        case "/member/add":
          memberHandler.add();
          break;
        case "/member/list":
          memberHandler.list();
          break;
        case "/member/detail":
          memberHandler.detail();
          break;
        case "/member/update":
          memberHandler.update();
          break;
        case "/member/delete":
          memberHandler.delete();
          break;
        case "/project/add":
          projectHandler.add();
          break;
        case "/project/list":
          projectHandler.list();
          break;
        case "/project/detail":
          projectHandler.detail();
          break;
        case "/project/update":
          projectHandler.update();
          break;
        case "/project/delete":
          projectHandler.delete();
          break;
        case "/task/add":
          taskHandler.add();
          break;
        case "/task/list":
          taskHandler.list();
          break;
        case "/task/detail":
          taskHandler.detail();
          break;
        case "/task/update":
          taskHandler.update();
          break;
        case "/task/delete":
          taskHandler.delete();
          break;
        case "/board/add":
          boardHandler.add();
          break;
        case "/board/list":
          boardHandler.list();
          break;
        case "/board/detail":
          boardHandler.detail();
          break;
        case "/board/update":
          boardHandler.update();
          break;
        case "/board/delete":
          boardHandler.delete();
          break;
        case "hs":
          printStackHistory(stack);
          break;
        case "hq":
          printQueueHistory(queue);
          break;
        case "quit":
        case "exit":
          System.out.println("안녕!");
          break loop;
        default:
          System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
    }
    Prompt.close();
  }

  static void printStackHistory(Stack<String> stack) {
    try {
      Stack<String> history = stack.clone();

      for (int count = 1; history.size() != 0; count++) {
        System.out.println(history.pop());

        if (count % 5 == 0) {
          String response = Prompt.inputString(" : ");
          if (response.equalsIgnoreCase("q")) {
            break;
          }
        }
      }

    } catch (Exception e) {
      System.out.println("실패");
    }


  }


  private static void printQueueHistory(Queue<String> queue) {
    try {
      Queue<String> printQueue = queue.clone();

      for (int count = 1; printQueue.size() > 0; count++) {
        System.out.println(printQueue.poll());
        if (count % 5 == 0) {
          String response = Prompt.inputString(" : ");
          if (response.equalsIgnoreCase("q")) {
            break;
          }
        }
      }
    } catch (Exception e) {
      System.out.println("실패");
    }
  }
}
