package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;
import com.eomcs.pms.service.ProjectService;
import com.eomcs.util.Prompt;

public class ProjectDeleteCommand implements Command {

  ProjectService projectService;

  public ProjectDeleteCommand(ProjectService projectService) {
    this.projectService = projectService;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in, Map<String,Object> context) {
    try {
      out.println("[프로젝트 삭제]");
      int no = Prompt.inputInt("번호? ", out, in);


      if (projectService.get(no) == null) {
        out.println("해당 번호의 프로젝트가 없습니다.");
        return;
      }

      String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("프로젝트 삭제를 취소하였습니다.");
        return;
      }

      projectService.delete(no);
      out.println("프로젝트를 삭제하였습니다.");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

}
