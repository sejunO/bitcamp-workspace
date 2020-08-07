package com.eomcs.oop.ex03;

public class Exam0424 {

  static class SmartPhone {
    int volume;
    int bright;
    int contrast;

    public SmartPhone() {

    }
    public SmartPhone(int a) {
      System.out.println("생성");
    }

    public SmartPhone(int volume, int bright, int contrast) {
      this.volume = volume;
      this.bright = bright;
      this.contrast = contrast;
    }
  }
  public static void main(String[] args) {
    SmartPhone obj1 = new SmartPhone();

  }

}