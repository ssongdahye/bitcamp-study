package com.eomcs.algorithm.quiz;

public class Test_01 {

  static int countEvenNumber(int value) {
    int result = 0;
    int n = value;

    while (n != 0 ) {
      if((n % 2) == 0)
        result++;
      n /= 10;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(countEvenNumber(1238694636));

  }
}
