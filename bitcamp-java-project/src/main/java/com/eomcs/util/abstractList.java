package com.eomcs.util;

public abstract class abstractList<E> {
  protected int size = 0;

  public int size() {
    return this.size;
  }

  public abstract boolean add(E e);

  public abstract void add(int index, E element);

  public abstract E get(int index);

  public abstract E set(int index, E element);

  public abstract E remove(int index);

  public abstract E[] toArray(E[] arr);

  public abstract Object[] toArray();

}
