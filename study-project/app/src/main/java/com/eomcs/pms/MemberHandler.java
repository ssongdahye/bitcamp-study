package com.eomcs.pms;

import java.sql.Date;

public class MemberHandler {
  static final int MAX_LENGTH = 5;
  static int size = 0;

  static Member[] members = new Member[MAX_LENGTH];

  static void add() {

    System.out.println("[회원 등록]");
    Member member = new Member();

    member.no = Prompt.promptInt("번호? ");
    member.name = Prompt.promptString("이름? ");
    member.email = Prompt.promptString("이메일? ");
    member.password = Prompt.promptString("암호? ");
    member.photo = Prompt.promptString("사진? ");
    member.tel = Prompt.promptString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    members[size++] = member;

  }

  static void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %tY-%5$tm-%5$td\n", 
          members[i].no,
          members[i].name,
          members[i].email,
          members[i].tel,
          members[i].registeredDate);
    }
  }
}
