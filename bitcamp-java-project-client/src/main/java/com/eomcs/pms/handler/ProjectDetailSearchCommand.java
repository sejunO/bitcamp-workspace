package com.eomcs.pms.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.dao.ProjectDao;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectDetailSearchCommand implements Command {
  ProjectDao projectDao;

  public ProjectDetailSearchCommand(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  @Override
  public void execute(Map<String,Object> context) {
    System.out.println("[프로젝트 검색]");

    try {
      Map<String,Object> keywords = new HashMap<>();
      String title = Prompt.inputString("제목 ");
      String owner = Prompt.inputString("관리자 ");
      String member = Prompt.inputString("팀원 ");

      if (title.length() > 0) {
        keywords.put("title", title);
      }

      if (owner.length() > 0) {
        keywords.put("owner", owner);
      }

      if (member.length() > 0) {
        keywords.put("member", member);
      }

      List<Project> list = projectDao.findByDetailKeyword(keywords);
      System.out.println("번호, 프로젝트명, 시작일 ~ 종료일, 관리자, 팀원");

      for (Project project : list) {
        StringBuilder members = new StringBuilder();
        for (Member m : project.getMembers()) {
          if (members.length() > 0) {
            members.append(",");
          }
          members.append(m.getName());
        }

        System.out.printf("%d, %s, %s ~ %s, %s, [%s]\n",
            project.getNo(),
            project.getTitle(),
            project.getStartDate(),
            project.getEndDate(),
            project.getOwner().getName(),
            members.toString());
      }
    } catch (Exception e) {
      System.out.println("프로젝트 목록 조회 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
