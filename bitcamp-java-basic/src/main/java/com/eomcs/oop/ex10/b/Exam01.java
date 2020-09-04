package com.eomcs.oop.ex10.b;

public class Exam01 extends AbstractServlet {



  public static void main(String[] args) {
    AbstractServlet a = new AbstractServlet();
    a.service();
    Servlet b = new AbstractServlet();
    b.service();

  }
}
