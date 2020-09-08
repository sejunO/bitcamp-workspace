package com.eomcs.amini;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberHandler {

  ArrayList<Member> memberList = new ArrayList<>();

  public void add() {

    Member member = new Member();

    member.name = Prompt.inputString("name? : ");
    member.email = Prompt.inputString("email? : ");
    member.age = Prompt.inputInt("age? : ");

    memberList.add(member);
  }

  public void list() {
    Iterator<Member> iterator = memberList.iterator();

    while(iterator.hasNext()) {
      Member member = iterator.next();
      System.out.printf("이름: %s, 이메일: %s, 나이: %d \n", 
          member.name, member.email, member.age );
    }
  }


}
