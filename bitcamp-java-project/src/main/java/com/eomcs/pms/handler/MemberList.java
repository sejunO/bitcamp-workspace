package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;

public class MemberList {

  static final int DEFAULT_LENGTH = 100;

  Member[] list = new Member[DEFAULT_LENGTH]; // list로 이름을 바꾼다.
  int size = 0;

  public MemberList() {
    list = new Member[DEFAULT_LENGTH];
  }

  public MemberList(int initialCapacity) {
    if (initialCapacity <= DEFAULT_LENGTH) {
      list = new Member[DEFAULT_LENGTH];
    } else {
      list = new Member[initialCapacity];
    }
  }


  public void add(Member member) {
    list[size++] = member;
  }

  public Member[] toArray() {
    Member[] arr = new Member[size];
    for (int i = 0; i < size; i++) {
      arr[i] = list[i];
    }
    return arr;
  }
}
