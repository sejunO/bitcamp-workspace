package com.eomcs.jdbc.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Exam0130 {
  public static void main(String[] args) {
    String no = null;
    String title = null;
    String content = null;
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("번호 :");
      no = sc.nextLine();
      System.out.print("제목 :");
      title = sc.nextLine();
      System.out.print("내용? :");
      content = sc.nextLine();
    }


    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from x_board where board_id="+ no)){

      String sql = String.format("update x_board set title='%s',contents='%s' where board_id=%s" , title, content, no);
      stmt.executeUpdate(sql);
      System.out.println("번호, 제목, 날짜, 조회수");
      if (rs.next()) {
        System.out.printf("%d, %s, %s, %d\n",
            rs.getInt("board_id"),rs.getString("title"),rs.getDate("created_date"),rs.getInt("view_count"));
      } else {
        System.out.println("그건 없는데용");
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
