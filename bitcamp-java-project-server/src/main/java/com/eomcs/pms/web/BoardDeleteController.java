package com.eomcs.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import com.eomcs.pms.service.BoardService;

@RequestMapping("/board/delete")
public class BoardDeleteController implements Controller {
  BoardService boardService;

  public BoardDeleteController(BoardService boardService) {
    this.boardService = boardService;
  }

  @Override
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.pms.service.BoardService;

@Controller
public class BoardDeleteController {
  @Autowired
  BoardService boardService;


  @RequestMapping("/board/delete")
>>>>>>> e3fe8021768f113e4880bbc692700e69329943f8
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    if (boardService.delete(no) == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
<<<<<<< HEAD

=======
>>>>>>> e3fe8021768f113e4880bbc692700e69329943f8
  }
}
