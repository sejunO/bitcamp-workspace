package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.eomcs.pms.domain.Project;

public class ProjectListCommand implements Command {

  List<Project> projectList;

  public ProjectListCommand(List<Project> list) {
    this.projectList = list;
  }

  @Override
  public void execute() {
    System.out.println("[프로젝트 목록]");

    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("select no, title, content, sdt, edt, owner, members"
            +" from pms_project"
            + " order by no desc");
        ResultSet rs = pstmt.executeQuery()){

      while (rs.next()) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
            rs.getInt("no"),rs.getString("title"),rs.getString("content"),rs.getDate("sdt"),
            rs.getDate("edt"),rs.getString("owner"),rs.getString("members"));
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
