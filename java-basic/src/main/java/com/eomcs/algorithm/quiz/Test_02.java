package com.eomcs.algorithm.quiz;

public class Test_02 {

  static int maxDiff(int[] values) {

    int result = 0;

    for(int i = 1; i < values.length; i++) {
      if(Math.abs(values[i] - values [i - 1]) > result) {
        result = Math.abs(values[i] - values [i+1]);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(maxDiff(new int[]{2, 4, 1, 0}));
  }

}
