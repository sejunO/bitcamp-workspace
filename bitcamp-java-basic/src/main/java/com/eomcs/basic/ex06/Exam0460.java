package com.eomcs.basic.ex06;

import java.util.ArrayList;

public class Exam0460 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ArrayList list = new ArrayList();
    list.add("홍길동");
    list.add(3.14f);
    list.add(true);

    for (Object value : list) {
      System.out.println(value);
    }
  }

}
