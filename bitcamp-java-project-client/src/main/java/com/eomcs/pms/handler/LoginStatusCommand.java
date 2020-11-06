package com.eomcs.pms.handler;

import java.util.List;
import java.util.Map;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

// Command 규칙에 따라 클래스를 정의한다.
public class LoginStatusCommand implements Command {
  MemberDao memberDao;

  public LoginStatusCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  @Override
  public void execute(Map<String, Object> context) {
    try {
      List<Member> members = memberDao.findAll();
    } catch (Exception e) {

    }

  }
}
