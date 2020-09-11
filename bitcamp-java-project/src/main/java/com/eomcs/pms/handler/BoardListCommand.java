package com.eomcs.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.pms.domain.Board;

public class BoardListCommand implements Command {
  private List<Board> boardList;

  public BoardListCommand(List<Board> boardList) {
    this.boardList = boardList;
  }

  @Override
  public void execute() {
    Iterator<Board> iterator = boardList.iterator();

    while (iterator.hasNext()) {
      Board board = iterator.next();
      System.out.printf("%d, %s, %s, %s, %d\n",
          board.getNo(),
          board.getTitle(),
          board.getWriter(),
          board.getRegisteredDate(),
          board.getViewCount());
    }
  }

}
