package com.eomcs.basic.ex03;

class Exam0120{
    public static void main(String[] args) {
        //구구단 해보겠습니다.

        for(int i = 2; i < 10; i++) {
            for(int j = 2; j < 10; j++) {
                System.out.println(i + " x " + j + " = " + i*j);
            }
        }
    }
}