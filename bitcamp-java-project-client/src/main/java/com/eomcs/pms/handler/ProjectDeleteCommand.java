package com.eomcs.pms.handler;

import java.util.Map;
import com.eomcs.pms.dao.ProjectDao;
import com.eomcs.pms.dao.TaskDao;
import com.eomcs.util.Prompt;

public class ProjectDeleteCommand implements Command {
  ProjectDao projectDao;
  TaskDao taskDao;
  public ProjectDeleteCommand(ProjectDao projectDao, TaskDao taskDao) {
    this.projectDao = projectDao;
    this.taskDao = taskDao;
  }
  @Override
  public void execute(Map<String, Object> context) {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");

    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }


    try {
      taskDao.deleteByProjectNo(no);
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
