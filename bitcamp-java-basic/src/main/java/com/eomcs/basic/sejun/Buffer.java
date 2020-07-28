package com.eomcs.basic.sejun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Buffer {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int max = Integer.parseInt(bf.readLine());
    int[] arr = new int[max];
    
    for (int i = 0; i < max; i++) {
      arr[i] = Integer.parseInt(bf.readLine());
    }
    bf.close();
    
    for (int i = 0; i < max; i++) {
      System.out.printf("%d ",arr[i]);
    }
    
    System.out.println("");
    
    
    int sum = 0;
    double avg = 0;
    for (int i =0; i < max; i++) {
      sum = sum + arr[i];
    }
    avg = sum/max;
   
    System.out.printf("%d, %f", sum, avg);   
    
   
  }

}
