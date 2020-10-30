package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.eomcs.util.Prompt;

public class ProjectUpdateCommand implements Command {


  @Override
  public void execute() {
    System.out.println("[프로젝트 변경]");
    int no = Prompt.inputInt("번호? ");
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
    String title = null;
    String content = null;
    Date sdt = null;
    Date edt = null;
    String owner = null;
    String members = null;

    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("select title, content, sdt, edt, owner, members"
            + " from pms_project"
            + " where no= " + no);
        ResultSet rs = pstmt.executeQuery()){

      if (rs.next()) {
        title = rs.getString("title");
        content = rs.getString("content");
        sdt = rs.getDate("sdt");
        edt = rs.getDate("edt");
        owner = rs.getString("owner");
        members = rs.getString("members");

      } else {
        System.out.println("그건 없는데용");
        return;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }



    title = Prompt.inputString(
        String.format("프로젝트명(%s)? ", title));
    content = Prompt.inputString(
        String.format("내용(%s)? ", content));
    sdt = Prompt.inputDate(
        String.format("시작일(%s)? ", sdt));
    edt = Prompt.inputDate(
        String.format("종료일(%s)? ", edt));

    while (true) {
      String name = Prompt.inputString(
          String.format("만든이(%s)?(취소: 빈 문자열) ", owner));
      if (name.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return;
      } else if (findByName(names, name) != null) {
        owner = name;
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    StringBuilder newMembers = new StringBuilder();
    while (true) {
      String name = Prompt.inputString(
          String.format("팀원(%s)?(완료: 빈 문자열) ", members));
      if (name.length() == 0) {
        break;
      } else if (findByName(names, name) != null) {
        if (members.length() > 0) {
          newMembers.append(",");
        }
        newMembers.append(name);
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }

    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement(
            "update pms_project set title=?,content=?,sdt=?,edt=?,owner=?,members=?"
                + " where no=?")){

      pstmt.setString(1, title);
      pstmt.setString(2, content);
      pstmt.setDate(3, sdt);
      pstmt.setDate(4, edt);
      pstmt.setString(5, owner);
      pstmt.setString(6, newMembers.toString());
      pstmt.setInt(7, no);


      int count = pstmt.executeUpdate();

      if (count == 0) {
        System.out.println("그건 없는데용");
      } else {
        System.out.println("변경 !");
      }

    } catch (Exception e) {
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
