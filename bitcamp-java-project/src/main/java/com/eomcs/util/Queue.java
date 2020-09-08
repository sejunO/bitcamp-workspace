package com.eomcs.util;

import java.util.NoSuchElementException;
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

  public boolean empty() {
    return this.size() == 0;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Queue<E> clone() {
    Queue<E> queue = new Queue<>();
    Object[] values = this.toArray();
    for (Object value : values) {
      queue.offer((E)value);
    }
    return queue;
  }

  public Iterator<E> iterator(){
    class QueueIterator implements Iterator<E> {

      Queue<E> queue;

      public QueueIterator() {
        this.queue = Queue.this.clone();
      }

      @Override
      public boolean hasNext() {
        return !queue.empty();
      }

      @Override
      public E next() {
        if (queue.empty())
          throw new NoSuchElementException();
        return queue.poll();
      }

    }
    return new QueueIterator();
  }

}
