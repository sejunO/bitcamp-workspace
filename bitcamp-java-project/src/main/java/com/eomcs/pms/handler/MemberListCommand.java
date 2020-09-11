package com.eomcs.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.pms.domain.Member;

public class MemberListCommand implements Command{

  private List<Member> memberList;

  public MemberListCommand(List<Member> memberList) {
    this.memberList = memberList;
  }

  @Override
  public void execute() {
    Iterator<Member> iterator = memberList.iterator();
    while (iterator.hasNext()) {
      Member member = iterator.next();
      System.out.printf("%d, %s, %s, %s, %s\n",
          member.getNo(),
          member.getName(),
          member.getEmail(),
          member.getTel(),
          member.getRegisteredDate());
    }
  }

  public Member findByName(String name) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getName().equals(name)) {
        return member;
      }
    }
    return null;
  }

}
