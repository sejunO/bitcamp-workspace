package com.eomcs.pms.handler;

import com.eomcs.pms.dao.TaskDao;
import com.eomcs.pms.domain.Task;
import com.eomcs.util.Prompt;

public class TaskDetailCommand implements Command {
  TaskDao taskDao;

  public TaskDetailCommand(TaskDao taskDao) {
    this.taskDao = taskDao;
  }
  @Override
  public void execute() {
    System.out.println("[작업 상세보기]");
    int no = Prompt.inputInt("번호? ");

    try {
      Task task = taskDao.findByNo(no);
      System.out.printf("내용: %s\n", task.getContent());
      System.out.printf("마감일: %s\n", task.getDeadline());
      System.out.printf("상태: %s\n", task.getStatus());
      System.out.printf("담당자: %s\n", task.getOwner().getName());

    }
    catch (Exception e) {
      System.out.println("작업 조회 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
