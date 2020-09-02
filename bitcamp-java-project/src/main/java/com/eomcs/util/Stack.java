package com.eomcs.util;

import java.util.EmptyStackException;
import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

public class Stack extends MyLinkedList implements Cloneable {
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

    return get(size() - 1);
  }

  public boolean empty() {
    return this.size() == 0;
  }

  @Override
  public Stack clone() throws CloneNotSupportedException {
    return (Stack) super.clone();
  }
}
