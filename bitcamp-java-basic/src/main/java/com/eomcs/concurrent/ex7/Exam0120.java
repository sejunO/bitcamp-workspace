// Executors 태스크 프레임워크 - 스레드풀 종료하기
package com.eomcs.concurrent.ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam0120 {

  public static void main(String[] args) {
    ExecutorService es = Executors.newFixedThreadPool(1);

    es.execute(() -> System.out.println("스레드실행"));

    es.shutdown();

    System.out.println("종료");
  }
}

