package com.eomcs.oop.ex03;

public class Exam0160 {
  public static void main(String[] args) {
    Member m1 = new Member();
    m1.id = "aa";
    m1.password = "1111";
    m1.type = 0;

    Member m2 = new Member();
    m2.id = "bb";
    m2.password = "2222";
    m2.type = 1;

    Member m3 = new Member();
    m3.id = "cc";
    m3.password = "3333";
    m3.type = 2;

  }

  static class Member {
    String id;
    String password;
    int type;
  }
}
