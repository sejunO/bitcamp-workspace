package com.eomcs.util;

public interface List<E> {

  boolean add(E e);

  void add(int index, E element);

  E get(int index);

  E set(int index, E element);

  E remove(int index);

  Object[] toArray();

  E[] toArray(E[] arr);

  int size();

  Iterator<E> iterator();


}
