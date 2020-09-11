package com.eomcs.pms.handler;

public class SayHelloCommand implements Command{
  @Override
  public void execute() {
    System.out.println("H E L L O !");

  }
}
