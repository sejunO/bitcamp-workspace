package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberUpdateCommand implements Command {

  List<Member> memberList;

  public MemberUpdateCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");
    String name = null;
    String email = null;
    String password = null;
    String photo = null;
    String tel = null;

    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("select name, email, password, photo, tel"
            + " from pms_member"
            + " where no= " + no);
        ResultSet rs = pstmt.executeQuery()){

      if (rs.next()) {
        name = rs.getString("name");
        email = rs.getString("email");
        password = rs.getString("password");
        photo = rs.getString("photo");
        tel = rs.getString("tel");

      } else {
        System.out.println("그건 없는데용");
        return;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

    name = Prompt.inputString(String.format("이름(%s)? ", name));
    email = Prompt.inputString(String.format("이메일(%s)? ", email));
    password = Prompt.inputString("암호? ");
    photo = Prompt.inputString(String.format("사진(%s)? ", photo));
    tel = Prompt.inputString(String.format("전화(%s)? ", tel));

    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }
    try (Connection con =DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement pstmt = con.prepareStatement("update pms_member set name=?,email=?,password=?,photo=?,tel=?"
            + " where no=?")){

      pstmt.setString(1, name);
      pstmt.setString(2, email);
      pstmt.setString(3, password);
      pstmt.setString(4, photo);
      pstmt.setString(5, tel);
      pstmt.setInt(6, no);


      int count = pstmt.executeUpdate();

      if (count == 0) {
        System.out.println("그건 없는데용");
      } else {
        System.out.println("변경 !");
      }



    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("회원을 변경하였습니다.");
  }
}
