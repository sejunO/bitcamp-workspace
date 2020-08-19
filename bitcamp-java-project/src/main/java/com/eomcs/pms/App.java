package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

// 1) `Prompt` 클래스를 별도의 패키지로 분류한다
// 2) 핸들러 클래스들을 별도의 패키지로 분류한다
public class App {

  public static void main(String[] args) {
    MemberHandler member = new MemberHandler();
    BoardHandler notice = new BoardHandler(member);
    BoardHandler qna = new BoardHandler(member);
    ProjectHandler project = new ProjectHandler(member);
    TaskHandler task = new TaskHandler(member);

    loop:
      while (true) {
        String command = Prompt.inputString("명령> ");

        switch (command) {
          case "/member/add":
            member.add();
            break;
          case "/member/list":
            member.list();
            break;
          case "/project/add":
            project.add();
            break;
          case "/project/list":
            project.list();
            break;
          case "/task/add":
            task.add();
            break;
          case "/task/list":
            task.list();
            break;
          case "/notice/add":
            notice.add();
            break;
          case "/board/list":
            notice.list();
          case "/qna/add":
            qna.add();
            break;
          case "/qna/list":
            qna.list();
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
}
