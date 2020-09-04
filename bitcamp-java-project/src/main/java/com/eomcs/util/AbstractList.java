package com.eomcs.util;

public abstract class AbstractList<E> implements List<E> {
  protected int size = 0;

  @Override
  public int size() {
    return this.size;
  }

}
