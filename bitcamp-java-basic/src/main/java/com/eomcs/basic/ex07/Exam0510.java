package com.eomcs.basic.ex07;

import java.util.Properties;
import java.util.Set;

public class Exam0510 {


  public static void main(String[] args) throws Exception {
    for (int i = 0; i < args.length; i++) {
      System.out.println(args[i]);
    }
    String s1 = System.getProperty("naem");
    String s2 = System.getProperty("age");
    System.out.println(s1);
    System.out.println(s2);

    Properties props = System.getProperties();
    Set keyList = props.keySet();

    for (Object key : keyList) {
      System.out.printf("%s ---> %s \n",key, System.getProperty((String)key));
    }

  }
}
