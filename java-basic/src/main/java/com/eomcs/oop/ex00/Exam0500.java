package com.eomcs.oop.ex00;

import com.eomcs.oop.ex00.util.Calculator;

// Exam0210번 코드 가져와서 단계별로 해보기
// 1) Calculator 클래스 만들기
// 2) result를 Calculator로 옮기기
// 3) result를 인스턴스 변수로 바꾸기
// 4) 유지보수 할 때 찾기 쉽게 따로 Calculator 클래스 만들기
public class Exam0500 {

  public static void main(String[] args) {
    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(2);
    c2.plus(3);
    c1.plus(3);
    c2.multiple(2);
    c1.minus(1);
    c2.plus(7);
    c1.multiple(7);
    c2.divide(4);
    c1.divide(3);
    c2.minus(5);

    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);
  }


}
