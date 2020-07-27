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
    System.out.println("입력하세");
    bw.write("입력한값은\n");
    
    String s = bf.readLine();
    bw.write(s);
    bw.flush();
    bw.close();
   
    
  }

}
