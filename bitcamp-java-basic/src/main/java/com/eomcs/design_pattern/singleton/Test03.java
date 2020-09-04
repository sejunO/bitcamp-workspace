// Singleton 연습 : 김밥 인스턴스를 한 개만 생성하도록 Singleton 패턴을 적용하라. 
package com.eomcs.design_pattern.singleton;

//인스턴스를 딱 한 개만 생성하여 공유하고 싶다면,
// Singleton 설계 방식으로 클래스를 정의하라!
//
class Kimbap {
  String bap;
  String material;

  static Kimbap Kimbap1;

  private Kimbap() {}

  public static Kimbap getInstance() {
    if (Kimbap1 == null) {
      Kimbap1 = new Kimbap();
    }
    return Kimbap1;
  }

}

public class Test03 {
  public static void main(String[] args) {
    Kimbap bap1 = Kimbap.getInstance();
    Kimbap bap2 = Kimbap.getInstance();

    System.out.println(bap1 == bap2);
  }
}
