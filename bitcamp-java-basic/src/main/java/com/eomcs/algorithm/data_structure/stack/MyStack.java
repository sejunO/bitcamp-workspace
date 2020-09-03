package com.eomcs.algorithm.data_structure.stack;

import java.util.EmptyStackException;
import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

public class MyStack<E> extends MyLinkedList<E> implements Cloneable {
  public E push(E item) {
    this.add(item);
    return item;
  }

  public E pop() {
    if (size() == 0) {
      throw new EmptyStackException();
    }

    return remove(size() - 1);
  }

  public E peek() {

    return get(size() - 1);
  }

  public boolean empty() {
    return this.size() == 0;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() throws CloneNotSupportedException {
    Stack<E> stack = new Stack<>();
    Object[] values = this.toArray();
    for (Object value : values) {
      stack.push((E) value);
    }
    return stack;
  }



}
