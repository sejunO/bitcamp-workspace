package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.eomcs.util.Prompt;

public class ProjectDetailCommand implements Command {

  @Override
  public void execute() {
    System.out.println("[프로젝트 상세보기]");
    int no = Prompt.inputInt("번호? ");
    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("select no, title, content, sdt, edt, owner, members"
            + " from pms_project"
            + " where no= " + no);
        ResultSet rs = pstmt.executeQuery()){

      if (rs.next()) {
        System.out.printf(" %d\n %s\n %s\n %s\n %s\n %s\n %s\n",
            rs.getInt("no"),rs.getString("title"),rs.getString("content"),
            rs.getDate("sdt"),rs.getDate("edt"),rs.getString("owner"),rs.getString("members"));
      } else {
        System.out.println("그건 없는데용");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
