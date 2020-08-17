package com.eomcs.algorithm.data_structure.linkedlist;

public class MyLinkedList {

  Node first;
  Node last;
  int size;

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
      node.next = this.first;
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
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    Node cursor = this.first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  public Object remove(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    size--;

    if (index == 0) {
      Node old = first;
      first = old.next;
      old.next = null;
      return old;
    }

    Node cursor = this.first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    Node old = cursor.next;
    cursor.next = old.next;
    old.next = null;

    if (cursor.next == null) {
      last = cursor;
    }

    return old;
  }

  public Object set(int index, Object e) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    Node cursor = this.first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
    cursor.value = e;
    return old;
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.size];
    Node cursor = first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.value;
      cursor = cursor.next;
    }
    return arr;

  }








}