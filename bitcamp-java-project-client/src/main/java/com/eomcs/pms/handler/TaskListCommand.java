package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.dao.TaskDao;
import com.eomcs.pms.domain.Task;

public class TaskListCommand implements Command {
  TaskDao taskDao;

  public TaskListCommand(TaskDao taskDao) {
    this.taskDao = taskDao;
  }
  @Override
  public void execute() {
    System.out.println("[작업 목록]");

    try {
      List<Task> taskList = taskDao.findAll();

      for (Task task : taskList) {
        String stateLabel = null;
        switch (task.getStatus()) {
          case 1:
            stateLabel = "진행중";
            break;
          case 2:
            stateLabel = "완료";
            break;
          default:
            stateLabel = "신규";
        }
        System.out.printf("%d, %s, %s, %s, %s\n",
            task.getNo(),
            task.getContent(),
            task.getDeadline(),
            stateLabel,
            task.getOwner().getName());
      }



    } catch (Exception e) {
      System.out.println("작업 목록 조회 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
