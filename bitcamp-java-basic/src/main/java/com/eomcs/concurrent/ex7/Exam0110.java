// Executors 태스크 프레임워크 - 스레드풀 만들고 사용하기
package com.eomcs.concurrent.ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam0110 {

  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(3);
    class X implements Runnable {
      @Override
      public void run() {
        System.out.printf("%s 스레드\n", Thread.currentThread().getName());
      }
    }
    threadPool.execute(new X());
    threadPool.execute(new X());

    System.out.println("종료");
  }
}

