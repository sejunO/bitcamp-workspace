package com.eomcs.pms.web;

<<<<<<< HEAD
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;

@RequestMapping("/board/list")
public class BoardListController implements Controller {

  BoardService boardService;

  public BoardListController(BoardService boardService) {
    this.boardService = boardService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/html;charset=UTF-8");

    String keyword = request.getParameter("keyword");
    List<Board> list = boardService.list(keyword);
    request.setAttribute("list", list);
    return "/board/list.jsp";
=======
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.eomcs.pms.service.BoardService;
@Controller
public class BoardListController {
  @Autowired
  BoardService boardService;


  @RequestMapping("/board/list")
  public ModelAndView execute(String keyword, HttpServletResponse response) throws Exception {
    response.setContentType("text/html;charset=UTF-8");
    ModelAndView mv = new ModelAndView();
    mv.addObject("list",boardService.list(keyword));
    mv.setViewName("/board/list.jsp");
    return mv;
>>>>>>> e3fe8021768f113e4880bbc692700e69329943f8
  }
}
