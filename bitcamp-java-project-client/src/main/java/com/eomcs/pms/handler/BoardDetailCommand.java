package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.eomcs.util.Prompt;

public class BoardDetailCommand implements Command {


  @Override
  public void execute() {
    System.out.println("[게시물 상세보기]");
    int no = Prompt.inputInt("번호? ");

    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("select no, title, content, writer, cdt, vw_cnt"
            + " from pms_board"
            + " where no= " + no);
        PreparedStatement pstmt2 = con.prepareStatement("update pms_board set vw_cnt = vw_cnt + 1"
            + " where no= " + no);
        ResultSet rs = pstmt.executeQuery()){

      if (rs.next()) {

        System.out.printf(" %s\n %s\n %s\n %s\n %d\n",
            rs.getString("title"),rs.getString("content"),rs.getString("writer"),rs.getDate("cdt"),rs.getInt("vw_cnt"));
        pstmt2.executeUpdate();
      } else {
        System.out.println("그건 없는데용");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}


