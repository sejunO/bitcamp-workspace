package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Prompt;

public class ProjectHandler {

	ArrayList<Project> projectList = new ArrayList<>();
	MemberHandler memberHandler;

  public ProjectHandler(MemberHandler memberHandler) {
    this.memberHandler = memberHandler;
  }

  public void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();
    project.setNo(Prompt.inputInt("번호? "));
    project.setTitle(Prompt.inputString("프로젝트명? "));
    project.setContent(Prompt.inputString("내용? "));
    project.setStartDate(Prompt.inputDate("시작일? "));
    project.setEndDate(Prompt.inputDate("종료일? "));

    while (true) {
      String name = Prompt.inputString("만든이?(취소: 빈 문자열) ");

      if (name.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return;
      } else if (memberHandler.findByName(name) != null) {
        project.setOwner(name);
        break;
      }

      System.out.println("등록된 회원이 아닙니다.");
    }

    StringBuilder members = new StringBuilder();
    while (true) {
      String name = Prompt.inputString("팀원?(완료: 빈 문자열) ");

      if (name.length() == 0) {
        break;
      } else if (memberHandler.findByName(name) != null) {
        if (members.length() > 0) {
          members.append(",");
        }
        members.append(name);
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }
    project.setMembers(members.toString());

    projectList.add(project);
  }
  
  public void detail() {
	  System.out.println("프로젝트 조회");
	  int no = Prompt.inputInt("번호? ");
	  Project project = findByNo(no);
	  if (project == null) {
		  System.out.println("해당 번호의 회원이 없습니다.");
	  } else {
		  System.out.printf("이메일: %s", project.getTitle());
		  System.out.printf("내용: %s", project.getContent());
		  System.out.printf("시작일: %s", project.getStartDate());
		  System.out.printf("종료일: %s", project.getEndDate());
		  System.out.printf("팀장: %s", project.getOwner());
		  System.out.printf("팀원: %s", project.getMembers());
	  }
  }
  private Project findByNo(int no) {
	  for (int i = 0; i < projectList.size(); i++) {
		  Project project = projectList.get(i);
		  if (project.getNo() == no) {
			  return project;
		  }
	  }
	  return null;
  }

  public void list() {
    System.out.println("[프로젝트 목록]");
    Project[] projects = projectList.toArray(new Project[] {});
    for (Project project : projects) {
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
