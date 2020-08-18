package com.eomcs.corelib.ex07;

import java.util.HashSet;
import java.util.Iterator;

public class asdf {
  public static void main(String[] args) {
    HashSet set = new HashSet();
    set.add("a"); set.add("b"); set.add("c");
    Iterator it = set.iterator();

    while (it.hasNext()) {
      it.remove();
    }
  }

}
