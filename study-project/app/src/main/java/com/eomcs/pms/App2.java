package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in);

    final int MAX_LENGTH = 100;
    int size = 0;

    int[] no = new int[MAX_LENGTH];
    String[] title = new String[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    Date[] startDate = new Date[MAX_LENGTH];
    Date[] endDate = new Date[MAX_LENGTH];
    String[] owner = new String[MAX_LENGTH];
    String[] members = new String[MAX_LENGTH];

    System.out.println("[프로젝트]");

    for(int i = 0; i < MAX_LENGTH; i++) {
      size++;

      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());
      System.out.print("프로젝트명? ");
      title[i] = keyboardScan.nextLine(); 
      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();
      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboardScan.nextLine());
      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboardScan.nextLine());
      System.out.print("만든이? ");
      owner[i] = keyboardScan.nextLine();
      System.out.print("팀원? ");
      members[i] = keyboardScan.nextLine();

      System.out.println();
      System.out.print("계속 입력하시겠습니까?(y/N)? ");
      String input = keyboardScan.nextLine();

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        break;
      }
      System.out.println();
    }


    System.out.println("------------------------------------------");

    for (int i = 0; i < size; i++) {
      // 번호, 프로젝트명, 시작일, 종료일, 만든이
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          no[i], title[i], startDate[i], endDate[i], owner[i]);
    }

  }
}
