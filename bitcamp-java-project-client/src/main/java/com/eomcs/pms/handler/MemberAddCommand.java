package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberAddCommand implements Command {


  @Override
  public void execute() {
    System.out.println("[회원 등록]");

    Member member = new Member();
    member.setName(Prompt.inputString("이름? "));
    member.setEmail(Prompt.inputString("이메일? "));
    member.setPassword(Prompt.inputString("암호? "));
    member.setPhoto(Prompt.inputString("사진? "));
    member.setTel(Prompt.inputString("전화? "));
    member.setRegisteredDate(new java.sql.Date(System.currentTimeMillis()));

    try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt  = con.prepareStatement(
            "insert into pms_member(name,email,password,photo,tel,cdt) values(?,?,?,?,?,?)");
        ) {

      pstmt.setString(1, member.getName());
      pstmt.setString(2, member.getEmail());
      pstmt.setString(3, member.getPassword());
      pstmt.setString(4, member.getPhoto());
      pstmt.setString(5, member.getTel());
      pstmt.setDate(6, member.getRegisteredDate());

      pstmt.executeUpdate();
      System.out.println("member 등록");

    } catch (Exception e) {
      System.out.println("member 등록 중 오류");
      e.printStackTrace();
    }

  }
}
