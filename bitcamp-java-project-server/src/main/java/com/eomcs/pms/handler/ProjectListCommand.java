package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.service.ProjectService;

public class ProjectListCommand implements Command {

  ProjectService projectService;

  public ProjectListCommand(ProjectService projectService) {
    this.projectService = projectService;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in, Map<String,Object> context) {
    try {
      out.println("[프로젝트 목록]");
      List<Project> projectList = projectService.list();
      Iterator<Project> iterator = projectList.iterator();

      while (iterator.hasNext()) {
        Project project = iterator.next();
        out.printf("%d, %s, %s, %s, %s, [%s]\n",
            project.getNo(),
            project.getTitle(),
            project.getStartDate(),
            project.getEndDate(),
            project.getOwner(),
            project.getMembers());
      }
    } catch (Exception e) {
      out.println("프로젝트 목록 생성 중 오류");
    }
  }
}
