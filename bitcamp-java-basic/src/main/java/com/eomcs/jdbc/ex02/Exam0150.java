package com.eomcs.jdbc.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Exam0150 {
  public static void main(String[] args) {
    String no = null;
    String title = null;
    String content = null;
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("번호 :");
      no = sc.nextLine();

    }


    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from x_board where board_id="+ no)){

      stmt.executeUpdate("delete from x_board_file where board_id="+no);
      stmt.executeUpdate("delete from x_board where board_id="+no);




    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
