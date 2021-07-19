package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardHandler3 {

  static final int MAX_LENGTH = 5;

  // Board 인스턴스의 주소를 저장할 레퍼런스 배열을 생성한다.
  static Board[] boards = new Board[MAX_LENGTH];
  static int size = 0;

  public static void add() {
    System.out.println("[새 게시글6]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    System.out.println("게시글을 등록하였습니다.");

    boards[size++] = board;
  }

  public static void list() {
    System.out.println("[게시글 목록6]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          boards[i].no, 
          boards[i].title, 
          boards[i].registeredDate, 
          boards[i].writer, 
          boards[i].viewCount,
          boards[i].like);
    }
  }
}







