package com.eomcs.design_pattern.observer.test;

import java.util.ArrayList;
import java.util.List;

public class Car {
  List<Observer> list = new ArrayList<>();

  boolean belt = true;

  public void addObserver(Observer osv) {
    list.add(osv);
  }

  public void removeObserver(Observer osv) {
    list.remove(osv);
  }

  private void notifyStart() {
    for (Observer osv : list) {
      osv.CarStart();
    }
  }

  private void notifyStop() {

    for (Observer osv : list) {
      osv.CarStop();
    }
  }

  public void start() {
    System.out.println("시동을 건다.");
    notifyStart();

  }

  public void run() {
    System.out.println("달린다.");
  }

  public void stop() {
    System.out.println("시동을 끈다.");
    notifyStop();
  }
}


