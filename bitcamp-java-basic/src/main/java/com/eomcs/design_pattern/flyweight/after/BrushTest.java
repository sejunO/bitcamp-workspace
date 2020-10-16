package com.eomcs.design_pattern.flyweight.after;

import java.util.Scanner;

public class BrushTest {



  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BrushPool brushPool = new BrushPool();

    while (true) {
      System.out.print("pattern? ");
      String pattern = sc.nextLine();
      System.out.print("length? ");
      int length = Integer.parseInt(sc.nextLine());

      Brush brush = brushPool.getBrush(pattern);
      brush.draw(length);
    }
  }
}

