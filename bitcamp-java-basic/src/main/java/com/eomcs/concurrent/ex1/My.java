package com.eomcs.concurrent.ex1;

public class My {
  static class MyT extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        System.out.println("===>" + i);
      }
    }
  }

  public static void main(String[] args) {
    new MyT().start();

    for (int i = 0; i < 100; i++) {
      System.out.println(i);
    }
  }
}
