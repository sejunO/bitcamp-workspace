package com.eomcs.pms.handler;

import java.util.Map;
import com.eomcs.pms.domain.Member;

// Command 규칙에 따라 클래스를 정의한다.
public class WhoamiCommand implements Command {


  @Override
  public void execute(Map<String, Object> context) {
    Member member = (Member) context.get("loginUser");
    if (member == null) {
      System.out.println("로그인하지 않았습니다.");
      return;
    }
    System.out.println("사용자번호: " + member.getNo());
    System.out.println("이름: " + member.getName());
    System.out.println("이메일: " + member.getEmail());
    System.out.println("사진: " + member.getPhoto());
    System.out.println("전화: " + member.getTel());
  }
}
