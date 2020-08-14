package com.eomcs.corelib.ex03;

public class MyArrayListTest3 {

  public static void main(String[] args) {
    ArrayList list1 = new ArrayList();
    list1.add("aaa");
    list1.add("bbb");
    list1.add("ccc");
    list1.add("ddd");
    list1.add("eee");

    ArrayList list2 = new ArrayList();
    list2.add("fff");
    list2.add("ggg");
    list2.add("hh");
    list2.add("iii");
    print(list1);
    print(list2);

  }
  static void print(ArrayList list) {

    for (int i = 0; i < list.size(); i++) {
      String str = (String) list.get(i);
      System.out.printf(str + ",");
    }
    System.out.println();

  }
}
