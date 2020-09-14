package com.eomcs.pms;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
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
import com.eomcs.pms.handler.SayHelloCommand;
import com.eomcs.pms.handler.TaskAddCommand;
import com.eomcs.pms.handler.TaskDeleteCommand;
import com.eomcs.pms.handler.TaskDetailCommand;
import com.eomcs.pms.handler.TaskListCommand;
import com.eomcs.pms.handler.TaskUpdateCommand;
import com.eomcs.util.Prompt;

public class App {

  static List<Board> boardList = new ArrayList<>();

  public static void main(String[] args) {

    loadBoards();
    Map<String,Command> commandMap = new HashMap<>();

    //Board
    commandMap.put("/board/add", new BoardAddCommand(boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(boardList));


    //Member
    List<Member> memberList = new LinkedList<>();
    MemberListCommand memberListCommand = new MemberListCommand(memberList);
    commandMap.put("/member/add", new MemberAddCommand(memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(memberList));


    //Project
    List<Project> projectList = new ArrayList<>();
    commandMap.put("/project/add", new ProjectAddCommand(projectList, memberListCommand));
    commandMap.put("/project/list", new ProjectListCommand(projectList));
    commandMap.put("/project/detail", new ProjectDetailCommand(projectList));
    commandMap.put("/project/update", new ProjectUpdateCommand(projectList, memberListCommand));
    commandMap.put("/project/delete", new ProjectDeleteCommand(projectList));

    //Task
    List<Task> taskList = new LinkedList<>();
    commandMap.put("/task/add", new TaskAddCommand(taskList, memberListCommand));
    commandMap.put("/task/add", new TaskListCommand(taskList));
    commandMap.put("/task/add", new TaskDetailCommand(taskList));
    commandMap.put("/task/add", new TaskUpdateCommand(taskList, memberListCommand));
    commandMap.put("/task/add", new TaskDeleteCommand(taskList));

    //Hello
    commandMap.put("hello", new SayHelloCommand());

    //history
    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();

    loop:
      while (true) {
        String inputStr = Prompt.inputString("명령> ");

        if (inputStr.length() == 0) {
          continue;
        }
        commandStack.push(inputStr);
        commandQueue.offer(inputStr);

        switch (inputStr) {
          case "member/list": memberListCommand.execute();break;
          case "history": printCommandHistory(commandStack.iterator());break;
          case "history2": printCommandHistory(commandQueue.iterator());break;
          case "quit":
          case "exit":
            System.out.println("안녕!");
            break loop;
          default:
            Command command = commandMap.get(inputStr);
            try {
              command.execute();
            } catch (Exception e) {
              System.out.printf("%s\n", e.getClass().getName());
              System.out.println("실행할 수 없는 명령입니다.");
            }
        }
        System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
      }

    Prompt.close();

    // 프로그램 종료 전에 List에 보관된 객체를 파일에 저장한다.
    saveBoards();
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

  public static void saveBoards() {
    System.out.println("게시글 저장");

    File file = new File("./board.csv");
    FileWriter out = null;
    try {
      out = new FileWriter(file);

      for (Board board : boardList) {
        String.format("%d, %s, %s, %s, %s, %d\n",
            board.getNo(),
            board.getTitle(),
            board.getContent(),
            board.getWriter(),
            board.getRegisteredDate(),
            board.getViewCount());

        out.write(board.getTitle());
      }

    } catch (IOException e) {
      System.out.println("파일 출력 작업 중에 오류 발생");
    } finally {
      try {
        out.close();
      } catch (Exception e) {

      }
    }
  }

  static void loadBoards() {
    System.out.println("게시글 파일 로딩");
    //읽어올 파일
    File file = new File("./board.csv");

    FileReader out = null;
    Scanner sc = null;
    try {
      // 데이터를 읽을 때 사용할 도구
      out = new FileReader(file);
      sc = new Scanner(file);

      while (true) {
        try {
          String record = sc.nextLine();
        } catch (NoSuchElementException e) {
          break;
        }

      }

      for (Board board : boardList) {
        String.format("%d, %s, %s, %s, %s, %d\n",
            board.getNo(),
            board.getTitle(),
            board.getContent(),
            board.getWriter(),
            board.getRegisteredDate(),
            board.getViewCount());

        out.write(board.getTitle());
      }

    } catch (IOException e) {
      System.out.println("파일 출력 작업 중에 오류 발생");
    } finally {
      try {
        out.close();
      } catch (Exception e) {

      }
    }
  }

}
