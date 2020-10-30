package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardListCommand implements Command {


  @Override
  public void execute() {
    System.out.println("[게시물 목록]");

    // 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
    // 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.

    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("select no, title, writer, cdt, vw_cnt"
            +" from pms_board"
            + " order by no desc");
        ResultSet rs = pstmt.executeQuery()){

      while (rs.next()) {
        System.out.printf("%d, %s, %s, %s, %d\n",
            rs.getInt("no"),rs.getString("title"),rs.getString("writer"),rs.getDate("cdt"),rs.getInt("vw_cnt"));
      }


    } catch (Exception e) {
      e.printStackTrace();
    }


  }

}
