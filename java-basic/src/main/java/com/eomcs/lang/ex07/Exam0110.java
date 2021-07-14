package com.eomcs.lang.ex07;

import java.util.Scanner;

//1단계: 공백 출력 코드를 메서드로 추출하기 printSpaces
//2단계: 별을 출력하는 코드를 메서드로 추출하기 printStars
//3단계: while 대신 for 문 사용하기
//4단계: 공백 계산 식을 메서드로 추출하기 getSpaceLength
public class Exam0110 {

  static void printSpaces(int len) {
    for (int i=0; i<len; i++) {
      System.out.print(" ");
    }    
  }

  static void printStars(int len) {
    for (int starCnt=0; starCnt<len; starCnt++) {
      System.out.print("*");
    }    
  }

  static int getSpaceLength(int totalStar, int displayStar) {
    return (totalStar-displayStar)/2;
  }

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();


    for (int starLen = 1; starLen <= len; starLen += 2) {
      // 별 앞에 공백 출력
      printSpaces(getSpaceLength(len, starLen));
      // 별 출력
      printStars(starLen);
      // 출력 줄 바꾸기
      System.out.println();

    }
  }
}