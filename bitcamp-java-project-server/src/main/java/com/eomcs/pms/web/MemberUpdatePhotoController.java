package com.eomcs.pms.web;

import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.MemberService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;
@Controller
public class MemberUpdatePhotoController {

  MemberService memberService;
  ServletContext servletContext;

  public MemberUpdatePhotoController(MemberService memberService, ServletContext servletContext) {
    this.memberService = memberService;
    this.servletContext = servletContext;
  }

  @RequestMapping("/member/updatePhoto")
  public String execute(int no, Part photoFile) throws Exception {

    Member member = new Member();
    member.setNo(no);

    // 회원 사진 파일 저장
    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String saveFilePath = servletContext.getRealPath("/upload/" + filename);
      photoFile.write(saveFilePath);
      member.setPhoto(filename);

      // 회원 사진의 썸네일 이미지 파일 생성하기
      generatePhotoThumbnail(saveFilePath);
    }

    if (member.getPhoto() == null) {
      throw new Exception("사진을 선택하지 않았습니다.");
    }

    memberService.update(member);
    return "redirect:detail?no=" + member.getNo();
  }

  private void generatePhotoThumbnail(String saveFilePath) {
    try {
      Thumbnails.of(saveFilePath)
      .size(30, 30)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_30x30";
        }
      });

      Thumbnails.of(saveFilePath)
      .size(120, 120)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_120x120";
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
