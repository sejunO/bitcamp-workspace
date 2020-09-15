package com.eomcs.io;

import java.io.File;

public class Exam09999 {
  public static void main(String[] args) {

    File dir = new File(".");

    File[] names = dir.listFiles(file -> {
      if (file.getName().endsWith(".java") && file.isFile())
        return true;
      return false;
    });

    for (File files : names) {
      System.out.println(files);
    }

  }
}
