package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.dao.ProjectDao;
import com.eomcs.pms.dao.TaskDao;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.domain.Task;
import com.eomcs.util.Prompt;

public class TaskUpdateCommand implements Command {

  TaskDao taskDao;
  ProjectDao projectDao;
  MemberDao memberDao;

  public TaskUpdateCommand(TaskDao taskDao, ProjectDao projectDao, MemberDao memberDao) {
    this.taskDao = taskDao;
    this.projectDao = projectDao;
    this.memberDao = memberDao;
  }


  @Override
  public void execute(Map<String, Object> context) {
    System.out.println("[작업 변경]");
    int no = Prompt.inputInt("번호? ");
    try {
      Task task = taskDao.findByNo(no);
      task.setNo(no);
      try (Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb?user=study&password=1111")) {

        System.out.printf("현재 프로젝트: %s\n", task.getProjectTitle());
        List<Project> projectList = projectDao.findAll();
        ArrayList<Integer> noList = new ArrayList<>();
        for (Project project : projectList) {
          System.out.printf("  %d, %s\n",
              project.getNo(),
              project.getTitle());
          noList.add(project.getNo());
        }

        if (noList.size() == 0) {
          System.out.println("프로젝트가 없습니다!");
          return;
        }

        // 사용자로부터 프로젝트 번호를 입력 받는다.
        while (true) {
          int projectNo = Prompt.inputInt("변경할 프로젝트 번호?(0: 취소) ");
          if (projectNo == 0) {
            System.out.println("작업 변경을 취소합니다.");
            return;
          } else if (noList.contains(projectNo)) {
            task.setProjectNo(projectNo);
            break;
          }
          System.out.println("프로젝트 번호가 맞지 않습니다.");
        }
      }  catch (Exception e) {
        System.out.println("작업 변경 중 오류 발생!");
        e.printStackTrace();
      }

      // 작업 정보 변경
      task.setContent(Prompt.inputString(String.format(
          "내용(%s)? ", task.getContent())));
      task.setDeadline(Prompt.inputDate(String.format(
          "마감일(%s)? ", task.getDeadline())));

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
      task.setStatus(Prompt.inputInt(String.format(
          "상태(%s)?\n0: 신규\n1: 진행중\n2: 완료\n> ", stateLabel)));

      // 작업을 수행할 담당자를 결정한다.
      List<Member> members = memberDao.findByProjectNo(task.getProjectNo());

      // 멤버 번호를 보관할 컬렉션
      ArrayList<Integer> noList = new ArrayList<>();

      System.out.println("멤버들:");
      for (Member member : members) {
        System.out.printf("  %d, %s\n",
            member.getNo(),
            member.getName());
        noList.add(member.getNo());
      }

      if (noList.size() == 0) {
        System.out.println("멤버가 없습니다!");
        return;
      }

      // 사용자로부터 멤버 번호를 입력 받는다.
      while (true) {
        int memberNo = Prompt.inputInt("변경할 멤버 번호?(0: 취소) ");
        if (memberNo == 0) {
          System.out.println("작업 변경을 취소합니다.");
          return;
        } else if (noList.contains(memberNo)) {
          Member member = new Member();
          member.setNo(memberNo);
          task.setOwner(member);
          break;
        }
        System.out.println("멤버 번호가 맞지 않습니다.");
      }

      String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
      if (!response.equalsIgnoreCase("y")) {
        System.out.println("작업 변경을 취소하였습니다.");
        return;
      }

      if (taskDao.update(task) == 1) {
        System.out.println("변경 완료");
      } else {
        System.out.println("변경 실패 ");
      }

    } catch (Exception e) {
      System.out.println("작업 등록 중 오류");
    }
  }
}
