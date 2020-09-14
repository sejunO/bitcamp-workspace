package com.eomcs.exception;

public class Exam0610 {
  static class B implements AutoCloseable {

    public void m(int value) throws Exception {
      if (value < 0) {
        throw new Exception("음수입니다!");
      }
      System.out.println(" m호출 성공");
    }
    @Override
    public void close() throws Exception {
      System.out.println(" close 호출 ");
    }
  }

  public static void main(String[] args) throws Exception {

    try (B obj = new B()) {
      System.out.println("try");
      obj.m(-1);
      System.out.println("try 종료");
    } catch (Exception e) {
      System.out.println("예외 발생." + e.getClass().getName());
    }
  }
}
