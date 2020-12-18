package com.eomcs.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> e3fe8021768f113e4880bbc692700e69329943f8
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.BoardService;

<<<<<<< HEAD
@RequestMapping("/board/add")
public class BoardAddController implements Controller {
  BoardService boardService;

  public BoardAddController(BoardService boardService) {
    this.boardService = boardService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Board board = new Board();
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
=======
@Controller
public class BoardAddController {
  @Autowired
  BoardService boardService;


  @RequestMapping("/board/add")
  public String execute(HttpServletRequest request, HttpServletResponse response, Board board) throws Exception {
>>>>>>> e3fe8021768f113e4880bbc692700e69329943f8

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    board.setWriter(loginUser);
    boardService.add(board);
    return "redirect:list";
<<<<<<< HEAD

=======
>>>>>>> e3fe8021768f113e4880bbc692700e69329943f8
  }
}
