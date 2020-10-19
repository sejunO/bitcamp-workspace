// Executors 태스크 프레임워크 - 스레드풀 만들기 : 가변크기 스레드풀
package com.eomcs.concurrent.ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam0220 {

  public static void main(String[] args) throws Exception {
    class X implements Runnable {
      int a;
      public X(int a) {
        this.a = a;
      }
      @Override
      public void run()  {
        System.out.printf(" %s 스레드 실행 \n", Thread.currentThread().getName());
        try {
          Thread.sleep(this.a);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        System.out.println("스레드 종");
      }
    }

    ExecutorService es = Executors.newCachedThreadPool();

    es.execute(new X(3000));
    es.execute(new X(4000));
  }
}

