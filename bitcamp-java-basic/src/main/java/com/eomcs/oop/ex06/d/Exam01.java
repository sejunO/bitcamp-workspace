// 다형적 변수와 오버라이딩
package com.eomcs.oop.ex06.d;

public class Exam01 {
  public static void main(String[] args) {
    A a = new A();
    a.m(); // A의 멤버 호출. OK!
    //((A2)a).x(); // A 객체를 A2 객체라 우기면, 컴파일러는 통과! 실행은 오류!
    System.out.println("--------------------");

    A2 a2 = new A2();
    a2.m(); // A2가 수퍼 클래스인 A의 메서드 호출! OK!
    a2.x(); // A2의 메서드 호출! OK!
    System.out.println("----------------------");

    A a3 = new A2();
    a3.m(); // A2의 m() 호출.
    // 레퍼런스가 하위 클래스의 인스턴스를 가리킬 때,
    // => 레퍼런스를 통해 호출하는 메서드는
    //    레퍼런스가 실제 가리키는 하위 클래스에서 찾아 올라 간다.
    //
    // 그렇다고 해서 A2에서 추가한 메서드를 호출할 수는 없다.
    // => 즉 레퍼런스의 클래스를 벗어나서 사용할 수는 없다.
    //    컴파일러가 허락하지 않는다.
    //a3.x(); // 컴파일 오류!

    // 물론 a3가 실제 A2 객체를 가리키기 때문에
    // A2로 형변환을 수행한 후에는 A2의 멤버를 사용할 수 있다.
    ((A2)a3).x(); // OK!

    System.out.println("----------------------");
  }
}






