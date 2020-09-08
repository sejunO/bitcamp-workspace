package com.eomcs.amini;

public class App {
  public static void main(String[] args) {
    BookInfo init = new BookInfo();
    init.init();
    MemberHandler memberHandler = new MemberHandler();
    BookHandler bookHandler = new BookHandler(init);

    while(true) {
      bookHandler.checkBook();
      String command = Prompt.inputString("명령 >");
      switch(command) {
        case "/member/add":  memberHandler.add(); break;
        case "/member/list": memberHandler.list(); break;

      }

    }

  }
}

