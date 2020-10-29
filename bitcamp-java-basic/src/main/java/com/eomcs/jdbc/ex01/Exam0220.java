package com.eomcs.jdbc.ex01;

import java.sql.Connection;
import java.sql.DriverManager;

public class Exam0220 {
  public static void main(String[] args) {
    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1112");){

      System.out.println(con.getClass().getName());


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}