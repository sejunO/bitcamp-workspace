package com.eomcs.util;

import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

public class Queue<E> extends MyLinkedList<E> {
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

  @SuppressWarnings("unchecked")
  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    Queue<E> queue = new Queue<>();

    for (Object value : this.toArray()) {
      queue.offer((E) value);
    }

    return queue;
  }
}
