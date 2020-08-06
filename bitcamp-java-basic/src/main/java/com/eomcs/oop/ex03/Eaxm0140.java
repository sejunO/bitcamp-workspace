package com.eomcs.oop.ex03;

public class Eaxm0140 {
  static class Car {
    static final int SEDAN = 1;
    static final int TRUCK = 2;
    static int count;
    String model;
    String no;
    int cc;
    int type;

  }
  public static void main(String[] args) {

    Car c1 = new Car();
    Car c2 = new Car();

    c1.model = "티코";
    c1.no = "40-1111";
    c1.cc = 980;
    c1.type = Car.SEDAN;
    Car.count++;
    c2.model = "타이탄";
    c2.no = "50-2222";
    c2.cc = 10000;
    c2.type = Car.TRUCK;
    Car.count++;

    System.out.printf("%s, %s, %d \n", c1.model, c1.no, c1.cc);
    System.out.printf("%s, %s, %d \n", c2.model, c2.no, c2.cc);
    System.out.println(Car.count);
  }
}