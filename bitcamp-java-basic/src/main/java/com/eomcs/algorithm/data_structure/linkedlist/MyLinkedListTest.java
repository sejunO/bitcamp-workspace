package com.eomcs.algorithm.data_structure.linkedlist;

public class MyLinkedListTest {
  public static void main(String[] args) {
    MyLinkedList<String> list = new MyLinkedList<>();

    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");

    print(list);

    list.add(4, "eee");
    list.add(5, "fff");
    list.add("hhh");
    print(list);

    list.remove(4);
    list.remove(0);
    list.remove(4);
    print(list);
    list.set(1, "xxx");
    list.set(0, "zzz");
    list.set(3, "yyy");
    print(list);
    print2(list.toArray());

  }

  static void print(MyLinkedList<String> list) {
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
