package com.eomcs.design_pattern.observer.test;

public class Test01 {

  public static void main(String[] args) {
    Car seCar = new Car();
    Car junCar = new Car();
    junCar.addObserver(new SafBeltObserver(seCar));
    junCar.addObserver(new EnginOliObserver());

    seCar.addObserver(new SunRoofCloseObserver());
    junCar.start();

    junCar.run();

    junCar.stop();

    seCar.start();
    seCar.run();
    seCar.stop();
  }

}


