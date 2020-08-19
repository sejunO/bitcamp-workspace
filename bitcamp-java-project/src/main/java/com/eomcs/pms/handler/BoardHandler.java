package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.util.Prompt;

public class BoardHandler {

  // 프로젝트 데이터
  static class Board {
    int no;
    String title;
    String content;
    String writer;
    int viewCount;
    Date today;
  }
  MemberHandler memberHandler;
  public BoardHandler(MemberHandler memberHandler) {
    this.memberHandler = memberHandler;
  }
  static final int LENGTH = 100;  // PLENGTH 를 LENGTH 로 변경한다.
  Board[] list = new Board[LENGTH]; // projects 를 list 로 변경한다.
  int size = 0; // psize 를 size 로 변경한다.

  //다른 패키지에서 이 메서드를 사용할 수 있도록 public 으로 사용 범위를 공개한다.
  public  void add() {
    System.out.println("[프로젝트 등록]");

    Board board = new Board();
    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");

    while (true) {
      String name = Prompt.inputString("만든이?(취소: 빈 문자열) ");

      if (name.length() == 0) {
        System.out.println("게시판 등록을 취소합니다.");
        return;
      } else if (memberHandler.findByName(name) != null) {
        board.writer = name;
        break;
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
      board.today = new Date(System.currentTimeMillis());
    }

    list[size++] = board;
  }

  public  void list() {
    System.out.println("[프로젝트 목록]");

    for (int i = 0; i < size; i++) {
      Board board = list[i];
      System.out.printf("%d, %s, %s, %s, %d\n",
          board.no,
          board.title,
          board.writer,
          board.today.toString(),
          ++board.viewCount
          );
    }
  }
}
