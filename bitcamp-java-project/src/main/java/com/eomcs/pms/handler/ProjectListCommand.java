package com.eomcs.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.pms.domain.Project;

public class ProjectListCommand implements Command {

  List<Project> projectList;   

  public ProjectListCommand(List<Project> projectList) {
    this.projectList = projectList;
  }

  @Override
  public void execute() {
    System.out.println("[프로젝트 목록]");
    Iterator<Project> iterator = projectList.iterator();

    while (iterator.hasNext()) {
      Project project = iterator.next();
      for (int i = 0; i < projectList.size(); i++) {
        System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
            project.getNo(),
            project.getTitle(),
            project.getStartDate(),
            project.getEndDate(),
            project.getOwner(),
            project.getMembers());
      }
    }
  }
}
