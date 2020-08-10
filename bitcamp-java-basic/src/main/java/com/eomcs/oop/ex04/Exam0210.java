package com.eomcs.oop.ex04;

import java.util.Calendar;
import java.util.Date;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    String s1 = new String("Hello");
    String s2 = new String("ABC가각");

    char c1 = s1.charAt(1);
    char c2 = s2.charAt(1);
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(s1.charAt(2));

    System.out.println(s1.compareTo(s2));

    System.out.println(s1.contains("ko"));
    System.out.println(s2.contains("ko"));
    System.out.println(s1.equals("Hello"));

    byte[] bytes = s2.getBytes();

    for (byte b : bytes) {
      System.out.println(Integer.toHexString(b & 0xff));
    }

    bytes = s2.getBytes("MS949");

    for (byte b : bytes) {
      System.out.println(Integer.toHexString(b & 0xff));
    }


    String s3 = String.format("%s", "오세준");
    System.out.println(s3);

    String s4 = String.join(",", "세준", "임꺽정");
    System.out.println(s4);

    String s5 = String.valueOf(true);
    String s6 = String.valueOf(100);
    String s7 = String.valueOf(3.14f);

    System.out.printf("%s %s %s",s5, s6, s7);

    System.out.println("---------------------------------");
    System.out.println(Math.ceil(-3.28));
    System.out.println(Math.floor(-3.28));
    System.out.println(Math.pow(2, 7));
    System.out.println(Math.round(3.5));

    Date d1 = new Date();

    System.out.println(d1.getYear() + 1900);
    System.out.println(d1.getMonth() );
    System.out.println(d1.getDate() );
    System.out.println(d1.getDay() );

    long millis = Date.parse("Sat, 12 Aug 1995 13:30:25 GMT");
    System.out.println(millis);

    java.sql.Date d2 = java.sql.Date.valueOf("2020-08-10");
    System.out.println(d2.getYear() + 1900);
    System.out.println(d2.getMonth() );
    System.out.println(d2.getDate() );
    System.out.println(d2.getDay() );

    long curr = System.currentTimeMillis();
    Date d3 = new Date(curr);
    System.out.println(d3.getYear());

    Calendar cal = Calendar.getInstance();
    System.out.println(cal.get(1));
    System.out.println(cal.get(2));
    System.out.println(cal.get(5));
    System.out.println(cal.get(7));

    Integer i1 = new Integer(100);

    System.out.println(i1.toString());
    Integer i3 = Integer.valueOf(100);
    Integer i4 = Integer.valueOf(100);
    System.out.println(i3 == i4);




  }
}