package com.eomcs.algorithm.data_structure.queue;

import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

public class MyQueue extends MyLinkedList {
  public boolean offer(Object e) {
    return add(e);
  }

  public Object poll() {
    if (this.size() == 0) {
      return null;
    }
    return this.remove(0);
  }

  public Object peek() {
    return this.get(0);
  }
}
