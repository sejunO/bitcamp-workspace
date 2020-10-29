package com.eomcs.jdbc.ex01;

import java.sql.Connection;
import java.sql.DriverManager;

public class Exam0230 {
  public static void main(String[] args) {
    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");){

      System.out.println(con.getClass().getName());


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}