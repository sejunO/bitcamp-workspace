package com.eomcs.oop.ex04;

import java.util.Date;

public class Exam0240 {

  public static void main(String[] args) throws Exception {
    Date d1 = new Date();
    System.out.println(d1.getYear() + 1900);
    System.out.println(d1.getMonth() + 1);
    System.out.println(d1.getDate());

    long millis  = Date.parse("Sat, 12 Aug 1995 13:30:00 GMT");
    System.out.println(millis);

    long currMillis = System.currentTimeMillis();
    java.sql.Date today = new java.sql.Date(currMillis);
  }
}
