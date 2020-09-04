package com.eomcs.util;

public interface List<E> {

  int size();

  boolean add(E e);

  void add(int index, E element);

  E get(int index);

  E set(int index, E element);

  E remove(int index);

  E[] toArray(E[] arr);

  Object[] toArray();

}
