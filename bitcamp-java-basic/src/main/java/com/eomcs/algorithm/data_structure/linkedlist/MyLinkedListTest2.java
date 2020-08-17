package com.eomcs.algorithm.data_structure.linkedlist;

public class MyLinkedListTest2 {
  public static void main(String[] args) throws Exception {
    MyLinkedList2 list = new MyLinkedList2();

    list.add("aaa");
    list.remove(0);
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("hhh");

    print(list);

  }

  static void print(MyLinkedList2 list) {
    for (int i = 0; i < list.size; i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
  }

  static void print2(Object[] arr) {
    for (Object obj : arr) {
      System.out.print(obj + ",");
    }
    System.out.println();
  }
}
