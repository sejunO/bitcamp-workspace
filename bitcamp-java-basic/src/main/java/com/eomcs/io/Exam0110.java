package com.eomcs.io;

import java.io.File;
import java.io.FileFilter;

public class Exam0110 {
  public static void main(String[] args) {
    File file = new File(".");

    class MyFileFilter implements FileFilter {
      @Override
      public boolean accept(File pathname) {
        if (file.getName().endsWith(".java") && file.isFile())
          return true;
        return false;
      }

    }

    FileFilter filter = new MyFileFilter();

    File[] names = file.listFiles(filter);
    for (File files : names) {
      System.out.println(files);
    }

  }
}
