package com.eomcs.corelib.ex03;

public class MyArrayList {
  private Object[] elementData = new Object[5];
  private int size;

  public int size() {
    return this.size;
  }

  public boolean add(Object e) {
    if (size == elementData.length) {
      grow();
    }
    elementData[size++] = e;
    return true;
  }

  private void grow() {
    Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
    for (int i = 0; i < elementData.length; i++) {
      newArray[i] = elementData[i];
    }
    elementData = newArray;

  }

  public void add(int index, Object element) {
    if (size == elementData.length) {
      grow();
    }
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않음");
    }
    for (int i = size; i > index; i--) {
      elementData[i] = elementData[i-1];
    }
    elementData[index] = element;
    size++;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않음");
    }
    return elementData[index];
  }

  public Object set(int index, Object element) {
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않음");
    }
    Object old = elementData[index];
    elementData[index] = element;
    return old;
  }

  public Object remove(int index) {
    Object old = elementData[index];
    for (int i = index; i < size - 1; i++) {
      elementData[i] = elementData[i + 1];
    }
    size--;
    elementData[size] = null;
    return old;
  }
}
