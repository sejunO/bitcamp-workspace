package com.eomcs.jdbc.ex01;

import java.sql.Driver;
import java.sql.DriverManager;

public class Exam0120 {
  public static void main(String[] args) throws Exception {
    try {
      new org.mariadb.jdbc.Driver();
      new oracle.jdbc.driver.OracleDriver();
      new com.microsoft.sqlserver.jdbc.SQLServerDriver();

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


