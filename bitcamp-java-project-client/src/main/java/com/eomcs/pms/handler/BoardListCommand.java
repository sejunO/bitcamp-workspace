package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.dao.BoardDao;
import com.eomcs.pms.domain.Board;

public class BoardListCommand implements Command {
  BoardDao boardDao;
  public BoardListCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    System.out.println("[게시물 목록]");

    try {
      List<Board> list = boardDao.findAll();

      for (Board board : list) {
        System.out.printf("%d, %s, %s, %s, %d",
            board.getNo(),
            board.getContent(),
            board.getWriter().getName(),
            board.getRegisteredDate(),
            board.getViewCount());
      }

    } catch (Exception e) {
      System.out.println("게시글 목록 조회 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
