package com.eomcs.pms;

import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.domain.Task;
import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.AbstractList;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Iterator;
import com.eomcs.util.LinkedList;
import com.eomcs.util.List;
import com.eomcs.util.Prompt;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

public class App {

  public static void main(String[] args) {

    List<Board> boardList = new ArrayList<>();
    BoardHandler boardHandler = new BoardHandler(boardList);

    AbstractList<Member> memberList = new LinkedList<>();
    MemberHandler memberHandler = new MemberHandler(memberList);

    AbstractList<Project> projectList = new ArrayList<>();
    ProjectHandler projectHandler = new ProjectHandler(projectList, memberHandler);

    AbstractList<Task> taskList = new LinkedList<>();
    TaskHandler taskHandler = new TaskHandler(taskList, memberHandler);

    Stack<String> commandStack = new Stack<>();
    Queue<String> commandQueue = new Queue<>();

    loop:
      while (true) {
        String command = Prompt.inputString("명령> ");

        commandStack.push(command);
        commandQueue.offer(command);

        switch (command) {
          case "/member/add": memberHandler.add(); break;
          case "/member/list": memberHandler.list(); break;
          case "/member/detail": memberHandler.detail(); break;
          case "/member/update": memberHandler.update(); break;
          case "/member/delete": memberHandler.delete(); break;
          case "/project/add": projectHandler.add(); break;
          case "/project/list": projectHandler.list(); break;
          case "/project/detail": projectHandler.detail(); break;
          case "/project/update": projectHandler.update(); break;
          case "/project/delete": projectHandler.delete(); break;
          case "/task/add": taskHandler.add(); break;
          case "/task/list": taskHandler.list(); break;
          case "/task/detail": taskHandler.detail(); break;
          case "/task/update": taskHandler.update(); break;
          case "/task/delete": taskHandler.delete(); break;
          case "/board/add": boardHandler.add(); break;
          case "/board/list": boardHandler.list(); break;
          case "/board/detail": boardHandler.detail(); break;
          case "/board/update": boardHandler.update(); break;
          case "/board/delete": boardHandler.delete(); break;
          case "history": printCommandHistory(commandStack.iterator());break;
          case "history2": printCommandHistory(commandQueue.iterator());break;
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


  private static void printCommandHistory(Iterator<String> iterator) {

    while (iterator.hasNext()) {
      System.out.println(iterator.next());

      int count = 1;
      if (count++ % 5 == 0) {
        String response = Prompt.inputString(" : ");
        if (response.equalsIgnoreCase("q"))
          break;
      }
    }

  }
}
