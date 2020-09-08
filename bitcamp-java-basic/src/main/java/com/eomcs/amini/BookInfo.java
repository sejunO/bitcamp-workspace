package com.eomcs.amini;

import java.util.ArrayList;

public class BookInfo {
  ArrayList<Book> bookList = new ArrayList<>();

  public void init() {
    Book book1 = new Book();
    book1.name = "refactoring";
    book1.price = "10000";
    book1.no = 1;
    book1.use = true;
    bookList.add(book1);

    Book book2 = new Book();
    book2.name = "java";
    book2.price = "15000";
    book2.no = 2;
    book2.use = true;
    bookList.add(book2);

    Book book3 = new Book();
    book3.name = "C";
    book3.price = "20000";
    book3.no = 3;
    book3.use = true;
    bookList.add(book3);

    Book book4 = new Book();
    book4.name = "python";
    book4.price = "25000";
    book4.no = 4;
    book4.use = false;
    bookList.add(book4);

    //    Book book5 = new Book();
    //    book1.name = "C++";
    //    book1.price = "30000";
    //    book1.no = 5;
    //    book1.use = true;
    //    bookList.add(book5);

  }

  public Book findByBook(String name) {
    for (int i = 0; i < bookList.size(); i++) {
      Book book = bookList.get(i);
      if (name.equalsIgnoreCase(book.name)) {
        return book;
      }
    }
    return null;
  }

  StringBuilder books = new StringBuilder("현재 대여가능한 책은 ");

  public StringBuilder findByInBook() {
    for (int i = 0; i < bookList.size(); i++) {
      Book book = bookList.get(i);
      if (book.use == true) {
        books.append(book.name + " ");
      }
    }
    return books;
  }
}



