package com.eomcs.io;

import java.io.File;
import java.io.FileFilter;

public class Exam0999 {
  public static void main(String[] args) {

    File file = new File(".");

    File[] names = file.listFiles(new FileFilter() {
      @Override
      public boolean accept(File file) {
        if (file.getName().endsWith(".java") && file.isFile())
          return true;
        return false;
      }
    });

    for (File files : names) {
      System.out.println(files);
    }

  }
}
