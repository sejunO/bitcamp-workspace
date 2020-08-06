package com.eomcs.oop.ex03;

public class Exam0410 {

  static class SmartPhone {
    int volume;
    int bright;
    int contrast;

    void playMusic() {

    }

  }
  public static void main(String[] args) {
    SmartPhone obj1 = new SmartPhone();
    obj1.playMusic();

    System.out.println(obj1.volume);
    System.out.println(obj1.bright);
    System.out.println(obj1.contrast);
  }

}
