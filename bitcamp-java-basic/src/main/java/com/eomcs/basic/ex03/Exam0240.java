package com.eomcs.basic.ex03;

class Exam0240 {
    public static void main(String[] args){
        
        int a = 0xaaaaaaaa;
        int b = -0xaaaaaaaa;

        System.out.println(0xc1);
        System.out.println(5 + (-3));

        // 00000011 <= +3 2진수
        // 11111101 <= -3 2진수(2의 보수)
        // 10000011 <= -3 Sign-Magnitude
        // 01111100<= -3 Excess-K : K = 2**(비트수-1) - 1
       

        // 0111 1011  <= +123 2진수
        // 1000 0101 <= -123 2진수(2의 보수)
        // 1111 1011 <= -123 Sign-Magnitude
        // 0000 0010<= -123 Excess-K : K = 2**(비트수-1) - 1
        

        // 10101010 10101010 10101010 10101010   <= +aaaaaaaa 2진수
        // 01010101 01010101 01010101 01010110   <= -aaaaaaaa 2진수(2의 보수)
        // 55 55 55 56 <= 16진수
        // 1111 1011 <= -aaaaaaaa Sign-Magnitude
        // 0000 0010<= -aaaaaaaa Excess-K : K = 2**(비트수-1) - 1
        
    }
}
