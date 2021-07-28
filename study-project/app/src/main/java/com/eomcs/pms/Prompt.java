package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  static Scanner keyboardScan = new Scanner(System.in);

  static String promptString(String msg) {
    System.out.print(msg);
    return keyboardScan.nextLine();
  }

  static int promptInt(String msg) {
    return Integer.parseInt(promptString(msg));
  }

  static Date promptDate(String msg) {
    return Date.valueOf(promptString(msg));
  }

  static void close() {
    keyboardScan.close();
  }

}
