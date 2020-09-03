package com.eomcs.oop.ex10.d;

public class Exam01 {
  public static void main(String[] args) {

    Student oh = new Oh();
    Student hong = new Hong();

    hi(oh);
    System.out.println("-_-___--_-___---_");
    hi(hong);
  }

  private static void hi(Student student) {
    student.introduce();
  }
}
