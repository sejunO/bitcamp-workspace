package com.eomcs.oop.ex12;

public class Exam0140 {
  static interface Player {
    void play();
  }

  static void testPlayer(Player p) {
    p.play();  }

  public static void main(String[] args) {


    testPlayer(new Player() {
      @Override
      public void play() {
        System.out.println("p l a y !");
      }
    });

  }
}
