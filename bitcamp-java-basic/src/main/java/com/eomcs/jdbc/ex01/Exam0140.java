package com.eomcs.jdbc.ex01;

import java.sql.Driver;
import java.sql.DriverManager;

public class Exam0140 {
  public static void main(String[] args) throws Exception {
    System.out.printf("java.home=%s\n", System.getProperty("java.home"));
    System.out.printf("java.home=%s\n", System.getProperty("user.home"));

    System.setProperty("jdbc.drivers", "com.eomcs.jdbc.ex1.MyDriver:com.eomcs.jdbc.ex01.MyDriver");
    System.out.printf("java.home=%s\n", System.getProperty("jdbc.drivers"));


    try {
      //      new org.mariadb.jdbc.Driver();
      //      new oracle.jdbc.driver.OracleDriver();
      //      new com.microsoft.sqlserver.jdbc.SQLServerDriver();

      //      Class.forName("org.mariadb.jdbc.Driver");
      //      Class.forName("oracle.jdbc.driver.OracleDriver");
      //      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      Driver driver1 = DriverManager.getDriver("jdbc:sqlserver://");
      Driver driver2 = DriverManager.getDriver("jdbc:mariadb:");
      Driver driver3 = DriverManager.getDriver("jdbc:oracle:thin:");

      System.out.println(driver1);
      System.out.println(driver2);
      System.out.println(driver3);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


