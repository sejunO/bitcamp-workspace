package com.eomcs.pms.web;

import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
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
public class MemberAddController {

  MemberService memberService;
  ServletContext servletContext;

  public MemberAddController(MemberService memberService, ServletContext servletContext) {
    this.memberService = memberService;
    this.servletContext = servletContext;
  }

  @RequestMapping("/member/add")
  public String execute(Member member,Part photoFile, HttpServletResponse response) throws Exception {


    String filename = UUID.randomUUID().toString();
    String saveFilePath = servletContext.getRealPath("/upload/" + filename);

    photoFile.write(saveFilePath);

    member.setPhoto(filename);

    generatePhotoThumbnail(saveFilePath);

    memberService.add(member);
    return "redirect:list";
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
