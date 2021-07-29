package com.eomcs.pms;

public class TaskHandler {
  static final int MAX_LENGTH = 5;
  static int size = 0;

  static Task[] tasks = new Task[MAX_LENGTH];

  static void add() {
    System.out.println("[작업 등록]");
    Task task = new Task();

    task.no = Prompt.promptInt("번호? ");
    task.content = Prompt.promptString("내용? ");
    task.deadline = Prompt.promptDate("마감일? ");
    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    task.status = Prompt.promptInt("> ");
    task.owner = Prompt.promptString("담당자? ");

    tasks[size++] = task;
  }

  static void list() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < size; i++) {
      String stateLabel = null;
      switch (tasks[i].status) {
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
          tasks[i].no, 
          tasks[i].content, 
          tasks[i].deadline, 
          stateLabel, 
          tasks[i].owner);
    }
  }
}
