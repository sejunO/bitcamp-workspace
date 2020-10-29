package com.eomcs.jdbc.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam0350 {
  public static void main(String[] args) {
    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from x_board")){

      stmt.executeUpdate(
          "update x_board set view_count = view_count + 20"
              + " where board_id = 4");

      while (rs.next()) {
        System.out.printf("%d, %s, %s, %s, %d\n",
            rs.getInt("board_id"),rs.getString("title"),rs.getString("contents"),rs.getDate("created_date"),rs.getInt("view_count"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}