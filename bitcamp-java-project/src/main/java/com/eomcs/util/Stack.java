package com.eomcs.util;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack<E> extends LinkedList<E> implements Cloneable {
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

  @Override
  public Iterator<E> iterator() {
    try {
      return new StackIterator<E>(this.clone());
    } catch (Exception e) {
      throw new RuntimeException("스택 복제 오류");
    }
  }
  private static class StackIterator<E> implements Iterator<E> {
    Stack<E> stack;

    public StackIterator(Stack<E> stack) {
      this.stack = stack;
    }

    @Override
    public boolean hasNext() {
      return !stack.empty();
    }

    @Override
    public E next() {
      if (stack.empty())
        throw new NoSuchElementException();
      return stack.pop();
    }

  }


}
