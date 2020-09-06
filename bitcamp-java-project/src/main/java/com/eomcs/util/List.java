package com.eomcs.util;

public interface List<E> {

  public abstract boolean add(E e);

  public abstract void add(int index, E element);

  public abstract E get(int index);

  public abstract E set(int index, E element);

  public abstract E remove(int index);

  public abstract Object[] toArray();

  public abstract E[] toArray(E[] arr);

  public abstract int size();


}
