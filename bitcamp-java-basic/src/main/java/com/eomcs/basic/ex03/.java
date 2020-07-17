package com.eomcs.basic.ex03;

class Exam0340 { 
    public static void main(String[] args) {

        //4바이트 : 최대 7자리 소수점을 제외한 숫자의 개수
         System.out.println(12*0.1);
         System.out.println("");
        System.out.println(999.9999f);
        System.out.println(999999.9f);
        System.out.println(9.999999f);
        System.out.println("");
        System.out.println(999.99994f);
        System.out.println(99999999.4f);
        System.out.println(9.9999994f);

        System.out.println(987654321.1234567);
        System.out.println(987654381123456.7);
        System.out.println(9.876543211234567);
        System.out.println("");

        //8바이트 : 최대 16자리 소수점을 제외한 숫자의 개수
        System.out.println(987654321.123456789);
        System.out.println(987654381123456.789);
        System.out.println(9.87654321123456789);

        // 초과하는 수는 반올림 되거나 잘린다.
        // IEEE 754 규격에 따라 2진수 변환시 일부 값이 정확히 변환되지 않음.

    }
}