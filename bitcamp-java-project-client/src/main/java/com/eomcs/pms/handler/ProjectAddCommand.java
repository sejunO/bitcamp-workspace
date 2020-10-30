package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectAddCommand implements Command {


  @Override
  public void execute() {
    System.out.println("[프로젝트 등록]");
    ArrayList<String> names = new ArrayList<>();
    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("select name from pms_member");
        ResultSet rs = pstmt.executeQuery()){

      while (rs.next()) {
        names.add(rs.getString("name"));
      }
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }


    Project project = new Project();
    project.setTitle(Prompt.inputString("프로젝트명? "));
    project.setContent(Prompt.inputString("내용? "));
    project.setStartDate(Prompt.inputDate("시작일? "));
    project.setEndDate(Prompt.inputDate("종료일? "));

    while (true) {
      String name = Prompt.inputString("만든이?(취소: 빈 문자열) ");

      if (name.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return;
      } else if (findByName(names, name) != null) {
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
      } else if (findByName(names, name) != null) {
        if (members.length() > 0) {
          members.append(",");
        }
        members.append(name);
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }
    project.setMembers(members.toString());


    try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt  = con.prepareStatement(
            "insert into pms_project(title,content,sdt,edt,owner,members) values(?,?,?,?,?,?)");
        ) {

      pstmt.setString(1, project.getTitle());
      pstmt.setString(2, project.getContent());
      pstmt.setDate(3, project.getStartDate());
      pstmt.setDate(4, project.getEndDate());
      pstmt.setString(5, project.getOwner());
      pstmt.setString(6, project.getMembers());

      pstmt.executeUpdate();
      System.out.println("project 등록");

    } catch (Exception e) {
      System.out.println("member 등록 중 오류");
      e.printStackTrace();
    }
  }

  private String findByName(ArrayList<String> names, String name){
    for (int i = 0; i < names.size(); i++) {
      if(name.equalsIgnoreCase(names.get(i))) {
        return name;
      }
    }
    return null;
  }
}
