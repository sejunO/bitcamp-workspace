package com.eomcs.jdbc.ex01;

import java.sql.Driver;
import java.sql.DriverManager;

public class Exam0110 {
  public static void main(String[] args) {
    try {
      Driver mariadbDriver = new org.mariadb.jdbc.Driver();
      DriverManager.registerDriver(mariadbDriver);
      System.out.println(mariadbDriver);

      Driver driver2 = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(driver2);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
