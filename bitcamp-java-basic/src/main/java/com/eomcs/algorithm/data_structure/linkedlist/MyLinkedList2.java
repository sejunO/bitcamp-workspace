package com.eomcs.algorithm.data_structure.linkedlist;

public class MyLinkedList2 {

  Node first;
  Node last;
  int size = 0;

  static class Node {
    Object value;
    Node next;

    public Node() {}
    public Node(Object value) {
      this.value = value;
    }
  }



  public boolean add(Object e) {
    Node node = new Node();
    node.value = e;
    if (first == null) {
      first = node;
    } else {
      last.next = node;
    }
    last = node;
    size++;
    return true;
  }

  public void add(int index, Object e) {
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    Node node = new Node(e);
    if (index == 0) {
      node.next = first;
      first = node;
      return;
    }
    Node cursor = this.first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    node.next = cursor.next;
    cursor.next = node;

    if (index == this.size) {
      last = node;
    }
    size++;

  }

  public Object get(int index) {
    Node cursor = this.first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  public Object remove(int index) {

    if (index == 0) {
      Node old = first;
      first = first.next;
      old.next = null;
      return old;
    }
    Node cursor = this.first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    cursor.next = cursor.next.next;
    if (cursor.next == null) {
      last = cursor;
    }
    size--;

    return cursor.next.value;

  }




}