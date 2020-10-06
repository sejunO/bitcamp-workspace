// 계산기 클라이언트 만들기 - 4단계: 사용자로부터 계산식을 입력 받아서 서버에 전달한다.
package com.eomcs.net.ex11.step06;

public class CalculatorClient {
  public static void main(String[] args) {
    new ClientProcessor().service();
  }
}


