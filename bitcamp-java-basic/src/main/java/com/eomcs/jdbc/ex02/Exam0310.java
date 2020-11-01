package com.eomcs.jdbc.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam0310 {
  public static void main(String[] args) throws Exception {
    String title = null;
    String contents = null;
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("제목:  ");
      title = sc.nextLine();
      System.out.print("내용:  ");
      contents = sc.nextLine();
      System.out.print("입력하시겠습니까:  ");
      String input = sc.nextLine();

      if (!input.equalsIgnoreCase("y") && input.length() != 0) {
        return;
      }

    }

    try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt  = con.prepareStatement("insert into x_board(title,contents) values(? ,?)");
        ) {

      pstmt.setString(1, title);
      pstmt.setString(2, contents);
      pstmt.executeUpdate();

    }
  }
}