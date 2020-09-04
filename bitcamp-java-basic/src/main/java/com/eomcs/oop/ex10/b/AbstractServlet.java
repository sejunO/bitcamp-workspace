package com.eomcs.oop.ex10.b;

public class AbstractServlet implements Servlet {

  @Override
  public void init() {}
  @Override
  public void destroy() {}
  @Override
  public String getServletInfo() {
    return null;
  }
  @Override
  public String getServletConfig() {
    return null;
  }
  @Override
  public void service() {
    // TODO Auto-generated method stub
    System.out.println("serv");
  }

}
