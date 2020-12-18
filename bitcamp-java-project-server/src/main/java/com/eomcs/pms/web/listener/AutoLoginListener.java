package com.eomcs.pms.web.listener;

<<<<<<< HEAD
import java.util.Map;
=======
>>>>>>> e3fe8021768f113e4880bbc692700e69329943f8
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.eomcs.pms.domain.Member;
<<<<<<< HEAD
import com.eomcs.pms.service.MemberService;

@WebListener
public class AutoLoginListener implements ServletRequestListener {
  @SuppressWarnings("unchecked")
  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    System.out.println("ㅋㅋ 자동 로그인!");
    try {
      HttpSession session = ((HttpServletRequest) sre.getServletRequest()).getSession();

      if (session.getAttribute("loginUser") == null) {

        Map<String, Object> beanContainer =
            (Map<String, Object>) sre.getServletContext().getAttribute("beanContainer");

        MemberService memberService = (MemberService) beanContainer.get("memberService");

        Member member = memberService.get("test3@test.com", "1111");

        session.setAttribute("loginUser", member);
      }
    } catch (Exception e) {
      e.printStackTrace();
=======

@WebListener
public class AutoLoginListener implements ServletRequestListener {
  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    System.out.println("ㅋㅋ 자동 로그인!");
    HttpSession session = ((HttpServletRequest)sre.getServletRequest()).getSession();
    if (session.getAttribute("loginUser") == null) {
      Member member = new Member().setNo(1).setName("x2").setEmail("x2@test.com");
      session.setAttribute("loginUser", member);
>>>>>>> e3fe8021768f113e4880bbc692700e69329943f8
    }
  }
}
