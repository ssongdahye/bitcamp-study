package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;

public class TaskListHandler extends AbstractTaskHandler {

  public TaskListHandler(ProjectPrompt projectPrompt) {
    super(projectPrompt);
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void execute() {
    System.out.println("[작업 목록]");

    Project project = projectPrompt.promptProject();
    if (project == null) {
      System.out.println("작업 등록을 취소합니다.");
      return;
    }

    printTasks(project);
  }
}





