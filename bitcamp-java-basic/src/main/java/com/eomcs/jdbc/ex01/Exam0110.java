package com.eomcs.jdbc.ex01;

import java.sql.Driver;
import java.sql.DriverManager;

public class Exam0110 {
  public static void main(String[] args) {
    try {
      Driver mariadbDriver = new org.mariadb.jdbc.Driver();

      Driver oracleDriver = new oracle.jdbc.driver.OracleDriver();

      Driver mssqlDriver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();

      DriverManager.registerDriver(mariadbDriver);
      DriverManager.registerDriver(oracleDriver);
      DriverManager.registerDriver(mssqlDriver);

      System.out.println(mariadbDriver);
      System.out.println(oracleDriver);

      Driver driver1 = DriverManager.getDriver("jdbc:sqlserver:");
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
