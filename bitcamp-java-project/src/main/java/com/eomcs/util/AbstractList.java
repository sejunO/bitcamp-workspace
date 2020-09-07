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
    // TODO Auto-generated method stub
    return new ListIterator<E>(this);
  }

  private static class ListIterator<E> implements Iterator<E> {

    int cursor;

    List<E> list;

    public ListIterator(List<E> list) {
      this.list = list;
    }

    @Override
    public boolean hasNext() {
      return cursor < list.size();
    }

    @Override
    public E next() {
      if (cursor == list.size())
        throw new NoSuchElementException();
      return list.get(cursor++);
    }

  }




}
