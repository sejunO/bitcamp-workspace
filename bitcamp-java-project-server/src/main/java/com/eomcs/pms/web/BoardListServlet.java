package com.eomcs.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    BoardService boardService = (BoardService) ctx.getAttribute("boardService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>servlet03</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[게시물 목록]");
      out.println("<a href='form.html'>새글</a><br>");
      List<Board> list = boardService.list();

      for (Board board : list) {
        out.println("<table><tr>");
        out.printf("<td>번호 : ");
        out.printf("%s</td>", board.getNo());

        out.printf("<td> 제목 : ");
        out.printf("%s</td>", board.getTitle());

        out.printf("<td> 작성자 : ");
        out.printf("%s</td>", board.getWriter().getName());

        out.printf("<td> 생성일 : ");
        out.printf("%s</td>", board.getRegisteredDate());

        out.printf("<td> 내용 : ");
        out.printf("%s</td>", board.getContent());

        out.printf("<td> 조회수 : ");
        out.printf("%s</td>", board.getViewCount());

        out.println("</tr></table>");
        out.println();
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
