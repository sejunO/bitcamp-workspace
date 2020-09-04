package com.eomcs.oop.ex09.e;

import com.eomcs.oop.ex09.e.project1.FirstComputer;
import com.eomcs.oop.ex09.e.project2.SecondComputer;
import com.eomcs.oop.ex09.e.project4.NewComputer1;

public class User {
  public static void main(String[] args) {
    FirstComputer c1 = new FirstComputer();
    c1.compute();
    Computer c2 = new SecondComputer();
    c2.compute();
    Computer c3 = new NewComputer1();
    c3.touch();
  }

  static void play() {

  }
}
