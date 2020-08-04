package com.eomcs.basic.ex07;

public class Exam0310 {

  static class Person {
    String name;
    int age;
    boolean working;
  }

  public static void main(String[] args) {

    int a =200;

    m1(a);

    int[] arr = new int[3];
    for (int i = 0; i < arr.length; i++) {
      arr[i] += 100 ;
    }
    m2(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }

    Person p = new Person();
    m3(p);
    System.out.printf("%s %d %b\n", p.name, p.age, p.working);
  }

  static void m1(int a) {
    a = 100;
  }

  static void m2(int[] a) {
    a[0] = 1000;
  }
  static void m3(Person p) {
    p.name = "Steven";
  }
}
