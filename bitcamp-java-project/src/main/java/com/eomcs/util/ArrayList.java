package com.eomcs.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import com.eomcs.pms.domain.Board;

public class ArrayList<E> {


	  private static final int DEFAULT_CAPACITY = 5;
	  private Object[] elementData;
	  private int size;

	  public ArrayList() {
	    elementData = new Object[DEFAULT_CAPACITY];
	  }

	  public ArrayList(int initialCapacity) {
	    if (initialCapacity < DEFAULT_CAPACITY) {
	      elementData = new Object[DEFAULT_CAPACITY];
	    } else {
	      elementData = new Object[initialCapacity];
	    }
	  }

	  public boolean add(E e) {
	    if (size == elementData.length) {
	      grow();
	    }
	    elementData[size++] = e;
	    return true;
	  }

	  private void grow() {
	    int newCapacity = elementData.length + (elementData.length >> 1);
	    elementData = Arrays.copyOf(elementData, newCapacity);
	  }


	  public void add(int index, E element) {
	    if (size == elementData.length) {
	      grow();
	    }
	    if (index < 0 || index > size) {
	      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
	    }
	    for (int i = size; i > index ; i--) {
	      elementData[i] = elementData[i - 1];
	    }
	    elementData[index] = element;
	    size++;
	  }

	  @SuppressWarnings("unchecked")
	public E get(int index) {
	    if (index < 0 || index >= size) {
	      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
	    }
	    return (E) elementData[index];
	  }

	  @SuppressWarnings("unchecked")
	public E set(int index, E element) {
	    if (index < 0 || index >= size) {
	      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
	    }
	    Object old = elementData[index];
	    elementData[index] = element;
	    return (E) old;
	  }

	  @SuppressWarnings("unchecked")
	public E remove(int index) {
	    Object old = elementData[index];

	    System.arraycopy(
	        elementData, // 복사 대상
	        index + 1, // 복사할 항목의 시작 인덱스
	        elementData, // 목적지
	        index, // 복사 목적지 인덱스
	        this.size - (index + 1) // 복사할 항목의 개수
	        );
	    /*
	    for (int i = index; i < size - 1; i++) {
	      elementData[i] = elementData[i + 1];
	    }
	     */

	    size--;
	    elementData[size] = null;
	    // 쓰지 않는 인스턴스의 주소를 제거하여
	    // 가비지 될 수 있게 한다.

	    return (E) old;
	  }

	  public int size() {
	    return this.size;
	  }

	  public Object[] toArray() {
	    Object[] arr = Arrays.copyOf(elementData, this.size);
	    //System.out.println(elementData == arr); //false
	    return arr;
	  }
	  
	  
	  @SuppressWarnings("unchecked")
	  public E[] toArray(E[] arr) {
	    if (arr.length < size) {
	      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), this.size);
	    }
	    System.arraycopy(
	        this.elementData, 
	        0, 
	        arr, 
	        0,
	        this.size);
	    return arr;
	  }
	}



