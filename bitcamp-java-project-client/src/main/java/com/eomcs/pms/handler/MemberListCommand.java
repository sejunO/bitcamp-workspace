package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.eomcs.pms.domain.Member;

public class MemberListCommand implements Command {

  List<Member> memberList;

  public MemberListCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute() {
    System.out.println("[회원 목록]");


    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("select no, name, email, photo, tel, cdt"
            +" from pms_member"
            + " order by no desc");
        ResultSet rs = pstmt.executeQuery()){

      while (rs.next()) {
        System.out.printf("%s, %s, %s, %s, %s,%s\n",
            rs.getInt("no"),rs.getString("name"),rs.getString("email"),rs.getString("photo"),
            rs.getString("tel"),rs.getDate("cdt"));
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }



}
