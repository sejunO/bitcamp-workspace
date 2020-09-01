package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Prompt;

public class BoardHandler {

  // BoardHandler가 사용할 BoardList 객체를 준비한다.
  ArrayList<Board> boardList = new ArrayList<>();

  public void add() {
    System.out.println("[게시물 등록]");

    Board board = new Board();
    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setRegisteredDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    boardList.add(board);

    System.out.println("게시글을 등록하였습니다.");
  }

  public void list() {
    System.out.println("[게시물 목록]");

    Board[] boards = boardList.toArray(new Board[] {});


    for (Board board : boards) {
      System.out.printf("%d, %s, %s, %s, %d\n", board.getNo(), board.getTitle(), board.getWriter(),
          board.getRegisteredDate(), board.getViewCount());
    }
  }

  public void detail() {
    System.out.println("[게시글 상세조회]");
    int no = Prompt.inputInt("번호? ");
    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
    } else {
      board.setViewCount(board.getViewCount() + 1);
      System.out.printf("제목: %s", board.getTitle());
      System.out.printf("내용: %s", board.getContent());
      System.out.printf("등록일: %s", board.getRegisteredDate());
      System.out.printf("조회수: %s", board.getViewCount());
    }
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");
    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
    } else {
      String title = Prompt.inputString(String.format("제목(%s)?", board.getTitle()));
      String content = Prompt.inputString(String.format("내용(%s)?", board.getContent()));
      String writer = Prompt.inputString(String.format("작성자(%s)?", board.getWriter()));

      String response = Prompt.inputString("정말 변경하시겠습니까? (y/N) ");
      if (response.equalsIgnoreCase("y")) {
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);
        System.out.println("변 경 완 료");
      } else {
        System.out.println("변 경 취 소");
      }
    }
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");
    int index = indexOf(no);
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    String response = Prompt.inputString("정말 변경하시겠습니까? (y/N) ");
    if (response.equalsIgnoreCase("y")) {
      boardList.remove(index);
      System.out.println("게시글을 삭제하였습니다.");
    } else {
      System.out.println("삭 제 취 소");
    }
  }

  private int indexOf(int no) {
    for (int i = 0; i < boardList.size(); i++) {
      Board board = boardList.get(i);
      if (board.getNo() == no) {
        return i;
      }
    }
    return -1;
  }

  private Board findByNo(int no) {
    for (int i = 0; i < boardList.size(); i++) {
      Board board = boardList.get(i);
      if (board.getNo() == no) {
        return board;
      }
    }
    return null;
  }
}
