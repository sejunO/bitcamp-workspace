package com.eomcs.algorithm.data_structure.queue;

import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

public class MyQueue<E> extends MyLinkedList<E> {
  public boolean offer(E e) {
    return add(e);
  }

  public E poll() {
    if (this.size() == 0) {
      return null;
    }
    return this.remove(0);
  }

  public E peek() {
    return this.get(0);
  }

  @Override
  public MyQueue clone() {

  }
}
