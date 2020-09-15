package com.eomcs.pms;

import java.io.File;
import java.io.FileNotFoundException;
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
  static File boardFile = new File("./board.csv");

  static List<Member> memberList = new ArrayList<>();
  static File memberFile = new File("./member.csv");

  static List<Project> projectList = new ArrayList<>();
  static File projectFile = new File("./project.csv");

  static List<Task> taskList = new LinkedList<>();
  static File taskFile = new File("./task.csv");

  public static void main(String[] args) {

    loadBoards();
    loadMembers();
    loadProjects();
    loadTasks();

    Map<String,Command> commandMap = new HashMap<>();

    //Board
    commandMap.put("/board/add", new BoardAddCommand(boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(boardList));


    //Member
    MemberListCommand memberListCommand = new MemberListCommand(memberList);
    commandMap.put("/member/add", new MemberAddCommand(memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(memberList));


    //Project

    commandMap.put("/project/add", new ProjectAddCommand(projectList, memberListCommand));
    commandMap.put("/project/list", new ProjectListCommand(projectList));
    commandMap.put("/project/detail", new ProjectDetailCommand(projectList));
    commandMap.put("/project/update", new ProjectUpdateCommand(projectList, memberListCommand));
    commandMap.put("/project/delete", new ProjectDeleteCommand(projectList));

    //Task

    commandMap.put("/task/add", new TaskAddCommand(taskList, memberListCommand));
    commandMap.put("/task/list", new TaskListCommand(taskList));
    commandMap.put("/task/detail", new TaskDetailCommand(taskList));
    commandMap.put("/task/update", new TaskUpdateCommand(taskList, memberListCommand));
    commandMap.put("/task/delete", new TaskDeleteCommand(taskList));

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
          case "/member/list": memberListCommand.execute();break;
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
    saveMembers();
    saveProjects();
    saveTasks();
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
    FileWriter out = null;
    try {
      out = new FileWriter(boardFile);

      for (Board board : boardList) {
        out.write(board.toCsvString());
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

    FileReader out = null;
    Scanner sc = null;
    try {
      // 데이터를 읽을 때 사용할 도구
      out = new FileReader(boardFile);
      sc = new Scanner(boardFile);

      int count = 0;

      while (true) {
        try {
          boardList.add(Board.valueOfCsv(sc.nextLine()));
          count++;
        } catch (NoSuchElementException e) {
          break;
        }

      }
      System.out.printf("총 %d 개의 데이터를 로딩\n",count);

    } catch (IOException e) {
      System.out.println("파일 출력 작업 중에 오류 발생");
    } finally {
      try {
        out.close();
      } catch (Exception e) {

      }
    }
  }







  public static void saveMembers() {
    System.out.println("회원 저장");

    FileWriter out = null;
    try {
      out = new FileWriter(memberFile);
      int count = 0;

      for (Member member : memberList) {
        out.write(member.toCsvString());
        count++;
      }
      System.out.println("회원 정보 저장" + count + "개");
    } catch (IOException e) {
      System.out.println("회원 파일 쓰기 작업 중에 오류 발생" + e.getMessage());
    } finally {
      try {
        out.close();
      } catch (Exception e) {

      }
    }
  }



  static void loadMembers() {
    System.out.println("회원 파일 로딩");
    FileReader in = null;
    Scanner sc = null;
    try {
      // 데이터를 읽을 때 사용할 도구
      in = new FileReader(memberFile);
      sc = new Scanner(in);

      int count = 0;

      while (true) {
        try {
          memberList.add(Member.valueOfCsv(sc.nextLine()));
          count++;
        } catch (Exception e) {
          break;
        }

      }
      System.out.printf("총 %d 개의 데이터를 로딩\n",count);

    } catch (IOException e) {
      System.out.println("파일 읽기 작업 중에 오류 발생" + e.getMessage());
    } finally {
      try {in.close();} catch (Exception e) {}
      try {sc.close();} catch (Exception e){}
    }
  }
  private static void saveProjects() {
    FileWriter out = null;

    try {
      out = new FileWriter(projectFile);
      int count = 0;

      for (Project project : projectList) {
        out.write(project.toCsvString());
        count++;
      }
      System.out.printf("총 %d 개의 프로젝트 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("프로젝트 데이터의 파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }

  private static void loadProjects() {
    FileReader in = null;
    Scanner dataScan = null;

    try {
      in = new FileReader(projectFile);
      dataScan = new Scanner(in);
      int count = 0;

      while (true) {
        try {
          projectList.add(Project.valueOfCsv(dataScan.nextLine()));
          count++;

        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d 개의 프로젝트 데이터를 로딩했습니다.\n", count);

    } catch (FileNotFoundException e) {
      System.out.println("프로젝트 파일 읽기 중 오류 발생! - " + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private static void saveTasks() {
    FileWriter out = null;

    try {
      out = new FileWriter(taskFile);
      int count = 0;

      for (Task task : taskList) {
        out.write(task.toCsvString());
        count++;
      }
      System.out.printf("총 %d 개의 작업 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("작업 데이터의 파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }

  private static void loadTasks() {
    FileReader in = null;
    Scanner dataScan = null;

    try {
      in = new FileReader(taskFile);
      dataScan = new Scanner(in);
      int count = 0;

      while (true) {
        try {
          taskList.add(Task.valueOfCsv(dataScan.nextLine()));
          count++;

        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d 개의 작업 데이터를 로딩했습니다.\n", count);

    } catch (FileNotFoundException e) {
      System.out.println("작업 파일 읽기 중 오류 발생! - " + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }



}
