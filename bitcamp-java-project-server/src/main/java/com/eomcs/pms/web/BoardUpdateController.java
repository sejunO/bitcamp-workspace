package com.eomcs.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;

@RequestMapping("/board/update")
public class BoardUpdateController implements Controller {
  BoardService boardService;

  public BoardUpdateController() {
    BoardService boardService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    int count = boardService.update(board);

    if (count == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    return "redirect:list";

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;
@Controller
public class BoardUpdateController {
  @Autowired
  BoardService boardService;

  @RequestMapping("/board/update")
  public String execute(Board board,HttpServletRequest request, HttpServletResponse response) throws Exception {
    int count = boardService.update(board);
    if (count == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
>>>>>>> e3fe8021768f113e4880bbc692700e69329943f8
  }
}
