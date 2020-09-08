package com.eomcs.util;

import java.util.NoSuchElementException;

public abstract class AbstractList<E> implements List<E> {

  public int size;

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public Iterator<E> iterator() {
    class ListIterator implements Iterator<E> {

      int cursor;

      @Override
      public boolean hasNext() {
        return cursor < /*AbstractList.this.*/size();
      }

      @Override
      public E next() {
        if (cursor == size())
          throw new NoSuchElementException();
        return /*AbstractList.this.*/get(cursor++);
      }

    }
    return new ListIterator();
  }

}
