package com.eomcs.jdbc.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam0321 {
  public static void main(String[] args) {
    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from x_board order by board_id desc")){
      boolean isReceived = rs.next();

      if (isReceived) {
        System.out.printf("%d, %s, %s, %s, %d\n",
            rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5));
      } else {
        System.out.println("없음.");
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
