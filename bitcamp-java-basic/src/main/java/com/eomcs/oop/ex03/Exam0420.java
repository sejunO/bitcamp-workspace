package com.eomcs.oop.ex03;

public class Exam0420 {

  static class SmartPhone {
    int volume;
    int bright;
    int contrast;

    public SmartPhone() {
      System.out.println("생성");
    }

  }
  public static void main(String[] args) {
    SmartPhone obj1 = new SmartPhone();


    System.out.println(obj1.volume);
    System.out.println(obj1.bright);
    System.out.println(obj1.contrast);
  }

}
