package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.service.ProjectService;
import com.eomcs.util.Prompt;

public class ProjectDetailCommand implements Command {

  ProjectService projectService;

  public ProjectDetailCommand(ProjectService projectService) {
    this.projectService = projectService;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in, Map<String,Object> context) {
    try {
      out.println("[프로젝트 상세보기]");
      int no = Prompt.inputInt("번호? ", out, in);
      Project project = projectService.get(no);

      if (project == null) {
        out.println("해당 번호의 프로젝트가 없습니다.");
        return;
      }

      out.printf("프로젝트명: %s\n", project.getTitle());
      out.printf("내용: %s\n", project.getContent());
      out.printf("기간: %s ~ %s\n", project.getStartDate(), project.getEndDate());
      out.printf("만든이: %s\n", project.getOwner());
      out.printf("팀원: %s\n", project.getMembers());

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
