package com.eomcs.pms.listener;

import com.eomcs.context.AbstractApplicationContextListener;

public class AppInitListener extends AbstractApplicationContextListener {

  @Override
  public void contextInitialized() {
    System.out.println("프로젝트 관리 시스템에 오신 걸 환영합니다!");
  }

  @Override
  public void contextDestroyed() {
    System.out.println("프로젝트 관리 시스템을 종료합니다.");
  }

}
