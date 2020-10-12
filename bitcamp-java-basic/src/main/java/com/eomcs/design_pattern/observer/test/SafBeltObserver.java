package com.eomcs.design_pattern.observer.test;

public class SafBeltObserver extends AbstractObserver {
  Car car;

  public SafBeltObserver(Car car) {
    this.car = car;
  }

  @Override
  public void CarStart() {
    if (car.belt)
      System.out.println("벨트를 했군요");
  }

  @Override
  public void CarStop() {
    // TODO Auto-generated method stub

  }
}
