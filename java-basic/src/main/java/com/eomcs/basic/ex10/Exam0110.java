package com.eomcs.basic.ex10;

public class Exam0110 {
  public static void main(String[] args) {
    long millis = System.currentTimeMillis();
    System.out.println("System.currentTimeMillis : " + millis);

    java.sql.Date d = new java.sql.Date(millis);
    System.out.println("java.sql.Date : " + d.toString());
  }

}
