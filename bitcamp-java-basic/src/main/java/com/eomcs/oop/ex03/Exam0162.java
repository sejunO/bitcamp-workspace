package com.eomcs.oop.ex03;

public class Exam0162 {
  static class Member {
    static final int GUEST = 0;
    static final int MEMBER = 1;
    static final int MANAGER = 2;
    String id;
    String password;
    int type;
  }
  public static void main(String[] args) {


    Member m1 = new Member();
    m1.id = "aa";
    m1.password = "1111";
    m1.type = Member.GUEST;

    Member m2 = new Member();
    m2.id = "bb";
    m2.password = "2222";
    m2.type = Member.MEMBER;

    Member m3 = new Member();
    m3.id = "cc";
    m3.password = "3333";
    m3.type = Member.MANAGER;

  }
}
