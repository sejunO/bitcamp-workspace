package com.eomcs.pms.filter;

import com.eomcs.pms.domain.Member;
import com.eomcs.pms.handler.Request;

public class AuthCommandFilter implements CommandFilter {

  @Override
  public void doFilter(Request request, FilterChain next) throws Exception {
    Member member = (Member) request.getContext().get("loginUser");
    if (!request.getCommandPath().equalsIgnoreCase("/login") && member == null) {
      System.out.println("로그인이 필요합니다");
      return;
    }
    next.doFilter(request);
  }
}
