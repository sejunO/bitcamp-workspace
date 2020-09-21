package com.eomcs.io.ex01;

import java.io.File;

public class Exam0210 {
  public static void main(String[] args) {
    File currentDir = new File("./Hello2.java");

    System.out.println("폴더명: " + currentDir.getName());
    System.out.println("경로: " + currentDir.getPath());
    System.out.println("절대경로: " + currentDir.getAbsolutePath());
    System.out.println("총크기" + currentDir.getTotalSpace());
    System.out.println("남은크기: " + currentDir.getFreeSpace());

    System.out.println("디렉토리여부: " + currentDir.isDirectory());
    System.out.println("파일여부: " + currentDir.isFile());
  }
}
