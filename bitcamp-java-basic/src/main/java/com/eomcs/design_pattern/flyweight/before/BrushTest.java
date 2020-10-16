package com.eomcs.design_pattern.flyweight.before;

import java.util.Scanner;

public class BrushTest {



  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.print("pattern? ");
      String pattern = sc.nextLine();
      System.out.print("length? ");
      int length = Integer.parseInt(sc.nextLine());

      Brush brush = new Brush(pattern);
      brush.draw(length);
    }
  }
}

