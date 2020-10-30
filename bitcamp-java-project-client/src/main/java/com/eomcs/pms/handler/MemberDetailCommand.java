package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberDetailCommand implements Command {

  List<Member> memberList;

  public MemberDetailCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("select no,"
            + " name, email, photo, tel, cdt"
            + " from pms_member"
            + " where no= " + no);
        ResultSet rs = pstmt.executeQuery()){

      if (rs.next()) {

        System.out.printf(" %s\n %s\n %s\n %s\n %s\n",
            rs.getString("name"),rs.getString("email"),rs.getString("photo"),rs.getDate("cdt"),rs.getString("tel"));
      } else {
        System.out.println("그건 없는데용");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
