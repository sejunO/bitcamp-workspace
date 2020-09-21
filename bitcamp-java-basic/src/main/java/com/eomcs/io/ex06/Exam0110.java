package com.eomcs.io.ex06;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    BufferdInputStream in = new BufferdInputStream("temp/jls10.pdf");
    BufferdOutputStream out = new BufferdOutputStream("temp/jls10_3.pdf");
    long startTime = System.currentTimeMillis(); // 밀리초
    int count = 0;
    int b;
    while ((b = in.read()) != -1) {
      out.write(b);
      count++;
    }
    out.flush();
    long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
    System.out.println(count);
    in.close();
  }


}
