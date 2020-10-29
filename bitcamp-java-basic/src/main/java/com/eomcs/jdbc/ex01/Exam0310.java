package com.eomcs.jdbc.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam0310 {
  public static void main(String[] args) {
    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();){

      int count = stmt.executeUpdate(
          "insert into x_board(title,contents) values('제목10','내용')");

      System.out.println(count);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}