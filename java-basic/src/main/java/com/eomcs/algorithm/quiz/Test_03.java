package com.eomcs.algorithm.quiz;

public class Test_03 {

  static void changeValuePosition(int[] values) {
    int half = values.length >> 1;
    int addIndex = values.length & 1;
    int temp = 0;
    for (int i = 0; i < half; i++) {
      temp = values[i];
      values[i] = values[i + half];
      values[i + half + addIndex] = temp;
    }
  }

  public static void main(String[] args) {
    int[] values = {2, 4, 5, 6, 4, 3, 7, 8};
    changeValuePosition(values);

    for (int v : values) {
      System.out.print(v + ",");
    }
  }

}
