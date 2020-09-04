package com.eomcs.oop.ex10.b;

public interface Servlet {

  void init();
  void service();
  void destroy();
  String getServletInfo();
  String getServletConfig();
}
