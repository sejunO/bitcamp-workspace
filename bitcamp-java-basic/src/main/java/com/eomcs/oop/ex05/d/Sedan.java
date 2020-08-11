package com.eomcs.oop.ex05.d;

public class Sedan extends Car {
  boolean sunroof;
  boolean auto;

  public Sedan(String model, String maker, int capacity,
      boolean sunroof, boolean auto) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
    this.sunroof = sunroof;
    this.auto = auto;
  }

}
