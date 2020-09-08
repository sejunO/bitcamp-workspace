package com.eomcs.amini;

public class BookHandler {
  BookInfo bookInfo;

  public BookHandler(BookInfo bookInfo) {
    this.bookInfo = bookInfo;
  }
  public void borrowBook() {
  }

  public void checkBook() {
    System.out.println(bookInfo.findByInBook() + "입니다");
  }


}
