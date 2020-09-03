package com.eomcs.oop.ex10.d;

public abstract class Student {

  public void introduce() {

    greet();

    say();

    fighting();
  }

  public abstract void greet();
  public abstract void say();
  public abstract void fighting();

}
