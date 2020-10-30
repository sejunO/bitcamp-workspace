package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.util.Prompt;

public class ProjectDeleteCommand implements Command {


  @Override
  public void execute() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");
    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("delete from pms_project where no=" +no);
        ){

      int count = pstmt.executeUpdate();

      if (count == 0) {
        System.out.println("그건 없는데용");
      } else {
        System.out.println("삭제!");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("프로젝트를 삭제하였습니다.");
  }


}
