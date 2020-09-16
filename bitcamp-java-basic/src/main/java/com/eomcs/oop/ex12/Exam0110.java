package com.eomcs.oop.ex12;

public class Exam0110 {
  interface Player {
    void play();
  }
  public static void main(String[] args) {

    Player p = () -> {
      System.out.println("익명클래스");
    };
    p.play();
  }
}
