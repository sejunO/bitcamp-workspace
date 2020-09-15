// 디렉토리 생성
package com.eomcs.io;

import java.io.File;

public class Exam0320 {

  public static void main(String[] args) throws Exception {

    File dir = new File("temp");

    // 하위 디렉토리 생성하기
    dir.list();
    if (dir.delete()) {
      System.out.println("temp/a 디렉토리를 생성하였습니다.");
    } else {
      System.out.println("temp/a 디렉토리를 생성할 수 없습니다.");
    }
  }

}
