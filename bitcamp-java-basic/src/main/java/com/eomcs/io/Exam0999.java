package com.eomcs.io;

import java.io.File;

public class Exam0999 {
  public static void main(String[] args) {

    File file = new File(".");

    File[] names = file.listFiles(files -> (file.getName().endsWith(".java")));

    for (File files : names) {
      System.out.println(files);
    }

  }
}
