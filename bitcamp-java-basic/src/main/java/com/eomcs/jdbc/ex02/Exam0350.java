package com.eomcs.jdbc.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam0350 {
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
        PreparedStatement pstmt = con.prepareStatement("delete from x_board_file where board_id= ?");
        ResultSet rs = pstmt.executeQuery("select * from x_board where board_id="+ no)){

      pstmt.setString(1, no);
      pstmt.executeUpdate("delete from x_board where board_id="+no);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
