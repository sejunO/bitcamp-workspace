package com.eomcs.algorithm.data_structure.stack;

import java.util.EmptyStackException;
import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

public class MyStack extends MyLinkedList {
  public Object push(Object item) {
    this.add(item);
    return item;
  }

  public Object pop() {
    if (size() == 0) {
      throw new EmptyStackException();
    }

    return remove(size() - 1);
  }

  public Object peek() {

    return get(size() -1);
  }
}
