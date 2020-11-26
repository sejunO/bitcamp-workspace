package com.eomcs.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.BoardService;

// Command 규칙에 따라 클래스를 정의한다.
@WebServlet("/board/add")
public class BoardAddCommand extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    ServletContext ctx = req.getServletContext();
    BoardService boardService = (BoardService) ctx.getAttribute("boardService");

    req.setCharacterEncoding("UTF-8");
    Board board = new Board();
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));
    PrintWriter out = resp.getWriter();
    HttpSession session = req.getSession();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>servlet03</title></head>");

    out.println("[게시물 등록]");

    Member loginUser = (Member) session.getAttribute("loginUser");
    board.setWriter(loginUser);

    try {
      boardService.add(board);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    out.println("게시글을 등록하였습니다.");

  }
}