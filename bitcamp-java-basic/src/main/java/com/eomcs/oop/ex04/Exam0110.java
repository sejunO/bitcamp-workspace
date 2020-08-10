package com.eomcs.oop.ex04;

import java.util.Calendar;
import java.util.Date;

public class Exam0110 {

  public static void main(String[] args) throws Exception {

    String s1 = new String();
    System.out.println("=>" + s1);

    String s2 = new String("H e l l o !");
    System.out.println("=>" + s2);

    char[] chars = new char[] {'H', 'e', 'l', 'l', 'o', '!'};
    String s3 = new String(chars);
    System.out.println("=>" + s3);

    byte[] bytes = new byte[] {
        0x41, 0x42, (byte)0xEA, (byte)0xB0, (byte)0x80, (byte)0xEA, (byte)0xB0, (byte)0x81};

    String s4 = new String(bytes, "UTF-8");
    System.out.println(s4);

    byte[] bytes2 = new byte[] {
        0x41, 0x42, (byte)0xB0, (byte)0xA1, (byte)0xB0, (byte)0xA2,};

    String s5 = new String(bytes2, "MS949");
    System.out.println(s5);

    Date d1 = new Date();
    System.out.println(d1);

    Date d2 = new Date(1000000000);
    System.out.println(d2);


    Calendar c1 = Calendar.getInstance();
    System.out.println(c1);

    Car car1 = new Car();
    Car car2 = new Car();
    System.out.println(car1 == car2);
    car1.model = "티코";
    car1.cc = 980;
    car2.model = "sonata";
    car2.cc = 1980;

    Car2 car3 = Car2.getInstance();
    Car2 car4 = Car2.getInstance();
    System.out.println(car3 == car4);

    car3.cc = 100;
    System.out.println(car4.cc);

  }

}

class Car {
  String model;
  int cc;
}

class Car2 {
  String model;
  static Car2 obj;
  int cc;

  private Car2() {

  }

  static Car2 getInstance() {
    if (obj == null) {
      obj = new Car2();
    }
    return obj;
  }
}


