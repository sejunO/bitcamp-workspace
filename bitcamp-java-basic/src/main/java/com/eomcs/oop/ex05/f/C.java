package com.eomcs.oop.ex05.f;

public class C extends B {
  int v3;

  C() {
    System.out.println("C() 생성자!");
    // 만약 개발자가 수퍼 클래스의 생성자를 호출하는 명령을 작성할 때
    // 그 전에 다른 코드가 있다면 컴파일러는 오류를 발생시킨다.
    //super(); // 따라서 수퍼 클래스 생성자를 호출하는 명령은 반드시 첫 문장으로 와야 한다.
  }
}
