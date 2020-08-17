// contains() 와 equals()의 관계
package com.eomcs.corelib.ex03;

import java.util.ArrayList;

public class Exam0210 {
  public static void main(String[] args) {


    ArrayList list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    print(list);

    // contains() 가 값을 비교할 때는
    // equals()의 결과가 true 인지 비교한다.
    // 결론!
    // => String 클래스의 경우 equals()를 오버라이딩 했기 때문에
    // 서로 다른 개체(s2와 s4)라도 값이 같으면 같은 객체로 간주한다.
    // => 그래서 다음 코드의 실행 결과는 true 이다.
    System.out.println(list.contains("aaa"));
    System.out.println(list.indexOf("ccc"));
    // true
  }

  static void print(ArrayList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ", ");
    }
    System.out.println();
  }
}
