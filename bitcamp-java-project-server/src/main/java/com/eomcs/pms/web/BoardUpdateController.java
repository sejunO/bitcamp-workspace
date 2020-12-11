package com.eomcs.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
  }
}
