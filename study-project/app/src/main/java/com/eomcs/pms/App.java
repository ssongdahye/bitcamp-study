/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.eomcs.pms;

public class App {
  public static void main(String[] args) {
    /*
    System.out.println("[회원]");
    System.out.println("번호: 101");
    System.out.println("이름: 홍길동");
    System.out.println("이메일: hong@test.com");
    System.out.println("암호: 1111");
    System.out.println("사진: hong.png");
    System.out.println("전화: 1111-2222");
    System.out.println("가입일: 2020-0101");
     */

    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.println("[회원]");
    System.out.print("번호? ");
    int no = keyboard.nextInt();
    keyboard.nextLine();    //키보드 메모리에 남아 있는 찌꺼기 엔터 코드 제거

    System.out.print("이름? ");
    String name = keyboard.nextLine();

    System.out.print("이메일? ");
    String email = keyboard.nextLine();

    System.out.print("암호? ");
    String password = keyboard.nextLine();

    System.out.print("사진? ");
    String photo = keyboard.nextLine();

    System.out.print("전화? ");
    String tel = keyboard.nextLine();

    //System.out.print("가입일? ");
    //String registeredDate = keyboard.nextLine();
    //java.util.Date today = new java.util.Date();
    java.sql.Date registeredDate= new java.sql.Date(System.currentTimeMillis());

    System.out.println("----------------------------------------");

    //System.out.print("번호: " + token1 + "\n이름: " + token2 + "\n이메일: " + token3
    //    + "\n암호: " + token4 + "\n사진: " + token5 + "\n전화: " + token6
    //    + "\n가입일: " );
    //System.out.printf("%1$tY-%1$tm-%1$td", today);

    //keyboard.close();

    System.out.printf("번호: %d\n" , no);
    System.out.printf("이름: %s\n" , name);
    System.out.printf("이메일: %s\n" , email);
    System.out.printf("암호: %s\n" , password);
    System.out.printf("사진: %s\n" , photo);
    System.out.printf("전화: %s\n" , tel);
    System.out.printf("가입일: %s\n" , registeredDate);

  }
}
