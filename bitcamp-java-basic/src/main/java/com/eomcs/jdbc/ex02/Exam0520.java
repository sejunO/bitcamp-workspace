package com.eomcs.jdbc.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam0520 {
  public static void main(String[] args) {
    String title = null;
    String contents = null;
    int boardId = 0;
    ArrayList<String> files = new ArrayList<>();
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("제목:  ");
      title = sc.nextLine();
      System.out.print("내용:  ");
      contents = sc.nextLine();

      while (true) {
        System.out.printf("파일입력 ");
        String fileName = sc.nextLine();
        if (fileName.length()==0) {
          break;
        }
        files.add(fileName);

      }
    }



    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");

        PreparedStatement boardStmt  = con.prepareStatement(
            "insert into x_board(title,contents) values(? ,?)", Statement.RETURN_GENERATED_KEYS );

        PreparedStatement fileStmt  = con.prepareStatement(
            "insert into x_board_file(file_path,board_id) values(? ,?)");
        ) {
      
      con.setAutoCommit(false);
      boardStmt.setString(1, title);
      boardStmt.setString(2, contents);
      int count = boardStmt.executeUpdate();
      System.out.println(count);

      try (ResultSet keyRs = boardStmt.getGeneratedKeys()) {
        keyRs.next();
        boardId = keyRs.getInt(1);
      }
      count = 0;
      for (String fileName : files) {
        fileStmt.setString(1, fileName);
        fileStmt.setInt(2, boardId);
        fileStmt.executeUpdate();
        count++;
      }
      System.out.println(count);
      
      con.commit();
    } catch (Exception e) {
      System.out.println("오류");
    }
  }
}
