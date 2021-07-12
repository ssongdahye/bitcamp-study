package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

//1) 변경 준비
//2) 사용자에게 명령 프롬프트 출력
//3) 사용자의 명령을 입력 받아 출력
//4) 명령어 입력 받아 출력하는 것을 무한 반복
//5) exit나 quit 명령을 입력하면 반복 실행 중지
//6) /member/add와 /member/list 명령을 구분해 보자!
//7) /member/add 명령 처리
//8) /member/list 명령 처리
public class App {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in);

    // 최대 입력 개수
    final int LENGTH = 100;

    int[] memberNo = new int[LENGTH];
    String[] memberName = new String[LENGTH];
    String[] memberEmail = new String[LENGTH];
    String[] memberPassword = new String[LENGTH];
    String[] memberPhoto = new String[LENGTH];
    String[] memberTel = new String[LENGTH];
    Date[] memberRegisteredDate = new Date[LENGTH];

    int[] projectNo = new int[LENGTH];
    String[] projectTitle = new String[LENGTH];
    String[] projectContent = new String[LENGTH];
    Date[] projectStartDate = new Date[LENGTH];
    Date[] projectEndDate = new Date[LENGTH];
    String[] projectOwner = new String[LENGTH];
    String[] projectMembers = new String[LENGTH];

    int[] no = new int[LENGTH];
    String[] content = new String[LENGTH];
    Date[] deadline = new Date[LENGTH];
    String[] owner = new String[LENGTH];
    int[] status = new int[LENGTH];

    int memberSize = 0;
    int projectSize = 0;
    int size = 0;

    while(true) {
      System.out.print("명령> ");
      String input = keyboardScan.nextLine();

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if(input.equals("/member/add")) {
        System.out.println("[회원 등록]");

        System.out.print("번호? ");
        memberNo[memberSize] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("이름? ");
        memberName[memberSize] = keyboardScan.nextLine();

        System.out.print("이메일? ");
        memberEmail[memberSize] = keyboardScan.nextLine();

        System.out.print("암호? ");
        memberPassword[memberSize] = keyboardScan.nextLine();

        System.out.print("사진? ");
        memberPhoto[memberSize] = keyboardScan.nextLine();

        System.out.print("전화? ");
        memberTel[memberSize] = keyboardScan.nextLine();

        memberRegisteredDate[memberSize] = new java.sql.Date(System.currentTimeMillis());

        memberSize++;

        System.out.println();
      } else if(input.equals("/member/list")) {
        System.out.println("[회원 목록]");

        for (int i = 0; i < memberSize; i++) {
          // 번호, 이름, 이메일, 전화, 가입일
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              memberNo[i], memberName[i], memberEmail[i], memberTel[i], memberRegisteredDate[i]);
        }

        System.out.println();
      } else if(input.equals("/project/add")) {
        System.out.println("[프로젝트 등록]");
        System.out.print("번호? ");
        projectNo[projectSize] = Integer.valueOf(keyboardScan.nextLine());

        System.out.print("프로젝트명? ");
        projectTitle[projectSize] = keyboardScan.nextLine();

        System.out.print("내용? ");
        projectContent[projectSize] = keyboardScan.nextLine();

        System.out.print("시작일? ");
        projectStartDate[projectSize] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("종료일? ");
        projectEndDate[projectSize] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("만든이? ");
        projectOwner[projectSize] = keyboardScan.nextLine();

        System.out.print("팀원? ");
        projectMembers[projectSize] = keyboardScan.nextLine();

        projectSize++;

        System.out.println();
      } else if(input.equals("/project/list")) {
        System.out.println("[프로젝트 목록]");

        for (int i = 0; i < projectSize; i++) {
          // 번호, 프로젝트명, 시작일, 종료일, 만든이
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              projectNo[i], projectTitle[i], projectStartDate[i], projectEndDate[i], projectOwner[i]);
        }

        System.out.println();
      } else if(input.equals("/task/add")) {
        System.out.println("[작업 등록]");

        System.out.print("번호? ");
        no[size] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("내용? ");
        content[size] = keyboardScan.nextLine();

        System.out.print("마감일? ");
        deadline[size] = Date.valueOf(keyboardScan.nextLine());

        System.out.println("상태?");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        System.out.print("> ");
        status[size] = Integer.valueOf(keyboardScan.nextLine());

        System.out.print("담당자? ");
        owner[size] = keyboardScan.nextLine();

        size++;
        System.out.println(); // 빈 줄 출력
      } else if(input.equals("/task/list")) {
        System.out.println("[작업 목록]");

        for (int i = 0; i < size; i++) {
          String stateLabel = null;
          switch (status[i]) {
            case 1:
              stateLabel = "진행중";
              break;
            case 2:
              stateLabel = "완료";
              break;
            default:
              stateLabel = "신규";
          }
          // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              no[i], content[i], deadline[i], stateLabel, owner[i]);
        }

        System.out.println();
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      } 
    }
    keyboardScan.close();
  }
}
