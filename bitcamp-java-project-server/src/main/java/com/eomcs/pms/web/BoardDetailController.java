package com.eomcs.pms.web;

<<<<<<< HEAD
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    BoardService boardService =
        (BoardService) ctx.getAttribute("boardService");

    response.setContentType("text/html;charset=UTF-8");

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardService.get(no);
      if (board == null) {
        throw new Exception("해당 번호의 게시글이 없습니다!");
      }
      request.setAttribute("board", board);
      request.setAttribute("viewName", "/board/detail.jsp");

    } catch (Exception e) {
      request.setAttribute("exception", e);
    }
=======
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;
@Controller
public class BoardDetailController {
  @Autowired
  BoardService boardService;

  @RequestMapping("/board/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    response.setContentType("text/html;charset=UTF-8");

    int no = Integer.parseInt(request.getParameter("no"));
    Board board = boardService.get(no);
    if (board == null) {
      throw new Exception("해당 번호의 게시글이 없습니다!");
    }
    request.setAttribute("board", board);
    return "/board/detail.jsp";
>>>>>>> e3fe8021768f113e4880bbc692700e69329943f8
  }
}
