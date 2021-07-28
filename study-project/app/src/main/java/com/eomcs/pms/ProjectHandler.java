package com.eomcs.pms;

public class ProjectHandler {

  static final int MAX_LENGTH = 5;
  static int size = 0;

  static Project[] projects = new Project[MAX_LENGTH];

  static void add() {
    System.out.println("[프로젝트 등록]");
    Project project = new Project();

    project.no = Prompt.promptInt("번호? ");
    project.title = Prompt.promptString("프로젝트명? "); 
    project.content = Prompt.promptString("내용? ");
    project.startDate = Prompt.promptDate("시작일? ");
    project.endDate = Prompt.promptDate("종료일? ");
    project.owner = Prompt.promptString("만든이? ");
    project.members = Prompt.promptString("팀원? ");

    projects[size++] = project;
  }

  static void list() {
    System.out.println("[프로젝트 목록]");

    for (int i = 0; i < size; i++) {
      // 번호, 프로젝트명, 시작일, 종료일, 만든이
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          projects[i].no, 
          projects[i].title, 
          projects[i].startDate, 
          projects[i].endDate, 
          projects[i].owner);
    }
  }
}
