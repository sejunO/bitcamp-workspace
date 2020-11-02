package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectAddCommand implements Command {

  MemberListCommand memberListCommand;

  public ProjectAddCommand(MemberListCommand memberListCommand) {
    this.memberListCommand = memberListCommand;
  }

  @Override
  public void execute() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();
    project.setTitle(Prompt.inputString("프로젝트명? "));
    project.setContent(Prompt.inputString("내용? "));
    project.setStartDate(Prompt.inputDate("시작일? "));
    project.setEndDate(Prompt.inputDate("종료일? "));

    while (true) {
      String name = Prompt.inputString("관리자?(취소: 빈 문자열) ");

      if (name.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return;
      } else {
        Member member = memberListCommand.findByName(name);
        if (member == null) {
          System.out.println("등록된 회원이 아닙니다");
          continue;
        }
        project.setOwner(member);
        break;
      }
    }

    List<Member> members = new ArrayList<>();
    while (true) {
      String name = Prompt.inputString("팀원?(완료: 빈 문자열) ");

      if (name.length() == 0) {
        break;
      } else {
        Member member = memberListCommand.findByName(name);
        if (member == null) {
          System.out.println("등록된 회원이 아닙니다.");
          continue;
        }
        members.add(member);

      }
    }

    project.setMembers(members);

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into pms_project(title,content,sdt,edt,owner)"
                + " values(?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, project.getTitle());
      stmt.setString(2, project.getContent());
      stmt.setDate(3, project.getStartDate());
      stmt.setDate(4, project.getEndDate());
      stmt.setInt(5, project.getOwner().getNo());
      stmt.executeUpdate();

      try (ResultSet keyRs = stmt.getGeneratedKeys()) {
        keyRs.next();
        project.setNo(keyRs.getInt(1));
      }

      try (PreparedStatement stmt2 = con.prepareStatement(
          "insert into pms_member_project(member_no,project_no) values(?,?)")) {
        for (Member member : project.getMembers()) {
          stmt2.setInt(1, member.getNo());
          stmt2.setInt(2, project.getNo());
        }

        stmt2.executeUpdate();
      }

      System.out.println("프로젝트를 등록하였습니다.");

    } catch (Exception e) {
      System.out.println("프로젝트 등록 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
