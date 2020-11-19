package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;
import com.eomcs.util.Prompt;

public class BoardSearchCommand implements Command {

  BoardService boardService;

  public BoardSearchCommand(BoardService boardService) {
    this.boardService = boardService;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in, Map<String,Object> context) {
    out.println("[게시물 상세 검색]");
    try {
      // 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
      // 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.
      String keyword = Prompt.inputString("키워드? ", out, in);
      List<Board> list = boardService.list(keyword);
      Iterator<Board> iterator = list.iterator();
      while (iterator.hasNext()) {
        Board board = iterator.next();
        out.printf("%d, %s, %s, %s, %d\n",
            board.getNo(),
            board.getTitle(),
            board.getWriter().getName(),
            board.getRegisteredDate(),
            board.getViewCount());
      }
    } catch (Exception e) {
      System.out.println("게시글 목록 출력 중 오류");
      e.printStackTrace();
    }
  }

}
