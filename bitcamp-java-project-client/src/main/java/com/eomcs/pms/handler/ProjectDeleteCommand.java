package com.eomcs.pms.handler;

import com.eomcs.pms.dao.ProjectDao;
import com.eomcs.util.Prompt;

public class ProjectDeleteCommand implements Command {
  ProjectDao projectDao;
  public ProjectDeleteCommand(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }
  @Override
  public void execute() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");

    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }
    try {
      if (projectDao.delete(no) == 0) {
        System.out.println("그건 없는데용");
        return;
      }
      System.out.println("프로젝트 삭제 완료");
    } catch (Exception e) {
      System.out.println("프로젝트 삭제 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
