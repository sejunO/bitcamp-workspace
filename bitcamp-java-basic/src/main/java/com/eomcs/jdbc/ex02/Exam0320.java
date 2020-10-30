package com.eomcs.jdbc.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam0320 {
  public static void main(String[] args) {
    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("select * from x_board order by board_id desc");
        ResultSet rs = pstmt.executeQuery()){

      while (rs.next()) {
        System.out.printf("%d, %s, %s, %s, %d\n",
            rs.getInt("board_id"),rs.getString("title"),rs.getString("contents"),rs.getDate("created_date"),rs.getInt("view_count"));
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
