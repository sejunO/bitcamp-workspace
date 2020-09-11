package com.eomcs.amini;

public class App {
  public static void main(String[] args) {
    BookInfo init = new BookInfo();
    init.init();
    MemberHandler memberHandler = new MemberHandler();
    BookHandler bookHandler = new BookHandler(init);


    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("\t\t\t1.  회원\n");
    System.out.println("\t\t\t2. 비회원\n");
    System.out.println("\t\t\t3.  본사\n");
    System.out.println("\t\t\t4.  점포\n");
    System.out.println("\t\t\t5. 라이더\n");
    System.out.println("\n");

  }

}


