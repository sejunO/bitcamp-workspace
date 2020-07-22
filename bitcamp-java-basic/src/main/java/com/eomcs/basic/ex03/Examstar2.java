package com.eomcs.basic.ex03;



public class Examstar2{
    final static int N = 5;
    
    public static void main(String[] args) {
      int i, j, k;
      
      
      for(i = 0; i < N; i++) {
          for(j = N; j > i+1; j--) {
            System.out.print(" ");
          }
          for(k = 0; k < i+1; k++) {
            System.out.print("*");
          }
          System.out.println("");
        }
    }
}
