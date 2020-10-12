package com.eomcs.design_pattern.observer.test;

public class SunRoofCloseObserver extends AbstractObserver {
  @Override
  public void CarStart() {
    // TODO Auto-generated method stub

  }

  @Override
  public void CarStop() {
    System.out.println("선루프 닫을게요");
  }
}
